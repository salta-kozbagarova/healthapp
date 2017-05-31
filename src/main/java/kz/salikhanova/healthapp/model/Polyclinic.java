package kz.salikhanova.healthapp.model;

public class Polyclinic {
	
	private Long id;
	private String naimenovanie_oganizacii;
	private String adress;
	private String adress_saita;
	private String kontact_tel;
	private String fio_rukovoditel;
	private String vremia_priema;
	private Double lat;
	private Double lng;
	private Short priceRating;
	private Short serviceRating;
	private Long priceCount;
	private Long serviceCount;
	private Short curUserPriceRating;
	private Short curUserServiceRating;
	
	public Polyclinic() {
		super();
	}

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

	public String getAddress() {
		return adress;
	}

	public void setAddress(String adress) {
		this.adress = adress;
	}

	public String getSiteAddress() {
		return adress_saita;
	}

	public void setSiteAddress(String adress_saita) {
		this.adress_saita = adress_saita;
	}

	public String getPhonenumber() {
		return kontact_tel;
	}

	public void setPhonenumber(String kontact_tel) {
		this.kontact_tel = kontact_tel;
	}

	public String getHeadName() {
		return fio_rukovoditel;
	}

	public void setHeadName(String fio_rukovoditel) {
		this.fio_rukovoditel = fio_rukovoditel;
	}

	public String getVisitTime() {
		return vremia_priema;
	}

	public void setVisitTime(String vremia_priema) {
		this.vremia_priema = vremia_priema;
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
