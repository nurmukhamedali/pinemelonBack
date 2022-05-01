package kz.pinemelon.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({View.CartItemView.Public.class, View.CustomerView.Internal.class})
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id", unique = true)
    @JsonView({View.CartItemView.Internal.class, View.CustomerView.Internal.class})
    private Product product;

    @JsonView({View.CartItemView.Public.class, View.CustomerView.Internal.class})
    private int amount;

    @ManyToOne
    @JoinColumn(name="cart_id")
    @JsonBackReference
    private Cart cart;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
