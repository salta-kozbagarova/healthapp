package kz.salikhanova.healthapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.salikhanova.healthapp.model.CalculatedHospitalRating;

public interface CalculatedHospitalRatingDao extends JpaRepository<CalculatedHospitalRating, Long> {
	CalculatedHospitalRating findByHospitalId(Long hospitalId);
}
