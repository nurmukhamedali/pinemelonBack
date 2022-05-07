package kz.pinemelon.services;

import kz.pinemelon.domain.Cart;
import kz.pinemelon.domain.CartItem;
import kz.pinemelon.domain.User;
import kz.pinemelon.form.CartForm;
import kz.pinemelon.form.ItemDetails;
import kz.pinemelon.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductService productService;

    public List<Cart> listCart(){
        return cartRepository.findAll();
    }

    public Cart create(User customer){
        Cart cart = new Cart();
        cart.setCustomer(customer);
        return cartRepository.save(cart);
    }

    public CartForm get(Cart cart){
        CartForm cartForm = new CartForm();
        cartForm.setId(cart.getId());
        cartForm.setTotalItems(cart.getItems().size());
        cartForm.setTotalProducts(countTotalProducts(cart.getItems()));
        cartForm.setTotalCost(countTotalCost(cart.getItems()));
        cartForm.setItems(getItemForms(cart.getItems()));
        return cartForm;
    }
    public void delete(Cart cart){
        cartRepository.delete(cart);
    }

    private double countTotalCost(List<CartItem> items){
        double total = 0;
        for (CartItem item: items) {
            total += item.getQuantity() * item.getProduct().getPrice();
        }
        return total;
    }

    private int countTotalProducts(List<CartItem> items){
        int total = 0;
        for (CartItem item: items) {
            total += item.getQuantity();
        }
        return total;
    }

    private List<ItemDetails> getItemForms(List<CartItem> items){
        List<ItemDetails> itemForms = new ArrayList<>();
        for (CartItem item: items) {
            ItemDetails form = new ItemDetails();
            form.setId(item.getId());
            form.setQuantity(item.getQuantity());
            form.setProduct(productService.getDetails(item.getProduct()));
            itemForms.add(form);
        }
        return itemForms;
    }
}
