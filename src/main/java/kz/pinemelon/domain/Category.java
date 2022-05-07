package kz.pinemelon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;
    protected String image;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    @ToString.Exclude
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
