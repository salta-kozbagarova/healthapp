package kz.salikhanova.healthapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "drugstore_rating")
public class DrugstoreRating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5833131566007399155L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="drugstore_rating_id_seq")
	@SequenceGenerator(name="drugstore_rating_id_seq", sequenceName="drugstore_rating_id_seq", allocationSize=1)
    private Long id;
	
	@Column(name = "price")
    private Short price;
	
	@Column(name = "drugs_availability")
    private Short drugsAvailability;
	
	@Column(name = "drugstore_id")
    private Long drugstoreId;
	
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

	public Short getDrugsAvailability() {
		return drugsAvailability;
	}

	public void setDrugsAvailability(Short drugsAvailability) {
		this.drugsAvailability = drugsAvailability;
	}

	public Long getDrugstoreId() {
		return drugstoreId;
	}

	public void setDrugstoreId(Long drugstoreId) {
		this.drugstoreId = drugstoreId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
