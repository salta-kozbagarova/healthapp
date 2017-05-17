package kz.salikhanova.healthapp.model;

public class Drugstore {
	
	private Integer id;
	private String adress;
	private String naimenovanie_aptek;
	private Double lat;
	private Double lng;
	private Byte rating=4;
	private Integer peopleQuantity=158;
	
	public Drugstore() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return adress;
	}

	public void setAddress(String adress) {
		this.adress = adress;
	}

	public String getNaimenovanieAptek() {
		return naimenovanie_aptek;
	}

	public void setNaimenovanieAptek(String naimenovanie_aptek) {
		this.naimenovanie_aptek = naimenovanie_aptek;
	}
	
	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	
	public Byte getRating() {
		return rating;
	}

	public void setRating(Byte rating) {
		this.rating = rating;
	}

	
	public Integer getPeopleQuantity() {
		return peopleQuantity;
	}

	public void setPeopleQuantity(Integer peopleQuantity) {
		this.peopleQuantity = peopleQuantity;
	}

	@Override
	public String toString() {
		return "Drugstore [id=" + id + ", adress=" + adress + ", naimenovanie_aptek=" + naimenovanie_aptek + "]";
	}
}
