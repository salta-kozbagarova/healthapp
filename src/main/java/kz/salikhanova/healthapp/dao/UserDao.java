package kz.salikhanova.healthapp.dao;

import kz.salikhanova.healthapp.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByUsernameAndIdNotIn(String username, List<Long> id);
    User findByEmail(String email);
    User findByEmailAndIdNotIn(String email, List<Long> id);
}
