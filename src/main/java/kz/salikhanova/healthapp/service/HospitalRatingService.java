package kz.salikhanova.healthapp.service;

import kz.salikhanova.healthapp.model.HospitalRating;

public interface HospitalRatingService {

	HospitalRating findOne(Long id);
	void save(HospitalRating hospitalRating);
	Short calculatePriceAvg(Long hospitalId);
	Short calculateServiceAvg(Long hospitalId);
	Long calculatePriceCount(Long hospitalId);
	Long calculateServiceCount(Long hospitalId);
	HospitalRating findByUserForHospital(Long userId, Long hospitalId);
}
