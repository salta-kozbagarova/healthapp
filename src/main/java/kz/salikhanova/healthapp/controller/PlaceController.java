package kz.salikhanova.healthapp.controller;

import java.util.Properties;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import kz.salikhanova.healthapp.service.DrugstoreCommentService;
import kz.salikhanova.healthapp.service.DrugstoreService;
import kz.salikhanova.healthapp.service.HospitalCommentService;
import kz.salikhanova.healthapp.service.HospitalService;
import kz.salikhanova.healthapp.service.MedicalCenterCommentService;
import kz.salikhanova.healthapp.service.MedicalCenterService;
import kz.salikhanova.healthapp.service.PolyclinicCommentService;
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
	
	@Resource(name="medicalCenterService")
	private MedicalCenterService medicalCenterService;
	
	@Resource(name = "drugstoreCommentService")
    private DrugstoreCommentService drugstoreCommentService;
	
	@Resource(name = "hospitalCommentService")
    private HospitalCommentService hospitalCommentService;
	
	@Resource(name = "polyclinicCommentService")
    private PolyclinicCommentService polyclinicCommentService;
	
	@Resource(name = "medicalCenterCommentService")
    private MedicalCenterCommentService medicalCenterCommentService;
	
	@Resource(name="appParams")
	private Properties appParams;
	
	@RequestMapping(value = "/drugstores", method = RequestMethod.GET)
    public String drugstores(@RequestParam(value = "nameSort", required=false) Boolean nameSort, @RequestParam(value = "priceSort", required=false) Boolean priceSort, @RequestParam(value = "drugsSort", required=false) Boolean drugsSort, Model model) {
		model.addAttribute("drugstores", drugstoreService.findAll(nameSort, priceSort, drugsSort));
		model.addAttribute("maxRateValue", appParams.getProperty("app.places.maxRateValue"));
		return "/place/drugstores";
    }
	
	@RequestMapping(value = "/hospitals", method = RequestMethod.GET)
    public String hospitals(@RequestParam(value = "nameSort", required=false) Boolean nameSort, @RequestParam(value = "priceSort", required=false) Boolean priceSort, @RequestParam(value = "serviceSort", required=false) Boolean serviceSort, Model model) {
		model.addAttribute("hospitals", hospitalService.findAll(nameSort, priceSort, serviceSort));
		model.addAttribute("maxRateValue", appParams.getProperty("app.places.maxRateValue"));
        return "/place/hospitals";
    }
	
	@RequestMapping(value = "/polyclinics", method = RequestMethod.GET)
    public String polyclinics(@RequestParam(value = "nameSort", required=false) Boolean nameSort, @RequestParam(value = "priceSort", required=false) Boolean priceSort, @RequestParam(value = "serviceSort", required=false) Boolean serviceSort, Model model) {
		model.addAttribute("polyclinics", polyclinicService.findAll(nameSort, priceSort, serviceSort));
		model.addAttribute("maxRateValue", appParams.getProperty("app.places.maxRateValue"));
        return "/place/polyclinics";
    }
	
	@RequestMapping(value = "/medical-centers", method = RequestMethod.GET)
    public String medicalCenters(@RequestParam(value = "nameSort", required=false) Boolean nameSort, @RequestParam(value = "priceSort", required=false) Boolean priceSort, @RequestParam(value = "serviceSort", required=false) Boolean serviceSort, Model model) {
		model.addAttribute("medicalCenters", medicalCenterService.findAll(nameSort, priceSort, serviceSort));
		model.addAttribute("maxRateValue", appParams.getProperty("app.places.maxRateValue"));
        return "/place//medical-centers";
    }
	
	@RequestMapping(value = "/drugstore", method = RequestMethod.GET)
    public String drugstore(@RequestParam(value = "id", required = true) Long id, Model model) {
		model.addAttribute("drugstore", drugstoreService.findOne(id));
		model.addAttribute("maxRateValue", appParams.getProperty("app.places.maxRateValue"));
        return "/place/drugstore";
    }
	
	@RequestMapping(value = "/hospital", method = RequestMethod.GET)
    public String hospital(@RequestParam(value = "id", required = true) Long id, Model model) {
		model.addAttribute("hospital", hospitalService.findOne(id));
		model.addAttribute("maxRateValue", appParams.getProperty("app.places.maxRateValue"));
        return "/place/hospital";
    }
	
	@RequestMapping(value = "/polyclinic", method = RequestMethod.GET)
    public String polyclinic(@RequestParam(value = "id", required = true) Long id, Model model) {
		model.addAttribute("polyclinic", polyclinicService.findOne(id));
		model.addAttribute("maxRateValue", appParams.getProperty("app.places.maxRateValue"));
        return "/place/polyclinic";
    }
	
	@RequestMapping(value = "/medical-center", method = RequestMethod.GET)
    public String medicalCenter(@RequestParam(value = "id", required = true) Long id, Model model) {
		model.addAttribute("medicalCenter", medicalCenterService.findOne(id));
		model.addAttribute("maxRateValue", appParams.getProperty("app.places.maxRateValue"));
        return "/place/medical-center";
    }
	
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String drugstore(Model model) {
        return "/site/contacts";
    }

}
