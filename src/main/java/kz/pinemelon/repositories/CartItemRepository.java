package kz.pinemelon.repositories;

import kz.pinemelon.entities.Cart;
import kz.pinemelon.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
