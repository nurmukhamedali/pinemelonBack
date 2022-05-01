package kz.pinemelon.controller;

import com.fasterxml.jackson.annotation.JsonView;
import kz.pinemelon.entities.*;
import kz.pinemelon.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin(origins="http://localhost:8080")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("customer/{customerId}/cart")
    @JsonView(View.CustomerView.Internal.class)
    public Cart getCart(
            @PathVariable("customerId") Customer customer){
        return customer.getCart();
    }

    @GetMapping("cart")
    @JsonView(View.CartView.Public.class)
    List<Cart> getAll() {
        return cartService.listCart();
    }

    @GetMapping("cart/{id}")
    @JsonView(View.CartView.Internal.class)
    public Cart get(
            @PathVariable("id") Cart cart){
        return cart;
    }

    @PostMapping("cart")
    @JsonView(View.CartView.Internal.class)
    public Cart create(
            @RequestBody Cart cart
    ) {
        return cartService.create(cart);
    }

    @PutMapping("cart/{id}")
    @JsonView(View.CartView.Internal.class)
    public Cart update(
            @PathVariable("id") Cart cartFromDB,
            @RequestBody Cart cart
    ){
        return cartService.update(cartFromDB, cart);
    }

    @DeleteMapping("cart/{id}")
    @JsonView(View.CartView.Internal.class)
    public void delete(
            @PathVariable("id") Cart cart){
        cartService.delete(cart);
    }

}
