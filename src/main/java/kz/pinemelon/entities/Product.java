package kz.pinemelon.entities;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table
public class Product extends Component {
    @JsonView({View.ComponentView.Public.class, View.CartItemView.Internal.class, View.CustomerView.Internal.class})
    private String brand;
    @JsonView({View.ComponentView.Public.class, View.CartItemView.Internal.class, View.CustomerView.Internal.class})
    private double price;
    @JsonView({View.ComponentView.Public.class, View.CartItemView.Internal.class, View.CustomerView.Internal.class})
    private int amount;

    public String getBrand() {return brand;}

    public void setBrand(String brand) {this.brand = brand;}

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}

    public int getAmount() {return amount;}

    public void setAmount(int amount) {this.amount = amount;}
}
