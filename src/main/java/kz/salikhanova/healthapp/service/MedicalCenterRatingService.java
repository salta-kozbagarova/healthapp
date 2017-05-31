package kz.salikhanova.healthapp.service;

import kz.salikhanova.healthapp.model.MedicalCenterRating;

public interface MedicalCenterRatingService {

	MedicalCenterRating findOne(Long id);
	void save(MedicalCenterRating medicalCenterRating);
	Short calculatePriceAvg(Long medicalCenterId);
	Short calculateServiceAvg(Long medicalCenterId);
	Long calculatePriceCount(Long medicalCenterId);
	Long calculateServiceCount(Long medicalCenterId);
	MedicalCenterRating findByUserForMedicalCenter(Long userId, Long medicalCenterId);
}
