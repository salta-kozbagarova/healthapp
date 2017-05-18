package kz.salikhanova.healthapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kz.salikhanova.healthapp.model.DrugstoreRating;

public interface DrugstoreRatingDao extends JpaRepository<DrugstoreRating, Long> {
	DrugstoreRating findOne(Long id);
	DrugstoreRating findByUserIdAndDrugstoreId(Long userId, Long drugstoreId);
	
	@Query(value="SELECT sum(dr.price) FROM Drugstore_rating dr WHERE dr.drugstore_id=:drugstore_id", nativeQuery = true)
	Long getPriceSum(@Param("drugstore_id") Long drugstoreId);
	
	@Query(value="SELECT sum(dr.drugs_availability) FROM Drugstore_rating dr WHERE dr.drugstore_id=:drugstore_id", nativeQuery = true)
	Long getDrugsAvailabilitySum(@Param("drugstore_id") Long drugstoreId);
	
	@Query(value="SELECT count(dr.price) FROM Drugstore_rating dr WHERE dr.drugstore_id=:drugstore_id", nativeQuery = true)
	Long getPriceCount(@Param("drugstore_id") Long drugstoreId);
	
	@Query(value="SELECT count(dr.drugs_availability) FROM Drugstore_rating dr WHERE dr.drugstore_id=:drugstore_id", nativeQuery = true)
	Long getDrugsAvailabilityCount(@Param("drugstore_id") Long drugstoreId);
}
