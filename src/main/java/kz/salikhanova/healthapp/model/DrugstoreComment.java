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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "drugstore_comment")
public class DrugstoreComment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4068511606985263697L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="drugstore_comment_id_seq")
	@SequenceGenerator(name="drugstore_comment_id_seq", sequenceName="drugstore_comment_id_seq", allocationSize=1)
    private Long id;
	
	@Column(name = "comment")
    private String comment;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	private Date date;
	
	@Column(name = "drugstore_id")
    private Long drugstoreId;
	
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
	
	public String getFormattedDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		return dateFormat.format(date);
	}

	@Override
	public String toString() {
		return "DrugstoreComment [id=" + id + ", comment=" + comment + ", date=" + date + ", drugstoreId=" + drugstoreId
				+ ", user=" + user + "]";
	}
}
