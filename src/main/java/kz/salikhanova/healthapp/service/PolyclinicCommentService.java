package kz.salikhanova.healthapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kz.salikhanova.healthapp.model.PolyclinicComment;

public interface PolyclinicCommentService {

	void save(PolyclinicComment polyclinicComment);
	List<PolyclinicComment> findByPolyclinicId(Long polyclinicId);
	Page<PolyclinicComment> findByPolyclinicId(Long polyclinicId, Pageable pageRequest);
	List<PolyclinicComment> findFirst10ByPolyclinicIdOrderByDateDesc(Long polyclinicId);
}
