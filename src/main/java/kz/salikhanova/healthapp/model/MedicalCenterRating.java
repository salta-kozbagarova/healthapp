package kz.salikhanova.healthapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "medical_center_rating")
public class MedicalCenterRating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 436958731584955434L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="medical_center_rating_id_seq")
	@SequenceGenerator(name="medical_center_rating_id_seq", sequenceName="medical_center_rating_id_seq", allocationSize=1)
    private Long id;
	
	@Column(name = "price")
    private Short price;
	
	@Column(name = "service")
    private Short service;
	
	@Column(name = "medical_center_id")
    private Long medicalCenterId;
	
	@OneToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Short getPrice() {
		return price;
	}

	public void setPrice(Short price) {
		this.price = price;
	}

	public Short getService() {
		return service;
	}

	public void setService(Short service) {
		this.service = service;
	}

	public Long getMedicalCenterId() {
		return medicalCenterId;
	}

	public void setMedicalCenterId(Long medicalCenterId) {
		this.medicalCenterId = medicalCenterId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
