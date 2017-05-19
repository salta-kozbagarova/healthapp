package kz.salikhanova.healthapp.controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kz.salikhanova.healthapp.model.DrugstoreComment;
import kz.salikhanova.healthapp.service.DrugstoreCommentService;
import kz.salikhanova.healthapp.service.DrugstoreService;
import kz.salikhanova.healthapp.service.UserService;

@Controller
@RequestMapping("/drugstore")
public class DrugstoreController {
	
	@Resource(name = "userService")
    private UserService userService;
	
	@Resource(name="drugstoreService")
	private DrugstoreService drugstoreService;
	
	@Resource(name = "drugstoreCommentService")
    private DrugstoreCommentService drugstoreCommentService;
	
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

	@RequestMapping(value = "/leave-a-comment", method=RequestMethod.POST)//produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
	public @ResponseBody Map<String, ? extends Object> leaveAComment(@RequestParam Long id, DrugstoreComment drugstoreComment, HttpServletResponse response) {
	    if(drugstoreComment.getComment().isEmpty()) {
	    	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	    	return Collections.singletonMap("error", "error");
	    } else {
	    	drugstoreComment.setDate(new Date());
	    	drugstoreComment.setDrugstoreId(id);
	    	drugstoreComment.setUser(userService.getCurrentUser());
	    	drugstoreCommentService.save(drugstoreComment);
	        Map<String, Object> commentMap = new HashMap<String, Object>();
	        commentMap.put("comment", drugstoreComment.getComment());
	        commentMap.put("username", drugstoreComment.getUser().getUsername());
	        commentMap.put("formattedDate", drugstoreComment.getFormattedDate());
	        return commentMap;
	    }
	}
	
	@RequestMapping(value = "/comments", method=RequestMethod.GET)
	public @ResponseBody Page<DrugstoreComment> getComments(@RequestParam Long id, @RequestParam Integer pageNumber) {
		PageRequest pageRequest = new PageRequest(0, 10, Sort.Direction.DESC, "date");
		System.out.println(pageRequest.getPageSize());
		Page<DrugstoreComment> pages = drugstoreCommentService.findByDrugstoreId(id, pageRequest);
		for (DrugstoreComment p : pages) {
			System.out.println(p);
		}
		return pages;
	}
	
	@RequestMapping(value = "/commentss", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void getCommentss(@RequestParam Long id, @RequestParam Integer pageNumber) {
		PageRequest pageRequest = new PageRequest(0, 10, Sort.Direction.DESC, "date");
		System.out.println(pageRequest.getPageSize());
		Page<DrugstoreComment> pages = drugstoreCommentService.findByDrugstoreId(id, pageRequest);
		System.out.println(pages.getSize());
		for (DrugstoreComment p : pages) {
			System.out.println(p);
		}
		
	}
}
