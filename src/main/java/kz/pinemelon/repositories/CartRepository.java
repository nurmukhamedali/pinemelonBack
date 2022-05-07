package kz.pinemelon.repositories;

import kz.pinemelon.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
