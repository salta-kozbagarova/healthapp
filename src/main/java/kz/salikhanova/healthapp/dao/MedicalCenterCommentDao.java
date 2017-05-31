package kz.salikhanova.healthapp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import kz.salikhanova.healthapp.model.MedicalCenterComment;

public interface MedicalCenterCommentDao extends JpaRepository<MedicalCenterComment, Long> {
	List<MedicalCenterComment> findByMedicalCenterId(Long medicalCenterId);
	Page<MedicalCenterComment> findByMedicalCenterId(Long medicalCenterId, Pageable pageRequest);
	List<MedicalCenterComment> findFirst10ByMedicalCenterIdOrderByDateDesc(Long medicalCenterId);
}
