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
@Table(name = "calculated_polyclinic_rating")
public class CalculatedPolyclinicRating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4355187463775269884L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="calculated_polyclinic_rating_id_seq")
	@SequenceGenerator(name="calculated_polyclinic_rating_id_seq", sequenceName="calculated_polyclinic_rating_id_seq", allocationSize=1)
    private Long id;
	
    @Column(name="price_rating")
	private Short priceRating;
    
    @Column(name="service_rating")
	private Short serviceRating;
    
    @Column(name="price_count")
	private Long priceCount;
    
    @Column(name="service_count")
	private Long serviceCount;
	
	@Column(name = "polyclinic_id")
    private Long polyclinicId;

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

	public Short getServiceRating() {
		return serviceRating;
	}

	public void setServiceRating(Short serviceRating) {
		this.serviceRating = serviceRating;
	}

	public Long getPriceCount() {
		return priceCount;
	}

	public void setPriceCount(Long priceCount) {
		this.priceCount = priceCount;
	}

	public Long getServiceCount() {
		return serviceCount;
	}

	public void setServiceCount(Long serviceCount) {
		this.serviceCount = serviceCount;
	}

	public Long getPolyclinicId() {
		return polyclinicId;
	}

	public void setPolyclinicId(Long polyclinicId) {
		this.polyclinicId = polyclinicId;
	}
}
