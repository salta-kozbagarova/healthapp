package kz.salikhanova.healthapp.dao;

import kz.salikhanova.healthapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
