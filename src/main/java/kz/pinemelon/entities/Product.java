package kz.pinemelon.entities;

import javax.persistence.*;

@Entity
@Table
public class Product extends Component {
    private String brand;
    private double price;
    private int amount;

    public String getBrand() {return brand;}

    public void setBrand(String brand) {this.brand = brand;}

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}

    public int getAmount() {return amount;}

    public void setAmount(int amount) {this.amount = amount;}
}
