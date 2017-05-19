package kz.salikhanova.healthapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.salikhanova.healthapp.dao.CalculatedHospitalRatingDao;
import kz.salikhanova.healthapp.model.CalculatedHospitalRating;

@Service("calculatedHospitalRatingService")
public class CalculatedHospitalRatingServiceImpl implements CalculatedHospitalRatingService {

	@Autowired
	private CalculatedHospitalRatingDao calculatedHospitalRatingDao;
	
	@Override
	public CalculatedHospitalRating findByHospitalId(Long hospitalId) {
		return calculatedHospitalRatingDao.findByHospitalId(hospitalId);
	}

	@Override
	public void save(CalculatedHospitalRating calculatedHospitalRating) {
		calculatedHospitalRatingDao.save(calculatedHospitalRating);
	}

}
