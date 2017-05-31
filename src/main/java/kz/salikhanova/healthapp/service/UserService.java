package kz.salikhanova.healthapp.service;

import java.util.List;

import kz.salikhanova.healthapp.model.User;



public interface UserService {

    void save(User user);

    User findByUsername(String username);
    
    User findByEmail(String email);
    
    User getCurrentUser();
    
    void updateGeneralData(User user);
    
    User findByUsernameAndIdNotIn(String username, List<Long> id);
    
    User findByEmailAndIdNotIn(String email, List<Long> id);
    
    void setNewPassword(Long userId, String password);
}
