package kz.salikhanova.healthapp.service;

import kz.salikhanova.healthapp.dao.RoleDao;
import kz.salikhanova.healthapp.dao.UserDao;
import kz.salikhanova.healthapp.model.Role;
import kz.salikhanova.healthapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

/**
 * Implementation of {@link UserService} interface.
 *
 * @author Saltanat Alikhanova
 */

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name = "securityService")
    private SecurityService securityService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<Role>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
    
    @Override
	public User findByEmail(String email) {
    	return userDao.findByEmail(email);
	}

	@Override
	public User getCurrentUser() {
		String username = securityService.findLoggedInUsername();
		User user = findByUsername(username);
		return user;
	}

	@Override
	public void updateGeneralData(User user) {
		User curUser = userDao.findOne(user.getId());
		Set<Role> roles = curUser.getRoles();
		String password = curUser.getPassword();
        user.setRoles(roles);
        user.setPassword(password);
		userDao.save(user);
	}

	@Override
	public User findByUsernameAndIdNotIn(String username, List<Long> id) {
		return userDao.findByUsernameAndIdNotIn(username, id);
	}

	@Override
	public User findByEmailAndIdNotIn(String email, List<Long> id) {
		return userDao.findByEmailAndIdNotIn(email, id);
	}

	@Override
	public void setNewPassword(Long userId, String password) {
		User user = userDao.findOne(userId);
		if(user!=null){
			user.setPassword(bCryptPasswordEncoder.encode(password));
			userDao.save(user);
		}
	}
}
