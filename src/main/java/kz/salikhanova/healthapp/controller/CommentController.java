package kz.salikhanova.healthapp.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kz.salikhanova.healthapp.model.Comment;
import kz.salikhanova.healthapp.service.CommentService;
import kz.salikhanova.healthapp.service.UserService;

@Controller
@RequestMapping("/comments")
public class CommentController {
	
	@Resource(name = "userService")
    private UserService userService;
	
	@Resource(name = "commentService")
    private CommentService commentService;

	@RequestMapping(value = "/add", method=RequestMethod.POST)//produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
	public @ResponseBody Map<String, ? extends Object> create(Comment comment, HttpServletResponse response) {
	    if(comment.getComment().isEmpty()) {
	    	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	    	return Collections.singletonMap("error", "error");
	    } else {
	    	comment.setUser(userService.getCurrentUser());
	    	commentService.save(comment);
	        Map<String, Object> commentMap = new HashMap<String, Object>();
	        commentMap.put("comment", comment.getComment());
	        commentMap.put("username", comment.getUser().getUsername());
	        return commentMap;
	    }
	}
}
