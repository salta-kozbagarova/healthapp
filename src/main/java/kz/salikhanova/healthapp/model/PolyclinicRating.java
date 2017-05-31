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
@Table(name = "polyclinic_rating")
public class PolyclinicRating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5977804618055299387L;
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="polyclinic_rating_id_seq")
	@SequenceGenerator(name="polyclinic_rating_id_seq", sequenceName="polyclinic_rating_id_seq", allocationSize=1)
    private Long id;
	
	@Column(name = "price")
    private Short price;
	
	@Column(name = "service")
    private Short service;
	
	@Column(name = "polyclinic_id")
    private Long polyclinicId;
	
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

	public Long getPolyclinicId() {
		return polyclinicId;
	}

	public void setPolyclinicId(Long polyclinicId) {
		this.polyclinicId = polyclinicId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
