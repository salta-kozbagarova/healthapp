package kz.salikhanova.healthapp.service;

import java.util.List;

import kz.salikhanova.healthapp.model.HospitalComment;

public interface HospitalCommentService {

	void save(HospitalComment hospitalComment);
	List<HospitalComment> findByHospitalId(Long hospitalId);
	List<HospitalComment> findFirst10ByHospitalIdOrderByDateDesc(Long hospitalId);
}
