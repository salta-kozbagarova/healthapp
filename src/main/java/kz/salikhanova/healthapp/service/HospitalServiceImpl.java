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

import kz.salikhanova.healthapp.model.Hospital;
import kz.salikhanova.healthapp.util.GoogleGeoCoder;

@Service("hospitalService")
public class HospitalServiceImpl implements HospitalService {

	private static String egovApiUrl = "http://data.egov.kz/api/v2/auruhanalar/v2";
	
	@Override
	public List<Hospital> findAll() {
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
				hospitals.add(hospital);
			}
			for (Hospital hosp : hospitals) {
				System.out.println(hosp.toString());
			}
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		return hospitals;
	}

}
