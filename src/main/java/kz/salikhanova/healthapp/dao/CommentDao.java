package kz.salikhanova.healthapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.salikhanova.healthapp.model.Comment;

public interface CommentDao extends JpaRepository<Comment, Long> {

}
