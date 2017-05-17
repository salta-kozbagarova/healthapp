package kz.salikhanova.healthapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.salikhanova.healthapp.dao.CommentDao;
import kz.salikhanova.healthapp.model.Comment;


@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public void save(Comment comment) {
		commentDao.save(comment);
	}

}
