package kz.salikhanova.healthapp.service;

import java.util.List;

import kz.salikhanova.healthapp.model.Drugstore;

public interface DrugstoreService {
	
	List<Drugstore> findAll(Boolean nameSort, Boolean priceSort, Boolean drugsSort);
	Drugstore findOne(Long id);
	void ratePrice(Long id, Short price);
	void rateDrugsAvailability(Long id, Short drugsAvailability);
}
