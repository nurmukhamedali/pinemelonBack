
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

    template: modal_form,
    methods: {
        save_product: function (){
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

Vue.component('product-row', {
    props: ['product', 'editMethod', 'products'],
    template:
        '<div class="col">' +
            '<div class="card shadow-sm">' +
                product_image +
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