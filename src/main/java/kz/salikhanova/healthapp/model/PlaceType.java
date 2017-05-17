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
@Table(name = "place_type")
public class PlaceType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9007683966797446559L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="place_type_id_seq")
	@SequenceGenerator(name="place_type_id_seq", sequenceName="place_type_id_seq", allocationSize=1)
    private Long id;
	
	@Column(name = "type")
    private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
