package kz.salikhanova.healthapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.salikhanova.healthapp.model.CalculatedHospitalRating;
import kz.salikhanova.healthapp.model.CalculatedPolyclinicRating;

public interface CalculatedPolyclinicRatingDao extends JpaRepository<CalculatedPolyclinicRating, Long> {
	CalculatedPolyclinicRating findByPolyclinicId(Long polyclinicId);
}
