var modal_form = '' +
    '<div v-if="showModal"><transition name="modal"><div class="modal-mask"><div class="modal-wrapper"><div class="modal-dialog" role="document"><div class="modal-content">\n' +
    '<div class="modal-header">' +
        '<h5 v-if="this.id" class="modal-title">Edit Product</h5>' +
        '<h5 v-else class="modal-title">New Product</h5>' +
        '<v-btn type="button" class="close btn-close" @click="close"/>' +
    '</div>' +
    '<div class="modal-body">' +
        '<form>\n' +
            '<div class="form-group">\n' +
                '<label for="productName">Product name</label>\n' +
                '<input type="text" class="form-control" id="productName" placeholder="Name" v-model="name">\n' +
            '</div>\n' +
            '<div class="form-group">\n' +
                '<label for="productBrand">Brand name</label>\n' +
                '<input type="text" class="form-control" id="productBrand" placeholder="Brand" v-model="brand">\n' +
            '</div>\n' +
            '<div class="form-group">\n' +
                '<label for="productDesc">Description</label>\n' +
                '<input type="text" class="form-control" id="productDesc" placeholder="Description" v-model="description">\n' +
            '</div>\n' +
            '<div class="form-group">\n' +
                '<label for="productPrice">Price</label>\n' +
                '<input type="text" class="form-control" id="productPrice" placeholder="Price" v-model="price">\n' +
            '</div>\n' +
            '<div class="form-group">\n' +
                '<label for="productAmount">Amount</label>\n' +
                '<input type="text" class="form-control" id="productAmount" placeholder="Amount" v-model="amount">\n' +
            '</div>\n' +
            '<div class="form-check">\n' +
                '<input type="checkbox" class="form-check-input" id="productStatus" v-model="enabled">\n' +
                '<label class="form-check-label" for="productStatus">Is Active</label>\n' +
            '</div>\n' +
        '</form>' +
    '</div>' +
    '<div class="modal-footer">' +
    '<button type="submit" class="btn btn-primary" @click="save_product">Submit</button>\n' +
    '<button type="button" class="btn btn-secondary" @click="close">Close</button>' +
    '</div>' +
    '</div></div></div></div></transition></div>';
var product_image = '' +
    '<svg class="bd-placeholder-img card-img-top" width="100%" height="225" ' +
        'xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">' +
        '<title>Placeholder</title>' +
        '<rect width="100%" height="100%" fill="#55595c"></rect>' +
        '<text x="50%" y="50%" fill="#eceeef">Thumbnail</text>' +
    '</svg>';