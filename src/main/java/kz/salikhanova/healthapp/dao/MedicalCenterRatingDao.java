package kz.salikhanova.healthapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kz.salikhanova.healthapp.model.HospitalRating;
import kz.salikhanova.healthapp.model.MedicalCenterRating;

public interface MedicalCenterRatingDao extends JpaRepository<MedicalCenterRating, Long> {
	MedicalCenterRating findOne(Long id);
	MedicalCenterRating findByUserIdAndMedicalCenterId(Long userId, Long medicalCenterId);
	
	@Query(value="SELECT sum(dr.price) FROM Medical_center_rating dr WHERE dr.medical_center_id=:medical_center_id", nativeQuery = true)
	Long getPriceSum(@Param("medical_center_id") Long medicalCenterId);
	
	@Query(value="SELECT sum(dr.service) FROM Medical_center_rating dr WHERE dr.medical_center_id=:medical_center_id", nativeQuery = true)
	Long getServiceSum(@Param("medical_center_id") Long medicalCenterId);
	
	@Query(value="SELECT count(dr.price) FROM Medical_center_rating dr WHERE dr.medical_center_id=:medical_center_id", nativeQuery = true)
	Long getPriceCount(@Param("medical_center_id") Long medicalCenterId);
	
	@Query(value="SELECT count(dr.service) FROM Medical_center_rating dr WHERE dr.medical_center_id=:medical_center_id", nativeQuery = true)
	Long getServiceCount(@Param("medical_center_id") Long medicalCenterId);
}
