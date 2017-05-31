package kz.salikhanova.healthapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kz.salikhanova.healthapp.model.PolyclinicRating;

public interface PolyclinicRatingDao extends JpaRepository<PolyclinicRating, Long> {
	PolyclinicRating findOne(Long id);
	PolyclinicRating findByUserIdAndPolyclinicId(Long userId, Long polyclinicId);
	
	@Query(value="SELECT sum(dr.price) FROM Polyclinic_rating dr WHERE dr.polyclinic_id=:polyclinic_id", nativeQuery = true)
	Long getPriceSum(@Param("polyclinic_id") Long polyclinicId);
	
	@Query(value="SELECT sum(dr.service) FROM Polyclinic_rating dr WHERE dr.polyclinic_id=:polyclinic_id", nativeQuery = true)
	Long getServiceSum(@Param("polyclinic_id") Long polyclinicId);
	
	@Query(value="SELECT count(dr.price) FROM Polyclinic_rating dr WHERE dr.polyclinic_id=:polyclinic_id", nativeQuery = true)
	Long getPriceCount(@Param("polyclinic_id") Long polyclinicId);
	
	@Query(value="SELECT count(dr.service) FROM Polyclinic_rating dr WHERE dr.polyclinic_id=:polyclinic_id", nativeQuery = true)
	Long getServiceCount(@Param("polyclinic_id") Long polyclinicId);
}
