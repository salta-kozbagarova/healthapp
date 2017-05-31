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

import kz.salikhanova.healthapp.model.PolyclinicComment;
import kz.salikhanova.healthapp.service.PolyclinicCommentService;
import kz.salikhanova.healthapp.service.PolyclinicService;
import kz.salikhanova.healthapp.service.UserService;

@Controller
@RequestMapping("/polyclinic")
public class PolyclinicController {

	@Resource(name = "userService")
    private UserService userService;
	
	@Resource(name="polyclinicService")
	private PolyclinicService polyclinicService;
	
	@Resource(name = "polyclinicCommentService")
    private PolyclinicCommentService polyclinicCommentService;
	
	@RequestMapping(value = "/rate-price", method=RequestMethod.GET)
	public @ResponseBody String ratePrice(Long id, Short price) {
		polyclinicService.ratePrice(id, price);
		return "success";
	}

	@RequestMapping(value = "/rate-service", method=RequestMethod.GET)
	public @ResponseBody String rateService(Long id, Short service) {
		polyclinicService.rateService(id, service);
		return "success";
	}
	
	@RequestMapping(value = "/leave-a-comment", method=RequestMethod.POST)
	public @ResponseBody Map<String, ? extends Object> leaveAComment(@RequestParam Long polyclinicId, PolyclinicComment polyclinicComment, HttpServletResponse response) {
	    if(polyclinicComment.getComment().isEmpty()) {
	    	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	    	return Collections.singletonMap("error", "error");
	    } else {
	    	polyclinicComment.setDate(new Date());
	    	polyclinicComment.setPolyclinicId(polyclinicId);
	    	polyclinicComment.setUser(userService.getCurrentUser());
	    	polyclinicCommentService.save(polyclinicComment);
	        Map<String, Object> commentMap = new HashMap<String, Object>();
	        commentMap.put("comment", polyclinicComment.getComment());
	        commentMap.put("username", polyclinicComment.getUser().getUsername());
	        commentMap.put("formattedDate", polyclinicComment.getFormattedDate());
	        return commentMap;
	    }
	}
	
	@RequestMapping(value = "/comments", method=RequestMethod.GET)
	public @ResponseBody Page<PolyclinicComment> getComments(@RequestParam Long id, @RequestParam Integer pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber, 10, Sort.Direction.DESC, "date");
		Page<PolyclinicComment> pages = polyclinicCommentService.findByPolyclinicId(id, pageRequest);
		return pages;
	}
	
}
