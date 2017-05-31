package kz.salikhanova.healthapp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kz.salikhanova.healthapp.form.PasswordForm;

@Component
public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PasswordForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PasswordForm passwordForm = (PasswordForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validation.required");
        if (passwordForm.getPassword().length() < 4 || passwordForm.getPassword().length() > 32) {
            errors.rejectValue("password", "validation.password.size");
        }

        if (!passwordForm.getConfirmPassword().equals(passwordForm.getPassword())) {
            errors.rejectValue("confirmPassword", "validation.password.different");
        }
	}

}
