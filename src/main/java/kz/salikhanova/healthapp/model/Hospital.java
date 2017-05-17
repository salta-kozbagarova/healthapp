package kz.salikhanova.healthapp.model;

public class Hospital {

	private Integer id;
	private String naimenovanie_oganizacii;
	private String adress;
	private String adress_saita;
	private String kontact_tel;
	private String fio_rukovoditel;
	private String vremia_priema;
	private Double lat;
	private Double lng;
	private Byte rating=4;
	private Integer peopleQuantity=158;
	
	public Hospital() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNaimenovanieOganizacii() {
		return naimenovanie_oganizacii;
	}
	
	public void setNaimenovanieOganizacii(String naimenovanie_oganizacii) {
		this.naimenovanie_oganizacii = naimenovanie_oganizacii;
	}
	
	public String getAddress() {
		return adress;
	}
	
	public void setAddress(String adress) {
		this.adress = adress;
	}
	
	public String getAddressSaita() {
		return adress_saita;
	}
	
	public void setAddressSaita(String adress_saita) {
		this.adress_saita = adress_saita;
	}
	
	public String getKontactTel() {
		return kontact_tel;
	}
	
	public void setKontactTel(String kontact_tel) {
		this.kontact_tel = kontact_tel;
	}
	
	public String getFioRukovoditel() {
		return fio_rukovoditel;
	}
	
	public void setFioRukovoditel(String fio_rukovoditel) {
		this.fio_rukovoditel = fio_rukovoditel;
	}
	
	public String getVremiaPriema() {
		return vremia_priema;
	}
	
	public void setVremiaPriema(String vremia_priema) {
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
		return "Hospital [id=" + id + ", naimenovanie_oganizacii=" + naimenovanie_oganizacii + ", adress=" + adress
				+ ", adress_saita=" + adress_saita + ", kontact_tel=" + kontact_tel + ", fio_rukovoditel="
				+ fio_rukovoditel + ", vremia_priema=" + vremia_priema + ", lat=" + lat + ", lng=" + lng + ", raiting="
				+ raiting + ", peopleQuantity=" + peopleQuantity + "]";
	}
}
