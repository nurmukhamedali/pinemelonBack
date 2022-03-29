package kz.pinemelon.controller;

import com.fasterxml.jackson.annotation.JsonView;
import kz.pinemelon.entities.Cart;
import kz.pinemelon.entities.Category;
import kz.pinemelon.entities.Product;
import kz.pinemelon.entities.Views;
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
    @JsonView(Views.shortData.class)
    List<Cart> getAll() {
        return cartService.listCart();
    }

    @GetMapping("{id}")
    @JsonView(Views.fullData.class)
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
