package kz.pinemelon.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.pinemelon.domain.Cart;
import kz.pinemelon.domain.Product;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ItemForm {
    private Long id;
    private int quantity;
    private Long product;
    private Long cart;

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

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public Long getCart() {
        return cart;
    }

    public void setCart(Long cart) {
        this.cart = cart;
    }
}
