package kz.salikhanova.healthapp.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import org.json.JSONObject;

public class GoogleGeoCoder {

	private static String gglMapsApiUrl = "https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyD1eYhE8DgMPKw78c4t-ER7WONluE7cjkE";
	
	public static HashMap<String,Double> getCoordinates(String address) {
		HashMap<String,Double> coordinates = null;
		try{
			String strUrl = gglMapsApiUrl+"&address="+URLEncoder.encode("г.јстана,"+address,"UTF-8");
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
					JSONObject location = jsonObj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
					coordinates = new HashMap<String,Double>();
					coordinates.put("lat", location.getDouble("lat"));
					coordinates.put("lng", location.getDouble("lng"));
				}
			}
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		return coordinates;
	}
}
