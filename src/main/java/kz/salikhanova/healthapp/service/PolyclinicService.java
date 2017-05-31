package kz.salikhanova.healthapp.service;

import java.util.List;

import kz.salikhanova.healthapp.model.Polyclinic;

public interface PolyclinicService {

	List<Polyclinic> findAll(Boolean nameSort, Boolean priceSort, Boolean serviceSort);
	Polyclinic findOne(Long id);
	void ratePrice(Long id, Short price);
	void rateService(Long id, Short service);
}
