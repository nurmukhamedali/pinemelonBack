package kz.pinemelon.controller;

import kz.pinemelon.domain.Cart;
import kz.pinemelon.domain.User;
import kz.pinemelon.form.CartForm;
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

    @GetMapping("/carts")
    List<Cart> getAll() {
        return cartService.listCart();
    }

    @GetMapping("/carts/{id}")
    public CartForm get(
            @PathVariable("id") Cart cart){
        return cartService.get(cart);
    }

    @GetMapping("cart")
    public CartForm getCustomerCart(@RequestParam("customerId") User customer){
        return cartService.get(customer.getCart());
    }
}
