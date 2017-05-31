package kz.salikhanova.healthapp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import kz.salikhanova.healthapp.model.PolyclinicComment;

public interface PolyclinicCommentDao extends JpaRepository<PolyclinicComment, Long> {
	List<PolyclinicComment> findByPolyclinicId(Long polyclinicId);
	Page<PolyclinicComment> findByPolyclinicId(Long polyclinicId, Pageable pageRequest);
	List<PolyclinicComment> findFirst10ByPolyclinicIdOrderByDateDesc(Long polyclinicId);
}
