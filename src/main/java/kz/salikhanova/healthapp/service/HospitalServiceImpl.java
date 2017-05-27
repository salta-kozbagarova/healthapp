package kz.salikhanova.healthapp.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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

import kz.salikhanova.healthapp.model.CalculatedDrugstoreRating;
import kz.salikhanova.healthapp.model.CalculatedHospitalRating;
import kz.salikhanova.healthapp.model.Drugstore;
import kz.salikhanova.healthapp.model.DrugstoreRating;
import kz.salikhanova.healthapp.model.Hospital;
import kz.salikhanova.healthapp.model.HospitalRating;
import kz.salikhanova.healthapp.model.User;
import kz.salikhanova.healthapp.util.GoogleGeoCoder;

@Service("hospitalService")
public class HospitalServiceImpl implements HospitalService {

	private static String egovApiUrl = "http://data.egov.kz/api/v2/auruhanalar/v2";
	
	@Resource(name = "hospitalRatingService")
	private HospitalRatingService hospitalRatingService;
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "calculatedHospitalRatingService")
	private CalculatedHospitalRatingService calculatedHospitalRatingService;
	
	@Override
	public List<Hospital> findAll(Boolean nameSort, Boolean priceSort, Boolean serviceSort) {
		List<Hospital> hospitals = new ArrayList<Hospital>();
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
			Hospital hospital = null;
			CalculatedHospitalRating chr = null;
			HashMap<String,Double> coords;
			for (int i = 0; i < jsonArr.length(); i++) {
				JSONObject jsonObj = jsonArr.getJSONObject(i);
				Gson gson = new Gson();
				hospital = gson.fromJson(jsonObj.toString(), Hospital.class);
				if(hospital.getAddress()!=null && !hospital.getAddress().isEmpty()) {
					if((coords = GoogleGeoCoder.getCoordinates(hospital.getAddress()))!=null) {
						hospital.setLat(coords.get("lat"));
						hospital.setLng(coords.get("lng"));
					}
				}
				chr = calculatedHospitalRatingService.findByHospitalId(hospital.getId());
				if(chr!=null) {
					hospital.setPriceRating(chr.getPriceRating()!=null?chr.getPriceRating():0);
					hospital.setServiceRating(chr.getServiceRating()!=null?chr.getServiceRating():0);
					hospital.setPriceCount(chr.getPriceCount()!=null?chr.getPriceCount():0);
					hospital.setServiceCount(chr.getServiceCount()!=null?chr.getServiceCount():0);
				} else {
					hospital.setPriceRating((short)0);
					hospital.setServiceRating((short)0);
					hospital.setPriceCount(0L);
					hospital.setServiceCount(0L);
				}
				hospitals.add(hospital);
			}
			if(nameSort!=null && nameSort==true){
				Collections.sort(hospitals, new Comparator<Hospital>(){
					@Override
					public int compare(Hospital arg0, Hospital arg1) {
						return arg1.getNaimenovanieOganizacii().compareTo(arg0.getNaimenovanieOganizacii());
					}
					
				});
			}
			if(priceSort!=null && priceSort==true){
				Collections.sort(hospitals, new Comparator<Hospital>(){
					@Override
					public int compare(Hospital arg0, Hospital arg1) {
						return arg1.getPriceRating().compareTo(arg0.getPriceRating());
					}
					
				});
			}
			if(serviceSort!=null && serviceSort==true){
				Collections.sort(hospitals, new Comparator<Hospital>(){
					@Override
					public int compare(Hospital arg0, Hospital arg1) {
						return arg1.getServiceRating().compareTo(arg0.getServiceRating());
					}
					
				});
			}
			for (Hospital h : hospitals) {
				System.out.println(h.toString());
			}
		} catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return hospitals;
	}

	@Override
	public Hospital findOne(Long id) {
		Hospital hospital = null;
		String str="";
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
			CalculatedHospitalRating chr = null;
			HospitalRating hr = null;
			User curUser = new User();
			HashMap<String,Double> coords;
			Gson gson = new Gson();
			hospital = gson.fromJson(jsonArr.getJSONObject(0).toString(), Hospital.class);
			if(hospital.getAddress()!=null && !hospital.getAddress().isEmpty()) {
				if((coords = GoogleGeoCoder.getCoordinates(hospital.getAddress()))!=null) {
					hospital.setLat(coords.get("lat"));
					hospital.setLng(coords.get("lng"));
				}
			}
			chr = calculatedHospitalRatingService.findByHospitalId(hospital.getId());
			if(chr!=null) {
				hospital.setPriceRating(chr.getPriceRating()!=null?chr.getPriceRating():0);
				hospital.setServiceRating(chr.getServiceRating()!=null?chr.getServiceRating():0);
				hospital.setPriceCount(chr.getPriceCount()!=null?chr.getPriceCount():0);
				hospital.setServiceCount(chr.getServiceCount()!=null?chr.getServiceCount():0);
			} else {
				hospital.setPriceRating((short)0);
				hospital.setServiceRating((short)0);
				hospital.setPriceCount(0L);
				hospital.setServiceCount(0L);
			}
			curUser = userService.getCurrentUser();
			if(curUser!=null) {
				hr = hospitalRatingService.findByUserForHospital(curUser.getId(), hospital.getId());
				if(hr!=null) {
					hospital.setCurUserPriceRating(hr.getPrice());
					hospital.setCurUserServiceRating(hr.getService());
				}
			}
			System.out.println(hospital.toString());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		return hospital;
	}

	@Override
	public void ratePrice(Long id, Short price) {
		User currentUser = userService.getCurrentUser();
		HospitalRating hospitalRating = hospitalRatingService.findByUserForHospital(currentUser.getId(), id);
		if(hospitalRating==null) {
			hospitalRating = new HospitalRating();
			hospitalRating.setUser(currentUser);
			hospitalRating.setHospitalId(id);
		}
		hospitalRating.setPrice(price);
		hospitalRatingService.save(hospitalRating);
		
		CalculatedHospitalRating calcHospitalRating = calculatedHospitalRatingService.findByHospitalId(id);
		if(calcHospitalRating==null) {
			calcHospitalRating = new CalculatedHospitalRating();
			calcHospitalRating.setHospitalId(id);
		}
		calcHospitalRating.setPriceRating(hospitalRatingService.calculatePriceAvg(id));
		calcHospitalRating.setPriceCount(hospitalRatingService.calculatePriceCount(id));
		calculatedHospitalRatingService.save(calcHospitalRating);
	}

	@Override
	public void rateService(Long id, Short service) {
		User currentUser = userService.getCurrentUser();
		HospitalRating hospitalRating = hospitalRatingService.findByUserForHospital(currentUser.getId(), id);
		if(hospitalRating==null) {
			hospitalRating = new HospitalRating();
			hospitalRating.setUser(currentUser);
			hospitalRating.setHospitalId(id);
		}
		hospitalRating.setService(service);
		hospitalRatingService.save(hospitalRating);
		
		CalculatedHospitalRating calcHospitalRating = calculatedHospitalRatingService.findByHospitalId(id);
		if(calcHospitalRating==null) {
			calcHospitalRating = new CalculatedHospitalRating();
			calcHospitalRating.setHospitalId(id);
		}
		calcHospitalRating.setServiceRating(hospitalRatingService.calculateServiceAvg(id));
		calcHospitalRating.setServiceCount(hospitalRatingService.calculateServiceCount(id));
		calculatedHospitalRatingService.save(calcHospitalRating);
	}
}
