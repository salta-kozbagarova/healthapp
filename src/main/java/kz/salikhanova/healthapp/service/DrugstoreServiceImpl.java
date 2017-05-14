package kz.salikhanova.healthapp.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import kz.salikhanova.healthapp.model.Drugstore;

@Service("drugstoreService")
public class DrugstoreServiceImpl implements DrugstoreService {

	private static String gglMapsApiUrl = "https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyD1eYhE8DgMPKw78c4t-ER7WONluE7cjkE";
	private static String egovApiUrl = "http://data.egov.kz/api/v2/darihanalar1/v2";
	
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
			HashMap<String,Double> coords;
			for (int i = 0; i < jsonArr.length(); i++) {
				JSONObject jsonObj = jsonArr.getJSONObject(i);
				Gson gson = new Gson();
				drugstore = gson.fromJson(jsonObj.toString(), Drugstore.class);
				if(drugstore.getAddress()!=null && !drugstore.getAddress().isEmpty()) {
					if((coords = this.getCoordinates(drugstore.getAddress()))!=null) {
						drugstore.setLat(coords.get("lat"));
						drugstore.setLng(coords.get("lng"));
					}
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
	public HashMap<String,Double> getCoordinates(String address) {
		HashMap<String,Double> coordinates = new HashMap<String,Double>();
		try{
			String strUrl = this.gglMapsApiUrl+"&address="+URLEncoder.encode("г.јстана,"+address,"UTF-8");
			URL url = new URL(strUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + strUrl);
			System.out.println("Response Code : " + responseCode);

			if(responseCode==200) {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = bufferedReader.readLine()) != null) {
					response.append(inputLine);
				}
				bufferedReader.close();
				JSONObject jsonObj = new JSONObject(response.toString());
				if(jsonObj.getString("status").compareToIgnoreCase("OK")==0) {
					System.out.println("we r here");
					JSONObject location = jsonObj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
					double lat = location.getDouble("lat");
					double lng = location.getDouble("lng");
					coordinates.put("lat", lat);
					coordinates.put("lng", lng);
					System.out.println("lat  "+lat+"  lng  "+lng);
				}
			}
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		return !coordinates.isEmpty()?coordinates:null;
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
			HashMap<String,Double> coords;
			Gson gson = new Gson();
			drugstore = gson.fromJson(jsonArr.getJSONObject(0).toString(), Drugstore.class);
			if(drugstore.getAddress()!=null && !drugstore.getAddress().isEmpty()) {
				if((coords = this.getCoordinates(drugstore.getAddress()))!=null) {
					drugstore.setLat(coords.get("lat"));
					drugstore.setLng(coords.get("lng"));
				}
			}
			System.out.println(drugstore.toString());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		return drugstore;
	}

}
