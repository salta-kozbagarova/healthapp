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

import kz.salikhanova.healthapp.model.CalculatedHospitalRating;
import kz.salikhanova.healthapp.model.CalculatedPolyclinicRating;
import kz.salikhanova.healthapp.model.Hospital;
import kz.salikhanova.healthapp.model.HospitalRating;
import kz.salikhanova.healthapp.model.Polyclinic;
import kz.salikhanova.healthapp.model.PolyclinicRating;
import kz.salikhanova.healthapp.model.User;
import kz.salikhanova.healthapp.util.GoogleGeoCoder;

@Service("polyclinicService")
public class PolyclinicServiceImpl implements PolyclinicService {

	private static String egovApiUrl = "http://data.egov.kz/api/v2/emhanalar/v2";
	
	@Resource(name = "polyclinicRatingService")
	private PolyclinicRatingService polyclinicRatingService;
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "calculatedPolyclinicRatingService")
	private CalculatedPolyclinicRatingService calculatedPolyclinicRatingService;
	
	@Override
	public List<Polyclinic> findAll(Boolean nameSort, Boolean priceSort, Boolean serviceSort) {
		List<Polyclinic> polyclinics = new ArrayList<Polyclinic>();
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
			Polyclinic polyclinic = null;
			CalculatedPolyclinicRating chr = null;
			HashMap<String,Double> coords;
			for (int i = 0; i < jsonArr.length(); i++) {
				JSONObject jsonObj = jsonArr.getJSONObject(i);
				Gson gson = new Gson();
				polyclinic = gson.fromJson(jsonObj.toString(), Polyclinic.class);
				if(polyclinic.getAddress()!=null && !polyclinic.getAddress().isEmpty()) {
					if((coords = GoogleGeoCoder.getCoordinates(polyclinic.getAddress()))!=null) {
						polyclinic.setLat(coords.get("lat"));
						polyclinic.setLng(coords.get("lng"));
					}
				}
				chr = calculatedPolyclinicRatingService.findByPolyclinicId(polyclinic.getId());
				if(chr!=null) {
					polyclinic.setPriceRating(chr.getPriceRating()!=null?chr.getPriceRating():0);
					polyclinic.setServiceRating(chr.getServiceRating()!=null?chr.getServiceRating():0);
					polyclinic.setPriceCount(chr.getPriceCount()!=null?chr.getPriceCount():0);
					polyclinic.setServiceCount(chr.getServiceCount()!=null?chr.getServiceCount():0);
				} else {
					polyclinic.setPriceRating((short)0);
					polyclinic.setServiceRating((short)0);
					polyclinic.setPriceCount(0L);
					polyclinic.setServiceCount(0L);
				}
				polyclinics.add(polyclinic);
			}
			if(nameSort!=null && nameSort==true){
				Collections.sort(polyclinics, new Comparator<Polyclinic>(){
					@Override
					public int compare(Polyclinic arg0, Polyclinic arg1) {
						return arg1.getOrganizationName().compareTo(arg0.getOrganizationName());
					}
					
				});
			}
			if(priceSort!=null && priceSort==true){
				Collections.sort(polyclinics, new Comparator<Polyclinic>(){
					@Override
					public int compare(Polyclinic arg0, Polyclinic arg1) {
						return arg1.getPriceRating().compareTo(arg0.getPriceRating());
					}
					
				});
			}
			if(serviceSort!=null && serviceSort==true){
				Collections.sort(polyclinics, new Comparator<Polyclinic>(){
					@Override
					public int compare(Polyclinic arg0, Polyclinic arg1) {
						return arg1.getServiceRating().compareTo(arg0.getServiceRating());
					}
					
				});
			}
			for (Polyclinic h : polyclinics) {
				System.out.println(h.toString());
			}
		} catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return polyclinics;
	}

	@Override
	public Polyclinic findOne(Long id) {
		Polyclinic polyclinic = null;
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
			CalculatedPolyclinicRating chr = null;
			PolyclinicRating hr = null;
			User curUser = new User();
			HashMap<String,Double> coords;
			Gson gson = new Gson();
			polyclinic = gson.fromJson(jsonArr.getJSONObject(0).toString(), Polyclinic.class);
			if(polyclinic.getAddress()!=null && !polyclinic.getAddress().isEmpty()) {
				if((coords = GoogleGeoCoder.getCoordinates(polyclinic.getAddress()))!=null) {
					polyclinic.setLat(coords.get("lat"));
					polyclinic.setLng(coords.get("lng"));
				}
			}
			chr = calculatedPolyclinicRatingService.findByPolyclinicId(polyclinic.getId());
			if(chr!=null) {
				polyclinic.setPriceRating(chr.getPriceRating()!=null?chr.getPriceRating():0);
				polyclinic.setServiceRating(chr.getServiceRating()!=null?chr.getServiceRating():0);
				polyclinic.setPriceCount(chr.getPriceCount()!=null?chr.getPriceCount():0);
				polyclinic.setServiceCount(chr.getServiceCount()!=null?chr.getServiceCount():0);
			} else {
				polyclinic.setPriceRating((short)0);
				polyclinic.setServiceRating((short)0);
				polyclinic.setPriceCount(0L);
				polyclinic.setServiceCount(0L);
			}
			curUser = userService.getCurrentUser();
			if(curUser!=null) {
				hr = polyclinicRatingService.findByUserForPolyclinic(curUser.getId(), polyclinic.getId());
				if(hr!=null) {
					polyclinic.setCurUserPriceRating(hr.getPrice());
					polyclinic.setCurUserServiceRating(hr.getService());
				}
			}
			System.out.println(polyclinic.toString());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		return polyclinic;
	}

	@Override
	public void ratePrice(Long id, Short price) {
		User currentUser = userService.getCurrentUser();
		PolyclinicRating polyclinicRating = polyclinicRatingService.findByUserForPolyclinic(currentUser.getId(), id);
		if(polyclinicRating==null) {
			polyclinicRating = new PolyclinicRating();
			polyclinicRating.setUser(currentUser);
			polyclinicRating.setPolyclinicId(id);
		}
		polyclinicRating.setPrice(price);
		polyclinicRatingService.save(polyclinicRating);
		
		CalculatedPolyclinicRating calcPolyclinicRating = calculatedPolyclinicRatingService.findByPolyclinicId(id);
		if(calcPolyclinicRating==null) {
			calcPolyclinicRating = new CalculatedPolyclinicRating();
			calcPolyclinicRating.setPolyclinicId(id);
		}
		calcPolyclinicRating.setPriceRating(polyclinicRatingService.calculatePriceAvg(id));
		calcPolyclinicRating.setPriceCount(polyclinicRatingService.calculatePriceCount(id));
		calculatedPolyclinicRatingService.save(calcPolyclinicRating);
	}

	@Override
	public void rateService(Long id, Short service) {
		User currentUser = userService.getCurrentUser();
		PolyclinicRating polyclinicRating = polyclinicRatingService.findByUserForPolyclinic(currentUser.getId(), id);
		if(polyclinicRating==null) {
			polyclinicRating = new PolyclinicRating();
			polyclinicRating.setUser(currentUser);
			polyclinicRating.setPolyclinicId(id);
		}
		polyclinicRating.setService(service);
		polyclinicRatingService.save(polyclinicRating);
		
		CalculatedPolyclinicRating calcPolyclinicRating = calculatedPolyclinicRatingService.findByPolyclinicId(id);
		if(calcPolyclinicRating==null) {
			calcPolyclinicRating = new CalculatedPolyclinicRating();
			calcPolyclinicRating.setPolyclinicId(id);
		}
		calcPolyclinicRating.setServiceRating(polyclinicRatingService.calculateServiceAvg(id));
		calcPolyclinicRating.setServiceCount(polyclinicRatingService.calculateServiceCount(id));
		calculatedPolyclinicRatingService.save(calcPolyclinicRating);
	}

}
