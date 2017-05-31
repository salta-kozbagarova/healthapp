package kz.salikhanova.healthapp.service;

import java.util.List;

import kz.salikhanova.healthapp.model.MedicalCenter;

public interface MedicalCenterService {

	List<MedicalCenter> findAll(Boolean nameSort, Boolean priceSort, Boolean serviceSort);
	MedicalCenter findOne(Long id);
	void ratePrice(Long id, Short price);
	void rateService(Long id, Short service);
}
