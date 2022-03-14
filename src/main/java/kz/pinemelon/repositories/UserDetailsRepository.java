package kz.pinemelon.repositories;

import kz.pinemelon.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User, String> {

}
