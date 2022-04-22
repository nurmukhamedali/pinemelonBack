package kz.pinemelon.services;

import kz.pinemelon.entities.Cart;
import kz.pinemelon.entities.CartItem;
import kz.pinemelon.repositories.CartItemRepository;
import kz.pinemelon.repositories.CartRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartItemService {
    @Autowired
    CartItemRepository cartItemRepository;

    public CartItem create(CartItem cartItem){
        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> listCartItems(){
        return cartItemRepository.findAll();
    }

    public CartItem update(CartItem cartItem, CartItem tempItem){
        // refresh values of old by values of temp
        BeanUtils.copyProperties(tempItem, cartItem, "id");
        return cartItemRepository.save(cartItem);
    }
    public void delete(CartItem cartItem){
        cartItemRepository.delete(cartItem);
    }

}
