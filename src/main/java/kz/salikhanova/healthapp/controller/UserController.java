package kz.salikhanova.healthapp.controller;

import kz.salikhanova.healthapp.form.PasswordForm;
import kz.salikhanova.healthapp.model.User;
import kz.salikhanova.healthapp.service.SecurityService;
import kz.salikhanova.healthapp.service.UserService;
import kz.salikhanova.healthapp.validator.PasswordValidator;
import kz.salikhanova.healthapp.validator.UserValidator;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

	@Resource(name = "userService")
    private UserService userService;

	@Resource(name = "securityService")
    private SecurityService securityService;
	
	@Autowired
    private UserValidator userValidator;
	
	@Autowired
    private PasswordValidator passwordValidator;
	
	@RequestMapping(value = "/sign-up-form", method = RequestMethod.GET)
    public String signUpForm(Model model) {
        model.addAttribute("user",new User());
        return "/site/sign-up";
    }
    
    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("user") User user,
    		BindingResult signupResult, Model model) {
    	userValidator.validate(user, signupResult);
        if (signupResult.hasErrors()) {
            return "/site/sign-up";
        }

        userService.save(user);

        securityService.autoLogin(user.getUsername(), user.getConfirmPassword());

        return "redirect:/profile";
    }
    
    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public String signIn(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }
        model.addAttribute("user",new User());
        return "/site/sign-in";
    }
    
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model) {
    	model.addAttribute("user",userService.getCurrentUser());
    	model.addAttribute("passwordForm",new PasswordForm());
        return "/site/profile";
    }
    
    @RequestMapping(value = "/update-profile", method = RequestMethod.POST)
    public String updateProfile(@ModelAttribute("user") User user,
    		BindingResult signupResult, Model model) {
    	userValidator.validate(user, signupResult);
        if (signupResult.hasErrors()) {
        	model.addAttribute("passwordForm",new PasswordForm());
            return "/site/profile";
        }
        userService.updateGeneralData(user);
        model.addAttribute("passwordForm",new PasswordForm());
        return "/site/profile";
    }
    
    @RequestMapping(value = "/set-password", method = RequestMethod.POST)
    public String setPassword(@RequestParam Long id, @ModelAttribute("passwordForm") PasswordForm passwordForm,
    		BindingResult passwordResult, Model model) {
    	passwordValidator.validate(passwordForm, passwordResult);
        if (passwordResult.hasErrors()) {
        	model.addAttribute("user",userService.getCurrentUser());
            return "/site/profile";
        }
        userService.setNewPassword(id, passwordForm.getPassword());
        model.addAttribute("user",userService.getCurrentUser());
        //securityService.autoLogin(userService.getCurrentUser().getUsername(), passwordForm.getPassword());
        return "/site/profile";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "/site/admin";
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        return "/site/home";
    }
    
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model) {
        return "/site/about";
    }
    
    
}
