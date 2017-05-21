package kz.salikhanova.healthapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kz.salikhanova.healthapp.model.HospitalComment;

public interface HospitalCommentService {

	void save(HospitalComment hospitalComment);
	List<HospitalComment> findByHospitalId(Long hospitalId);
	Page<HospitalComment> findByHospitalId(Long hospitalId, Pageable pageRequest);
	List<HospitalComment> findFirst10ByHospitalIdOrderByDateDesc(Long hospitalId);
}
