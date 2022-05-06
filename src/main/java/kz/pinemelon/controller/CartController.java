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

    @GetMapping("cart")
    @JsonView(View.CustomerView.Internal.class)
    public Cart getCustomerCart(@RequestParam("customerId") Customer customer){
        return customer.getCart();
    }

    @GetMapping("/carts")
    @JsonView(View.CartView.Public.class)
    List<Cart> getAll() {
        return cartService.listCart();
    }

    @GetMapping("/carts/{id}")
    @JsonView(View.CartView.Internal.class)
    public Cart get(
            @PathVariable("id") Cart cart){
        return cart;
    }

    @PostMapping("/carts")
    @JsonView(View.CartView.Internal.class)
    public Cart create(
            @RequestBody Cart cart
    ) {
        return cartService.create(cart);
    }

    @PutMapping("/carts/{id}")
    @JsonView(View.CartView.Internal.class)
    public Cart update(
            @PathVariable("id") Cart cartFromDB,
            @RequestBody Cart cart
    ){
        return cartService.update(cartFromDB, cart);
    }

    @DeleteMapping("/carts/{id}")
    @JsonView(View.CartView.Internal.class)
    public void delete(
            @PathVariable("id") Cart cart){
        cartService.delete(cart);
    }

}
