package kz.pinemelon.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.pinemelon.domain.CartItem;
import kz.pinemelon.domain.User;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

public class CartForm {
    private Long id;
    private Double totalCost;
    private int totalItems;
    private int totalProducts;
    private List<ItemDetails> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<ItemDetails> getItems() {
        return items;
    }

    public void setItems(List<ItemDetails> items) {
        this.items = items;
    }

    public int getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }
}
