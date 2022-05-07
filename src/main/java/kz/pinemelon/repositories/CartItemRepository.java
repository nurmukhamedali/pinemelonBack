package kz.pinemelon.repositories;

import kz.pinemelon.domain.Cart;
import kz.pinemelon.domain.CartItem;
import kz.pinemelon.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByCartAndProduct(Cart cart, Product product);
}
