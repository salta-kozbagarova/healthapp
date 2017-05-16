package kz.salikhanova.healthapp.service;

import java.util.HashMap;
import java.util.List;

import kz.salikhanova.healthapp.model.Drugstore;

public interface DrugstoreService {
	
	List<Drugstore> findAll();
	Drugstore findOne(Long id);

}
