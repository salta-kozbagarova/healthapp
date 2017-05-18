package kz.salikhanova.healthapp.controller;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kz.salikhanova.healthapp.dao.CalculatedDrugstoreRatingDao;
import kz.salikhanova.healthapp.model.CalculatedDrugstoreRating;
import kz.salikhanova.healthapp.model.Comment;
import kz.salikhanova.healthapp.model.Drugstore;
import kz.salikhanova.healthapp.service.CalculatedDrugstoreRatingService;
import kz.salikhanova.healthapp.service.DrugstoreService;
import kz.salikhanova.healthapp.service.HospitalService;
import kz.salikhanova.healthapp.service.PolyclinicService;



@Controller
@RequestMapping("/places")
public class PlaceController {
	
	@Resource(name="drugstoreService")
	private DrugstoreService drugstoreService;
	
	@Resource(name="hospitalService")
	private HospitalService hospitalService;
	
	@Resource(name="polyclinicService")
	private PolyclinicService polyclinicService;
	
	@Resource(name="appParams")
	private Properties appParams;
	
	@RequestMapping(value = "/drugstores", method = RequestMethod.GET)
    public String drugstores(Model model) {
		model.addAttribute("drugstores", drugstoreService.findAll());
		model.addAttribute("maxRateValue", appParams.getProperty("app.places.maxRateValue"));
        return "/place/drugstores";
    }
	
	@RequestMapping(value = "/hospitals", method = RequestMethod.GET)
    public String hospitals(Model model) {
		model.addAttribute("hospitals", hospitalService.findAll());
		model.addAttribute("maxRateValue", appParams.getProperty("app.places.maxRateValue"));
        return "/place/hospitals";
    }
	
	@RequestMapping(value = "/polyclinics", method = RequestMethod.GET)
    public String polyclinics(Model model) {
		model.addAttribute("polyclinics", polyclinicService.findAll());
		model.addAttribute("maxRateValue", appParams.getProperty("app.places.maxRateValue"));
        return "/place/polyclinics";
    }
	
	@RequestMapping(value = "/drugstore", method = RequestMethod.GET)
    public String drugstore(@RequestParam(value = "id", required = true) Long id, Model model) {
		model.addAttribute("drugstore", drugstoreService.findOne(id));
		model.addAttribute("maxRateValue", appParams.getProperty("app.places.maxRateValue"));
		model.addAttribute("comment", new Comment());
        return "/place/drugstore";
    }
	
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String drugstore(Model model) {
        return "/site/contacts";
    }

}
