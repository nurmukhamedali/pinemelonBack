package kz.pinemelon.services;

import kz.pinemelon.entities.Cart;
import kz.pinemelon.entities.CartItem;
import kz.pinemelon.repositories.CartRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public Cart create(Cart cart){
        cart.setUpdateDate(LocalDateTime.now());
        return cartRepository.save(cart);
    }

    public List<Cart> listCart(){
        return cartRepository.findAll();
    }

    public Cart update(Cart cart, Cart temp){
        // refresh values of old by values of temp
        BeanUtils.copyProperties(temp, cart, "id");
        cart.setUpdateDate(LocalDateTime.now());
        return cartRepository.save(cart);
    }
    public void delete(Cart cart){
        cartRepository.delete(cart);
    }
}
