package kz.salikhanova.healthapp.validator;

import kz.salikhanova.healthapp.model.User;
import kz.salikhanova.healthapp.service.UserService;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class UserValidator implements Validator {
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private Pattern pattern;
	private Matcher matcher;

	@Resource(name = "userService")
    private UserService userService; 

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "validation.required");
        if (user.getUsername().length() < 4 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "validation.username.size");
        }

        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "validation.username.duplicate");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "validation.required");
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(user.getEmail());
        if (!matcher.matches()) {
        	errors.rejectValue("email", "validation.email.incorrect", "Enter a correct email");
        }  
        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "validation.email.duplicate");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validation.required");
        if (user.getPassword().length() < 4 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "validation.password.size");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "validation.password.different");
        }
    }
}
