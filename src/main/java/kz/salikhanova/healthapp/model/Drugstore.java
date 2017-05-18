package kz.salikhanova.healthapp.model;

public class Drugstore {
	
	private Long id;
	private String adress;
	private String naimenovanie_aptek;
	private Double lat;
	private Double lng;
	private Short priceRating;
	private Short drugsAvailabilityRating;
	private Long priceCount;
	private Long drugsAvailabilityCount;
	private Short curUserPriceRating;
	private Short curUserDrugsAvailabilityRating;
	
	public Drugstore() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public Short getPriceRating() {
		return this.priceRating;
	}

	public void setPriceRating(Short priceRating) {
		this.priceRating = priceRating;
	}

	public Short getDrugsAvailabilityRating() {
		return this.drugsAvailabilityRating;
	}

	public void setDrugsAvailabilityRating(Short drugsAvailabilityRating) {
		this.drugsAvailabilityRating = drugsAvailabilityRating;
	}

	public Long getPriceCount() {
		return this.priceCount;
	}

	public void setPriceCount(Long priceCount) {
		this.priceCount = priceCount;
	}

	public Long getDrugsAvailabilityCount() {
		return this.drugsAvailabilityCount;
	}

	public void setDrugsAvailabilityCount(Long drugsAvailabilityCount) {
		this.drugsAvailabilityCount = drugsAvailabilityCount;
	}

	public Short getCurUserPriceRating() {
		return curUserPriceRating;
	}

	public void setCurUserPriceRating(Short curUserPriceRating) {
		this.curUserPriceRating = curUserPriceRating;
	}

	public Short getCurUserDrugsAvailabilityRating() {
		return curUserDrugsAvailabilityRating;
	}

	public void setCurUserDrugsAvailabilityRating(Short curUserDrugsAvailabilityRating) {
		this.curUserDrugsAvailabilityRating = curUserDrugsAvailabilityRating;
	}

	@Override
	public String toString() {
		return "Drugstore [id=" + id + ", adress=" + adress + ", naimenovanie_aptek=" + naimenovanie_aptek + "]";
	}
}
