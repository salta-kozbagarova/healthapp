package kz.salikhanova.healthapp.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kz.salikhanova.healthapp.service.DrugstoreService;
import kz.salikhanova.healthapp.service.UserService;

@Controller
@RequestMapping("/drugstore")
public class DrugstoreController {
	
	@Resource(name = "userService")
    private UserService userService;
	
	@Resource(name="drugstoreService")
	private DrugstoreService drugstoreService;
	
	@RequestMapping(value = "/rate-price", method=RequestMethod.GET)
	public @ResponseBody String ratePrice(Long id, Short price) {
		drugstoreService.ratePrice(id, price);
		return "success";
	}

	@RequestMapping(value = "/rate-drugs-availability", method=RequestMethod.GET)
	public @ResponseBody String rateDrugsAvailability(Long id, Short drugsAvailability) {
		drugstoreService.rateDrugsAvailability(id, drugsAvailability);
		return "success";
	}

}
