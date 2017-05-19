package kz.salikhanova.healthapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        return "/site/home";
    }
}
