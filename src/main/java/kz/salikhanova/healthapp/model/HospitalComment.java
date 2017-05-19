package kz.salikhanova.healthapp.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "hospital_comment")
public class HospitalComment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -416456600829915208L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="hospital_comment_id_seq")
	@SequenceGenerator(name="hospital_comment_id_seq", sequenceName="hospital_comment_id_seq", allocationSize=1)
    private Long id;
	
	@Column(name = "comment")
    private String comment;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	private Date date;
	
	@Column(name = "hospital_id")
    private Long hospitalId;
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getFormattedDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		return dateFormat.format(date);
	}
}
