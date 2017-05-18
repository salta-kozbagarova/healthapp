package kz.salikhanova.healthapp.service;

import kz.salikhanova.healthapp.model.DrugstoreRating;

public interface DrugstoreRatingService {

	DrugstoreRating findOne(Long id);
	void save(DrugstoreRating drugstoreRating);
	Short calculatePriceAvg(Long drugstoreId);
	Short calculateDrugsAvailabilityAvg(Long drugstoreId);
	Long calculatePriceCount(Long drugstoreId);
	Long calculateDrugsAvailabilityCount(Long drugstoreId);
	DrugstoreRating findByUserForDrugstore(Long userId, Long drugstoreId);
}
