package kz.salikhanova.healthapp.service;

import java.util.HashMap;
import java.util.List;

import kz.salikhanova.healthapp.model.Hospital;

public interface HospitalService {
	
	List<Hospital> findAll();
	
	HashMap<String,Double> getCoordinates(String address);

}
