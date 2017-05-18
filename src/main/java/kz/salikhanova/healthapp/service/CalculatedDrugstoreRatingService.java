package kz.salikhanova.healthapp.service;

import kz.salikhanova.healthapp.model.CalculatedDrugstoreRating;

public interface CalculatedDrugstoreRatingService {

	CalculatedDrugstoreRating findByDrugstoreId(Long drugstoreId);
	void save(CalculatedDrugstoreRating calculatedDrugstoreRating);
}
