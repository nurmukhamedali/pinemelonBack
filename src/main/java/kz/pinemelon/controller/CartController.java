package kz.pinemelon.controller;

import kz.pinemelon.entities.*;
import kz.pinemelon.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
@CrossOrigin(origins="http://localhost:8080")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    List<Cart> getAll() {
        return cartService.listCart();
    }

    @GetMapping("{id}")
    public Cart get(
            @PathVariable("id") Cart cart){
        return cart;
    }

    @PostMapping
    public Cart create(
            @RequestBody Cart cart
    ) {
        return cartService.create(cart);
    }

    @PutMapping("{id}")
    public Cart update(
            @PathVariable("id") Cart cartFromDB,
            @RequestBody Cart cart
    ){
        return cartService.update(cartFromDB, cart);
    }

    @DeleteMapping("{id}")
    public void delete(
            @PathVariable("id") Cart cart){
        cartService.delete(cart);
    }

}
