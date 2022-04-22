package kz.pinemelon.controller;

import kz.pinemelon.entities.CartItem;
import kz.pinemelon.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cartItem")
@CrossOrigin(origins="http://localhost:8080")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @GetMapping
    List<CartItem> getAll() {
        return cartItemService.listCartItems();
    }

    @GetMapping("{id}")
    public CartItem get(
            @PathVariable("id") CartItem cartItem){
        return cartItem;
    }

    @PostMapping
    public CartItem create(
            @RequestBody CartItem cartItem
    ) {
        return cartItemService.create(cartItem);
    }

    @PutMapping("{id}")
    public CartItem update(
            @PathVariable("id") CartItem cartItemFromDB,
            @RequestBody CartItem cartItem
    ){
        return cartItemService.update(cartItemFromDB, cartItem);
    }

    @DeleteMapping("{id}")
    public void delete(
            @PathVariable("id") CartItem cartItem){
        cartItemService.delete(cartItem);
    }

}
