package kz.salikhanova.healthapp.service;

import kz.salikhanova.healthapp.model.CalculatedHospitalRating;

public interface CalculatedHospitalRatingService {

	CalculatedHospitalRating findByHospitalId(Long hospitalId);
	void save(CalculatedHospitalRating calculatedHospitalRating);
}
