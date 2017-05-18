package kz.salikhanova.healthapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "calculated_drugstore_rating")
public class CalculatedDrugstoreRating implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7242406342030877734L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="calculated_drugstore_rating_id_seq")
	@SequenceGenerator(name="calculated_drugstore_rating_id_seq", sequenceName="calculated_drugstore_rating_id_seq", allocationSize=1)
    private Long id;
	
    @Column(name="price_rating")
	private Short priceRating;
    
    @Column(name="drugs_availability_rating")
	private Short drugsAvailabilityRating;
    
    @Column(name="price_count")
	private Long priceCount;
    
    @Column(name="drugs_availability_count")
	private Long drugsAvailabilityCount;
	
	@Column(name = "drugstore_id")
    private Long drugstoreId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Short getPriceRating() {
		return priceRating;
	}

	public void setPriceRating(Short priceRating) {
		this.priceRating = priceRating;
	}

	public Short getDrugsAvailabilityRating() {
		return drugsAvailabilityRating;
	}

	public void setDrugsAvailabilityRating(Short drugsAvailabilityRating) {
		this.drugsAvailabilityRating = drugsAvailabilityRating;
	}

	public Long getPriceCount() {
		return priceCount;
	}

	public void setPriceCount(Long priceCount) {
		this.priceCount = priceCount;
	}

	public Long getDrugsAvailabilityCount() {
		return drugsAvailabilityCount;
	}

	public void setDrugsAvailabilityCount(Long drugsAvailabilityCount) {
		this.drugsAvailabilityCount = drugsAvailabilityCount;
	}

	public Long getDrugstoreId() {
		return drugstoreId;
	}

	public void setDrugstoreId(Long drugstoreId) {
		this.drugstoreId = drugstoreId;
	}
}
