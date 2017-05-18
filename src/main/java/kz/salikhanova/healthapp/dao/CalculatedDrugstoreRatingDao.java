package kz.salikhanova.healthapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.salikhanova.healthapp.model.CalculatedDrugstoreRating;

public interface CalculatedDrugstoreRatingDao extends JpaRepository<CalculatedDrugstoreRating, Long> {
	CalculatedDrugstoreRating findByDrugstoreId(Long drugstoreId);
}
