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
@Table(name = "rating")
public class Rating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5833131566007399155L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="rating_id_seq")
	@SequenceGenerator(name="rating_id_seq", sequenceName="rating_id_seq", allocationSize=1)
    private Long id;
	
	@Column(name = "price")
    private Byte price;
	
	@Column(name = "drugs_availability")
    private Byte drugs_availability;
	
	@Column(name = "place_type_id")
    private PlaceType place_type;
	
	@Column(name = "place_id")
    private Object place;
	
	@OneToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte getPrice() {
		return price;
	}

	public void setPrice(Byte price) {
		this.price = price;
	}

	public Byte getDrugsAvailability() {
		return drugs_availability;
	}

	public void setDrugsAvailability(Byte drugs_availability) {
		this.drugs_availability = drugs_availability;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
