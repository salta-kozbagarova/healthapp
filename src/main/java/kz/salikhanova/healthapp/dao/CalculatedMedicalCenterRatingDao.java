package kz.salikhanova.healthapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.salikhanova.healthapp.model.CalculatedMedicalCenterRating;

public interface CalculatedMedicalCenterRatingDao extends JpaRepository<CalculatedMedicalCenterRating, Long> {
	CalculatedMedicalCenterRating findByMedicalCenterId(Long medicalCenterId);
}
