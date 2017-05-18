package kz.salikhanova.healthapp.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import kz.salikhanova.healthapp.model.CalculatedDrugstoreRating;
import kz.salikhanova.healthapp.model.Drugstore;
import kz.salikhanova.healthapp.model.DrugstoreRating;
import kz.salikhanova.healthapp.model.User;
import kz.salikhanova.healthapp.util.GoogleGeoCoder;

@Service("drugstoreService")
public class DrugstoreServiceImpl implements DrugstoreService {

	private static String egovApiUrl = "http://data.egov.kz/api/v2/darihanalar1/v2";
	
	@Resource(name = "drugstoreRatingService")
	private DrugstoreRatingService drugstoreRatingService;
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "calculatedDrugstoreRatingService")
	private CalculatedDrugstoreRatingService calculatedDrugstoreRatingService;
	
	@Override
	public List<Drugstore> findAll() {
		List<Drugstore> drugstores = new ArrayList<Drugstore>();
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
			Drugstore drugstore = null;
			CalculatedDrugstoreRating cdr = null;
			HashMap<String,Double> coords;
			for (int i = 0; i < jsonArr.length(); i++) {
				JSONObject jsonObj = jsonArr.getJSONObject(i);
				Gson gson = new Gson();
				drugstore = gson.fromJson(jsonObj.toString(), Drugstore.class);
				if(drugstore.getAddress()!=null && !drugstore.getAddress().isEmpty()) {
					if((coords = GoogleGeoCoder.getCoordinates(drugstore.getAddress()))!=null) {
						drugstore.setLat(coords.get("lat"));
						drugstore.setLng(coords.get("lng"));
					}
				}
				cdr = calculatedDrugstoreRatingService.findByDrugstoreId(drugstore.getId());
				if(cdr!=null) {
					drugstore.setPriceRating(cdr.getPriceRating()!=null?cdr.getPriceRating():0);
					drugstore.setDrugsAvailabilityRating(cdr.getDrugsAvailabilityRating()!=null?cdr.getDrugsAvailabilityRating():0);
					drugstore.setPriceCount(cdr.getPriceCount()!=null?cdr.getPriceCount():0);
					drugstore.setDrugsAvailabilityCount(cdr.getDrugsAvailabilityCount()!=null?cdr.getDrugsAvailabilityCount():0);
				} else {
					drugstore.setPriceRating((short)0);
					drugstore.setDrugsAvailabilityRating((short)0);
					drugstore.setPriceCount(0L);
					drugstore.setDrugsAvailabilityCount(0L);
				}
				drugstores.add(drugstore);
			}
			for (Drugstore ds : drugstores) {
				System.out.println(ds.toString());
			}
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		return drugstores;
	}

	@Override
	public Drugstore findOne(Long id) {
		Drugstore drugstore = null;
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
			CalculatedDrugstoreRating cdr = null;
			DrugstoreRating dr = null;
			User curUser = new User();
			HashMap<String,Double> coords;
			Gson gson = new Gson();
			drugstore = gson.fromJson(jsonArr.getJSONObject(0).toString(), Drugstore.class);
			if(drugstore.getAddress()!=null && !drugstore.getAddress().isEmpty()) {
				if((coords = GoogleGeoCoder.getCoordinates(drugstore.getAddress()))!=null) {
					drugstore.setLat(coords.get("lat"));
					drugstore.setLng(coords.get("lng"));
				}
			}
			cdr = calculatedDrugstoreRatingService.findByDrugstoreId(drugstore.getId());
			if(cdr!=null) {
				drugstore.setPriceRating(cdr.getPriceRating()!=null?cdr.getPriceRating():0);
				drugstore.setDrugsAvailabilityRating(cdr.getDrugsAvailabilityRating()!=null?cdr.getDrugsAvailabilityRating():0);
				drugstore.setPriceCount(cdr.getPriceCount()!=null?cdr.getPriceCount():0);
				drugstore.setDrugsAvailabilityCount(cdr.getDrugsAvailabilityCount()!=null?cdr.getDrugsAvailabilityCount():0);
			} else {
				drugstore.setPriceRating((short)0);
				drugstore.setDrugsAvailabilityRating((short)0);
				drugstore.setPriceCount(0L);
				drugstore.setDrugsAvailabilityCount(0L);
			}
			curUser = userService.getCurrentUser();
			if(curUser!=null) {
				dr = drugstoreRatingService.findByUserForDrugstore(curUser.getId(), drugstore.getId());
				if(dr!=null) {
					drugstore.setCurUserPriceRating(dr.getPrice());
					drugstore.setCurUserDrugsAvailabilityRating(dr.getDrugsAvailability());
				}
			}
			
			System.out.println(drugstore.toString());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		return drugstore;
	}

	@Override
	public void ratePrice(Long id, Short price) {
		User currentUser = userService.getCurrentUser();
		DrugstoreRating drugstoreRating = drugstoreRatingService.findByUserForDrugstore(currentUser.getId(), id);
		if(drugstoreRating==null) {
			drugstoreRating = new DrugstoreRating();
			drugstoreRating.setUser(currentUser);
			drugstoreRating.setDrugstoreId(id);
		}
		drugstoreRating.setPrice(price);
		drugstoreRatingService.save(drugstoreRating);
		
		CalculatedDrugstoreRating calcDrugstoreRating = calculatedDrugstoreRatingService.findByDrugstoreId(id);
		if(calcDrugstoreRating==null) {
			calcDrugstoreRating = new CalculatedDrugstoreRating();
			calcDrugstoreRating.setDrugstoreId(id);
		}
		calcDrugstoreRating.setPriceRating(drugstoreRatingService.calculatePriceAvg(id));
		calcDrugstoreRating.setPriceCount(drugstoreRatingService.calculatePriceCount(id));
		calculatedDrugstoreRatingService.save(calcDrugstoreRating);
	}
	
	@Override
	public void rateDrugsAvailability(Long id, Short drugsAvailability) {
		User currentUser = userService.getCurrentUser();
		DrugstoreRating drugstoreRating = drugstoreRatingService.findByUserForDrugstore(currentUser.getId(), id);
		if(drugstoreRating==null) {
			drugstoreRating = new DrugstoreRating();
			drugstoreRating.setUser(currentUser);
			drugstoreRating.setDrugstoreId(id);
		}
		drugstoreRating.setDrugsAvailability(drugsAvailability);
		drugstoreRatingService.save(drugstoreRating);
		
		CalculatedDrugstoreRating calcDrugstoreRating = calculatedDrugstoreRatingService.findByDrugstoreId(id);
		if(calcDrugstoreRating==null) {
			calcDrugstoreRating = new CalculatedDrugstoreRating();
			calcDrugstoreRating.setDrugstoreId(id);
		}
		calcDrugstoreRating.setDrugsAvailabilityRating(drugstoreRatingService.calculateDrugsAvailabilityAvg(id));
		calcDrugstoreRating.setDrugsAvailabilityCount(drugstoreRatingService.calculateDrugsAvailabilityCount(id));
		calculatedDrugstoreRatingService.save(calcDrugstoreRating);
	}

}
