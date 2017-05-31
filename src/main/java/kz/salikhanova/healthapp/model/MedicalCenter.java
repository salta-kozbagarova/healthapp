package kz.salikhanova.healthapp.model;

public class MedicalCenter {

	private Long id;
	private String naimenovanie_oganizacii;
	private String vremia_raboti;
	private String tel_doveria;
	private String koncultant;
	private Double lat;
	private Double lng;
	private Short priceRating;
	private Short serviceRating;
	private Long priceCount;
	private Long serviceCount;
	private Short curUserPriceRating;
	private Short curUserServiceRating;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrganizationName() {
		return naimenovanie_oganizacii;
	}
	public void setOrganizationName(String naimenovanie_oganizacii) {
		this.naimenovanie_oganizacii = naimenovanie_oganizacii;
	}
	public String getWorkTime() {
		return vremia_raboti;
	}
	public void setWorkTime(String vremia_raboti) {
		this.vremia_raboti = vremia_raboti;
	}
	public String getHelpline() {
		return tel_doveria;
	}
	public void setHelpline(String tel_doveria) {
		this.tel_doveria = tel_doveria;
	}
	public String getConsultant() {
		return koncultant;
	}
	public void setConsultant(String koncultant) {
		this.koncultant = koncultant;
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
	public Short getCurUserPriceRating() {
		return curUserPriceRating;
	}
	public void setCurUserPriceRating(Short curUserPriceRating) {
		this.curUserPriceRating = curUserPriceRating;
	}
	public Short getCurUserServiceRating() {
		return curUserServiceRating;
	}
	public void setCurUserServiceRating(Short curUserServiceRating) {
		this.curUserServiceRating = curUserServiceRating;
	}
}
