package kz.salikhanova.healthapp.service;

import kz.salikhanova.healthapp.model.User;



public interface UserService {

    void save(User user);

    User findByUsername(String username);
    
    User findByEmail(String email);
    
    User getCurrentUser();
}
