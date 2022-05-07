package kz.pinemelon.repositories;

import kz.pinemelon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<User, Long> {
}
