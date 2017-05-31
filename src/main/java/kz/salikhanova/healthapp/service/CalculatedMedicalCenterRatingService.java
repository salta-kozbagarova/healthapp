package kz.salikhanova.healthapp.service;

import kz.salikhanova.healthapp.model.CalculatedMedicalCenterRating;

public interface CalculatedMedicalCenterRatingService {

	CalculatedMedicalCenterRating findByMedicalCenterId(Long medicalCenterId);
	void save(CalculatedMedicalCenterRating calculatedMedicalCenterRating);
}
