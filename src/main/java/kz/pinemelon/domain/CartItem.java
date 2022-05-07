package kz.pinemelon.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "UniqueProductPerCart", columnNames = { "cart_id", "product_id" })
})
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false)
    @JsonIgnore
    private Cart cart;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
