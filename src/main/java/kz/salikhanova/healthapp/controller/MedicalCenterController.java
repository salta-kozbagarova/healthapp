package kz.salikhanova.healthapp.controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kz.salikhanova.healthapp.model.MedicalCenterComment;
import kz.salikhanova.healthapp.model.PolyclinicComment;
import kz.salikhanova.healthapp.service.MedicalCenterCommentService;
import kz.salikhanova.healthapp.service.MedicalCenterService;
import kz.salikhanova.healthapp.service.PolyclinicCommentService;
import kz.salikhanova.healthapp.service.PolyclinicService;
import kz.salikhanova.healthapp.service.UserService;

@Controller
@RequestMapping("/medical-center")
public class MedicalCenterController {

	@Resource(name = "userService")
    private UserService userService;
	
	@Resource(name="medicalCenterService")
	private MedicalCenterService medicalCenterService;
	
	@Resource(name = "medicalCenterCommentService")
    private MedicalCenterCommentService medicalCenterCommentService;
	
	@RequestMapping(value = "/rate-price", method=RequestMethod.GET)
	public @ResponseBody String ratePrice(Long id, Short price) {
		medicalCenterService.ratePrice(id, price);
		return "success";
	}

	@RequestMapping(value = "/rate-service", method=RequestMethod.GET)
	public @ResponseBody String rateService(Long id, Short service) {
		medicalCenterService.rateService(id, service);
		return "success";
	}
	
	@RequestMapping(value = "/leave-a-comment", method=RequestMethod.POST)
	public @ResponseBody Map<String, ? extends Object> leaveAComment(@RequestParam Long medicalCenterId, MedicalCenterComment medicalCenterComment, HttpServletResponse response) {
	    if(medicalCenterComment.getComment().isEmpty()) {
	    	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	    	return Collections.singletonMap("error", "error");
	    } else {
	    	medicalCenterComment.setDate(new Date());
	    	medicalCenterComment.setMedicalCenterId(medicalCenterId);
	    	medicalCenterComment.setUser(userService.getCurrentUser());
	    	medicalCenterCommentService.save(medicalCenterComment);
	        Map<String, Object> commentMap = new HashMap<String, Object>();
	        commentMap.put("comment", medicalCenterComment.getComment());
	        commentMap.put("username", medicalCenterComment.getUser().getUsername());
	        commentMap.put("formattedDate", medicalCenterComment.getFormattedDate());
	        return commentMap;
	    }
	}
	
	@RequestMapping(value = "/comments", method=RequestMethod.GET)
	public @ResponseBody Page<MedicalCenterComment> getComments(@RequestParam Long id, @RequestParam Integer pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber, 10, Sort.Direction.DESC, "date");
		Page<MedicalCenterComment> pages = medicalCenterCommentService.findByMedicalCenterId(id, pageRequest);
		return pages;
	}
}
