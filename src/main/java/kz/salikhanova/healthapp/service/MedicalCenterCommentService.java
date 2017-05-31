package kz.salikhanova.healthapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kz.salikhanova.healthapp.model.MedicalCenterComment;

public interface MedicalCenterCommentService {

	void save(MedicalCenterComment medicalCenterComment);
	List<MedicalCenterComment> findByMedicalCenterId(Long medicalCenterId);
	Page<MedicalCenterComment> findByMedicalCenterId(Long medicalCenterId, Pageable pageRequest);
	List<MedicalCenterComment> findFirst10ByMedicalCenterIdOrderByDateDesc(Long medicalCenterId);
}
