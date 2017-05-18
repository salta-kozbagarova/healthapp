package kz.salikhanova.healthapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.salikhanova.healthapp.dao.CalculatedDrugstoreRatingDao;
import kz.salikhanova.healthapp.model.CalculatedDrugstoreRating;

@Service("calculatedDrugstoreRatingService")
public class CalculatedDrugstoreRatingServiceImpl implements CalculatedDrugstoreRatingService {

	@Autowired
	private CalculatedDrugstoreRatingDao calculatedDrugstoreRatingDao;

	@Override
	public CalculatedDrugstoreRating findByDrugstoreId(Long drugstoreId) {
		return calculatedDrugstoreRatingDao.findByDrugstoreId(drugstoreId);
	}

	@Override
	public void save(CalculatedDrugstoreRating calculatedDrugstoreRating) {
		calculatedDrugstoreRatingDao.save(calculatedDrugstoreRating);
	}
}
