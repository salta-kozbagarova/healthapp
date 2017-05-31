package kz.salikhanova.healthapp.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import kz.salikhanova.healthapp.model.CalculatedHospitalRating;
import kz.salikhanova.healthapp.model.CalculatedMedicalCenterRating;
import kz.salikhanova.healthapp.model.Hospital;
import kz.salikhanova.healthapp.model.HospitalRating;
import kz.salikhanova.healthapp.model.MedicalCenter;
import kz.salikhanova.healthapp.model.MedicalCenterRating;
import kz.salikhanova.healthapp.model.User;
import kz.salikhanova.healthapp.util.GoogleGeoCoder;

@Service("medicalCenterService")
public class MedicalCenterServiceImpl implements MedicalCenterService {

	private static String egovApiUrl = "http://data.egov.kz/api/v2/medicinalyk_ortalyktar2/v2";
	
	@Resource(name = "medicalCenterRatingService")
	private MedicalCenterRatingService medicalCenterRatingService;
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "calculatedMedicalCenterRatingService")
	private CalculatedMedicalCenterRatingService calculatedMedicalCenterRatingService;
	
	@Override
	public List<MedicalCenter> findAll(Boolean nameSort, Boolean priceSort, Boolean serviceSort) {
		List<MedicalCenter> medicalCenters = new ArrayList<MedicalCenter>();
		try{
			URL url = new URL(this.egovApiUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + this.egovApiUrl);
			System.out.println("Response Code : " + responseCode);

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = bufferedReader.readLine()) != null) {
				response.append(inputLine);
			}
			bufferedReader.close();
			
			JSONArray jsonArr = new JSONArray(response.toString());
			MedicalCenter medicalCenter = null;
			CalculatedMedicalCenterRating chr = null;
			HashMap<String,Double> coords;
			for (int i = 0; i < jsonArr.length(); i++) {
				JSONObject jsonObj = jsonArr.getJSONObject(i);
				Gson gson = new Gson();
				medicalCenter = gson.fromJson(jsonObj.toString(), MedicalCenter.class);
				/*if(medicalCenter.getAddress()!=null && !medicalCenter.getAddress().isEmpty()) {
					if((coords = GoogleGeoCoder.getCoordinates(medicalCenter.getAddress()))!=null) {
						medicalCenter.setLat(coords.get("lat"));
						medicalCenter.setLng(coords.get("lng"));
					}
				}*/
				chr = calculatedMedicalCenterRatingService.findByMedicalCenterId(medicalCenter.getId());
				if(chr!=null) {
					medicalCenter.setPriceRating(chr.getPriceRating()!=null?chr.getPriceRating():0);
					medicalCenter.setServiceRating(chr.getServiceRating()!=null?chr.getServiceRating():0);
					medicalCenter.setPriceCount(chr.getPriceCount()!=null?chr.getPriceCount():0);
					medicalCenter.setServiceCount(chr.getServiceCount()!=null?chr.getServiceCount():0);
				} else {
					medicalCenter.setPriceRating((short)0);
					medicalCenter.setServiceRating((short)0);
					medicalCenter.setPriceCount(0L);
					medicalCenter.setServiceCount(0L);
				}
				medicalCenters.add(medicalCenter);
			}
			if(nameSort!=null && nameSort==true){
				Collections.sort(medicalCenters, new Comparator<MedicalCenter>(){
					@Override
					public int compare(MedicalCenter arg0, MedicalCenter arg1) {
						return arg1.getOrganizationName().compareTo(arg0.getOrganizationName());
					}
					
				});
			}
			if(priceSort!=null && priceSort==true){
				Collections.sort(medicalCenters, new Comparator<MedicalCenter>(){
					@Override
					public int compare(MedicalCenter arg0, MedicalCenter arg1) {
						return arg1.getPriceRating().compareTo(arg0.getPriceRating());
					}
					
				});
			}
			if(serviceSort!=null && serviceSort==true){
				Collections.sort(medicalCenters, new Comparator<MedicalCenter>(){
					@Override
					public int compare(MedicalCenter arg0, MedicalCenter arg1) {
						return arg1.getServiceRating().compareTo(arg0.getServiceRating());
					}
					
				});
			}
			for (MedicalCenter h : medicalCenters) {
				System.out.println(h.toString());
			}
		} catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return medicalCenters;
	}

	@Override
	public MedicalCenter findOne(Long id) {
		MedicalCenter medicalCenter = null;
		String str="";
		try{
			URL url = new URL(this.egovApiUrl+"?source={%20\"size\":1,%20\"query\":%20{%20\"bool\":{%20\"must\":[%20{\"match\":{\"id\":%20\""+id+"\"}}%20]%20}%20}%20}");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url.toString());
			System.out.println("Response Code : " + responseCode);

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = bufferedReader.readLine()) != null) {
				response.append(inputLine);
			}
			bufferedReader.close();
			JSONArray jsonArr = new JSONArray(response.toString());
			CalculatedMedicalCenterRating chr = null;
			MedicalCenterRating hr = null;
			User curUser = new User();
			HashMap<String,Double> coords;
			Gson gson = new Gson();
			medicalCenter = gson.fromJson(jsonArr.getJSONObject(0).toString(), MedicalCenter.class);
			/*if(medicalCenter.getAddress()!=null && !medicalCenter.getAddress().isEmpty()) {
				if((coords = GoogleGeoCoder.getCoordinates(medicalCenter.getAddress()))!=null) {
					medicalCenter.setLat(coords.get("lat"));
					medicalCenter.setLng(coords.get("lng"));
				}
			}*/
			chr = calculatedMedicalCenterRatingService.findByMedicalCenterId(medicalCenter.getId());
			if(chr!=null) {
				medicalCenter.setPriceRating(chr.getPriceRating()!=null?chr.getPriceRating():0);
				medicalCenter.setServiceRating(chr.getServiceRating()!=null?chr.getServiceRating():0);
				medicalCenter.setPriceCount(chr.getPriceCount()!=null?chr.getPriceCount():0);
				medicalCenter.setServiceCount(chr.getServiceCount()!=null?chr.getServiceCount():0);
			} else {
				medicalCenter.setPriceRating((short)0);
				medicalCenter.setServiceRating((short)0);
				medicalCenter.setPriceCount(0L);
				medicalCenter.setServiceCount(0L);
			}
			curUser = userService.getCurrentUser();
			if(curUser!=null) {
				hr = medicalCenterRatingService.findByUserForMedicalCenter(curUser.getId(), medicalCenter.getId());
				if(hr!=null) {
					medicalCenter.setCurUserPriceRating(hr.getPrice());
					medicalCenter.setCurUserServiceRating(hr.getService());
				}
			}
			System.out.println(medicalCenter.toString());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		return medicalCenter;
	}

	@Override
	public void ratePrice(Long id, Short price) {
		User currentUser = userService.getCurrentUser();
		MedicalCenterRating medicalCenterRating = medicalCenterRatingService.findByUserForMedicalCenter(currentUser.getId(), id);
		if(medicalCenterRating==null) {
			medicalCenterRating = new MedicalCenterRating();
			medicalCenterRating.setUser(currentUser);
			medicalCenterRating.setMedicalCenterId(id);
		}
		medicalCenterRating.setPrice(price);
		medicalCenterRatingService.save(medicalCenterRating);
		
		CalculatedMedicalCenterRating calcMedicalCenterRating = calculatedMedicalCenterRatingService.findByMedicalCenterId(id);
		if(calcMedicalCenterRating==null) {
			calcMedicalCenterRating = new CalculatedMedicalCenterRating();
			calcMedicalCenterRating.setMedicalCenterId(id);
		}
		calcMedicalCenterRating.setPriceRating(medicalCenterRatingService.calculatePriceAvg(id));
		calcMedicalCenterRating.setPriceCount(medicalCenterRatingService.calculatePriceCount(id));
		calculatedMedicalCenterRatingService.save(calcMedicalCenterRating);
	}

	@Override
	public void rateService(Long id, Short service) {
		User currentUser = userService.getCurrentUser();
		MedicalCenterRating medicalCenterRating = medicalCenterRatingService.findByUserForMedicalCenter(currentUser.getId(), id);
		if(medicalCenterRating==null) {
			medicalCenterRating = new MedicalCenterRating();
			medicalCenterRating.setUser(currentUser);
			medicalCenterRating.setMedicalCenterId(id);
		}
		medicalCenterRating.setService(service);
		medicalCenterRatingService.save(medicalCenterRating);
		
		CalculatedMedicalCenterRating calcMedicalCenterRating = calculatedMedicalCenterRatingService.findByMedicalCenterId(id);
		if(calcMedicalCenterRating==null) {
			calcMedicalCenterRating = new CalculatedMedicalCenterRating();
			calcMedicalCenterRating.setMedicalCenterId(id);
		}
		calcMedicalCenterRating.setServiceRating(medicalCenterRatingService.calculateServiceAvg(id));
		calcMedicalCenterRating.setServiceCount(medicalCenterRatingService.calculateServiceCount(id));
		calculatedMedicalCenterRatingService.save(calcMedicalCenterRating);
	}

}
