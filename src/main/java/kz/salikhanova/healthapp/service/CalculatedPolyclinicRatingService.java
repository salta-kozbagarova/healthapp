package kz.salikhanova.healthapp.service;

import kz.salikhanova.healthapp.model.CalculatedPolyclinicRating;

public interface CalculatedPolyclinicRatingService {

	CalculatedPolyclinicRating findByPolyclinicId(Long polycliniclId);
	void save(CalculatedPolyclinicRating calculatedPolyclinicRating);
}
