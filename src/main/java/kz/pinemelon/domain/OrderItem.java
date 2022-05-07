package kz.pinemelon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="product_id", unique = true)
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name="order_id")
    @JsonIgnore
    private Order order;
}