package kz.pinemelon.domain;



import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "cart")
    @JsonIgnore
    private User customer;

    @OneToMany(mappedBy = "cart")
    @JsonIgnore
    private List<CartItem> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}
