Vue.component("header-pm", {
    template:
        '<header class="p-3 mb-3 border-bottom">\n' +
        '        <div class="container">\n' +
        '            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">\n' +
        '                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">\n' +
        '                    <h3>PineMelon</h3>\n' +
        '                </a>\n' +
        '    \n' +
        '                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">\n' +
        '                    <li><a href="#" class="nav-link px-2 link-dark">Inventory</a></li>\n' +
        '                    <li><a href="#" class="nav-link px-2 link-dark">Customers</a></li>\n' +
        '                    <li><a href="#" class="nav-link px-2 link-dark">Products</a></li>\n' +
        '                </ul>\n' +
        '    \n' +
        '                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">\n' +
        '                    <input type="search" class="form-control" placeholder="Search..." aria-label="Search">\n' +
        '                </form>\n' +
        '    \n' +
        '                <div class="dropdown text-end">\n' +
        '                    <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">\n' +
        '                        <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">\n' +
        '                    </a>\n' +
        '                    <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">\n' +
        '                        <li><a class="dropdown-item" href="#">New project...</a></li>\n' +
        '                        <li><a class="dropdown-item" href="#">Settings</a></li>\n' +
        '                        <li><a class="dropdown-item" href="#">Profile</a></li>\n' +
        '                        <li><hr class="dropdown-divider"></li>\n' +
        '                        <li><a class="dropdown-item" href="#">Sign out</a></li>\n' +
        '                    </ul>\n' +
        '                </div>\n' +
        '            </div>\n' +
        '        </div>\n' +
        '    </header>'
})

var header = new Vue({
    el: '#header',
    template: '<header-pm />'
})