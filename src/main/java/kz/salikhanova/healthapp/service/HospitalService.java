package kz.salikhanova.healthapp.service;

import java.util.HashMap;
import java.util.List;

import kz.salikhanova.healthapp.model.Drugstore;
import kz.salikhanova.healthapp.model.Hospital;

public interface HospitalService {
	
	List<Hospital> findAll(Boolean nameSort, Boolean priceSort, Boolean serviceSort);
	Hospital findOne(Long id);
	void ratePrice(Long id, Short price);
	void rateService(Long id, Short service);
}
