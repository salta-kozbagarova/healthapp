package kz.salikhanova.healthapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.salikhanova.healthapp.model.Rating;

public interface RatingDao extends JpaRepository<Rating, Long> {
	Rating findOne(Long id);
}
