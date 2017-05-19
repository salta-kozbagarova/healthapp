package kz.salikhanova.healthapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kz.salikhanova.healthapp.model.HospitalRating;

public interface HospitalRatingDao extends JpaRepository<HospitalRating, Long> {
	HospitalRating findOne(Long id);
	HospitalRating findByUserIdAndHospitalId(Long userId, Long hospitalId);
	
	@Query(value="SELECT sum(dr.price) FROM Hospital_rating dr WHERE dr.hospital_id=:hospital_id", nativeQuery = true)
	Long getPriceSum(@Param("hospital_id") Long hospitalId);
	
	@Query(value="SELECT sum(dr.service) FROM Hospital_rating dr WHERE dr.hospital_id=:hospital_id", nativeQuery = true)
	Long getServiceSum(@Param("hospital_id") Long hospitalId);
	
	@Query(value="SELECT count(dr.price) FROM Hospital_rating dr WHERE dr.hospital_id=:hospital_id", nativeQuery = true)
	Long getPriceCount(@Param("hospital_id") Long hospitalId);
	
	@Query(value="SELECT count(dr.service) FROM Hospital_rating dr WHERE dr.hospital_id=:hospital_id", nativeQuery = true)
	Long getServiceCount(@Param("hospital_id") Long hospitalId);
}
