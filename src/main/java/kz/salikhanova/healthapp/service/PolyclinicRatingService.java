package kz.salikhanova.healthapp.service;

import kz.salikhanova.healthapp.model.PolyclinicRating;

public interface PolyclinicRatingService {
	
	PolyclinicRating findOne(Long id);
	void save(PolyclinicRating polyclinicRating);
	Short calculatePriceAvg(Long polyclinicId);
	Short calculateServiceAvg(Long polyclinicId);
	Long calculatePriceCount(Long polyclinicId);
	Long calculateServiceCount(Long polyclinicId);
	PolyclinicRating findByUserForPolyclinic(Long userId, Long polyclinicId);
}
