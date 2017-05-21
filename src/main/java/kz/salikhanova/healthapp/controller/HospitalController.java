package kz.salikhanova.healthapp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import kz.salikhanova.healthapp.model.DrugstoreComment;
import kz.salikhanova.healthapp.model.HospitalComment;
import kz.salikhanova.healthapp.service.HospitalCommentService;
import kz.salikhanova.healthapp.service.HospitalService;
import kz.salikhanova.healthapp.service.UserService;

@Controller
@RequestMapping("/hospital")
public class HospitalController {

	@Resource(name = "userService")
    private UserService userService;
	
	@Resource(name="hospitalService")
	private HospitalService hospitalService;
	
	@Resource(name = "hospitalCommentService")
    private HospitalCommentService hospitalCommentService;
	
	@RequestMapping(value = "/rate-price", method=RequestMethod.GET)
	public @ResponseBody String ratePrice(Long id, Short price) {
		hospitalService.ratePrice(id, price);
		return "success";
	}

	@RequestMapping(value = "/rate-service", method=RequestMethod.GET)
	public @ResponseBody String rateService(Long id, Short service) {
		hospitalService.rateService(id, service);
		return "success";
	}
	
	@RequestMapping(value = "/leave-a-comment", method=RequestMethod.POST)
	public @ResponseBody Map<String, ? extends Object> leaveAComment(@RequestParam Long hospitalId, HospitalComment hospitalComment, HttpServletResponse response) {
	    if(hospitalComment.getComment().isEmpty()) {
	    	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	    	return Collections.singletonMap("error", "error");
	    } else {
	    	hospitalComment.setDate(new Date());
	    	hospitalComment.setHospitalId(hospitalId);
	    	hospitalComment.setUser(userService.getCurrentUser());
	    	hospitalCommentService.save(hospitalComment);
	        Map<String, Object> commentMap = new HashMap<String, Object>();
	        commentMap.put("comment", hospitalComment.getComment());
	        commentMap.put("username", hospitalComment.getUser().getUsername());
	        commentMap.put("formattedDate", hospitalComment.getFormattedDate());
	        return commentMap;
	    }
	}
	
	@RequestMapping(value = "/comments", method=RequestMethod.GET)
	public @ResponseBody Page<HospitalComment> getComments(@RequestParam Long id, @RequestParam Integer pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber, 10, Sort.Direction.DESC, "date");
		Page<HospitalComment> pages = hospitalCommentService.findByHospitalId(id, pageRequest);
		return pages;
	}
}
