package kz.pinemelon.controller;

import com.fasterxml.jackson.annotation.JsonView;
import kz.pinemelon.entities.*;
import kz.pinemelon.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin(origins="*")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @GetMapping("cart/{cartId}/items")
    @JsonView(View.CartItemView.Internal.class)
    public List<CartItem> getAll(@PathVariable("cartId") Cart cart) {
        return cart.getItems();
    }

    @GetMapping("item")
    @JsonView(View.CartItemView.Public.class)
    public List<CartItem> getAll() {
        return cartItemService.listCartItems();
    }

    @GetMapping("item/{id}")
    @JsonView(View.CartItemView.Internal.class)
    public CartItem get(
            @PathVariable("id") CartItem cartItem){
        return cartItem;
    }

    @PostMapping("item")
    public CartItem create(
            @RequestBody CartItem cartItem
    ) {
        int amount = cartItem.getAmount();
        System.out.println(amount);
        return cartItemService.create(cartItem);
    }

    @PutMapping("item/{id}")
    @JsonView(View.CartItemView.Public.class)
    public CartItem update(
            @PathVariable("id") CartItem cartItemFromDB,
            @RequestBody CartItem cartItem
    ){
        return cartItemService.update(cartItemFromDB, cartItem);
    }

    @DeleteMapping("item/{id}")
    @JsonView(View.CartItemView.Public.class)
    public void delete(
            @PathVariable("id") CartItem cartItem){
        cartItemService.delete(cartItem);
    }

}
