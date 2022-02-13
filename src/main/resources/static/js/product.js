
var productApi = Vue.resource('/product{/id}')


Vue.component('product-form', {
    props: ['products', 'productAttr', 'showModal'],
    data: function () {
        return {
            id: '',
            name: '',
            brand: '',
            description: '',
            price: '',
            amount: '',
            enabled: '',
        }
    },
    watch: {
        productAttr: function (newVal, oldVal){
            this.id = newVal.id;
            this.name = newVal.name;
            this.brand = newVal.brand;
            this.description = newVal.description;
            this.price = newVal.price;
            this.amount = newVal.amount;
            this.enabled = newVal.enabled;
        }
    },

    template:
        '<div v-if="showModal"><transition name="modal"><div class="modal-mask"><div class="modal-wrapper"><div class="modal-dialog" role="document"><div class="modal-content">\n' +
            '<div class="modal-header">' +
                '<h5 v-if="this.id" class="modal-title">Edit Product</h5>' +
                    '<h5 v-else class="modal-title">New Product</h5>' +
                '<v-btn type="button" class="close btn-close" @click="close"/>' +
            '</div>' +
            '<div class="modal-body">' +
                '<input type="text" placeholder="Enter product name" v-model="name"/> ' +
                '<input type="text" placeholder="Enter product brand" v-model="brand"/> ' +
                '<input type="text" placeholder="Enter product description" v-model="description"/> ' +
                '<input type="text" placeholder="Enter product price" v-model="price"/> ' +
                '<input type="text" placeholder="Enter product amount" v-model="amount"/> ' +
                '<input type="checkbox" v-model="enabled"/> ' +
            '</div>' +
            '<div class="modal-footer">' +
                '<button type="button" class="btn btn-primary" @click="save">Save</button>' +
                '<button type="button" class="btn btn-secondary" @click="close">Close</button>' +
            '</div>' +
        '</div></div></div></div></transition></div>',
    methods: {
        save: function (){
            let product = {
                name: this.name,
                brand: this.brand,
                description: this.description,
                price: this.price,
                amount: this.amount,
                enabled: this.enabled,
            };
            if(this.id){
                productApi.update({id: this.id}, product).then(result =>
                    result.json().then(data => {
                        let index = this.products.findIndex((item) => item.id === this.id);
                        this.products.splice(index, 1, data)
                    })
                )
            } else {
                productApi.save({}, product).then(result =>
                    result.json().then(data => {
                        this.products.push(data);
                        this.name = '';
                    })
                )
            }
            this.id = '';
            this.showModal = false;
        },
        close: function(){
            this.id = '';
            this.showModal = false;
        }
    }
})

Vue.component('product-image', {
    template:
        '<svg class="bd-placeholder-img card-img-top" width="100%" height="225" ' +
            'xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">' +
            '<title>Placeholder</title>' +
            '<rect width="100%" height="100%" fill="#55595c"></rect>' +
            '<text x="50%" y="50%" fill="#eceeef">Thumbnail</text>' +
        '</svg>'
})

Vue.component('product-row', {
    props: ['product', 'editMethod', 'products'],
    template:
        '<div class="col">' +
            '<div class="card shadow-sm">' +
                '<product-image />' +
                '<div class="card-body">' +
                    '<h5 class="card-title">' +
                        '<div class="d-flex justify-content-between align-items-center">' +
                            '<div>#{{ product.id }} {{ product.name }}</div>' +
                            '<span>{{ product.price }} $</span>' +
                        '</div>' +
                    '</h5>' +
                    '<h6 class="card-subtitle mb-2 text-muted">{{ product.brand }}</h6>' +
                    '<div class="d-flex justify-content-between align-items-center">' +
                        '<span class="badge bg-primary rounded-pill">{{ product.amount }}</span>' +
                        '<div class="btn-group">' +
                            '<button class="btn btn-outline-secondary" type="button" v-on:click="edit">' + edit + '</button>' +
                            '<button class="btn btn-outline-secondary" type="button" v-on:click="del">' + remove + '</button>' +
                        '</div>' +
                    '</div>' +
                '</div>' +
            '</div>' +
        '</div>',


    methods: {
        edit: function () {
            this.editMethod(this.product);
        },
        del : function (){
            productApi.remove({id: this.product.id}).then(result => {
                if(result.ok){
                    // **DELETE** from page
                    this.products.splice(
                        this.products.indexOf(this.product), 1
                    )
                }
            })
        },
    }
})

Vue.component('products-list', {
    props: ['products'],
    data: function () {
        return {
            product: null,
            showModal: false
        }
    },
    template:
        '<div>' +
            '<product-form :products="products" :productAttr="product" :showModal="showModal" />' +
            '<div class="album py-5 bg-light">' +
                '<div class="container">' +
                    '<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">' +
                        '<product-row v-for="product in products" :key="product.id" ' +
                            ':product="product" :editMethod="editMethod" :products="products"/>' +
                    '</div>' +
                '</div>' +
            '</div>' +
        '</div>',
    created: function(){
        productApi.get().then(result =>
            result.json().then(data =>
                data.forEach(product => this.products.push(product))
            )
        )
    },
    methods: {
        editMethod: function (product) {
            this.showModal = true;
            this.product = product;
        }
    }
})

var msg = new Vue({
    el: '#product',
    template: '<products-list :products="products"/>',
    data: {
        products: [],
    }
})