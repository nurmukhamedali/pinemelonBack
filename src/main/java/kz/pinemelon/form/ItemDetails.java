package kz.pinemelon.form;

public class ItemDetails {
    private Long id;
    private int quantity;
    private Long cart;
    private ProductForm product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductForm getProduct() {
        return product;
    }

    public void setProduct(ProductForm product) {
        this.product = product;
    }

    public Long getCart() {
        return cart;
    }

    public void setCart(Long cart) {
        this.cart = cart;
    }
}
