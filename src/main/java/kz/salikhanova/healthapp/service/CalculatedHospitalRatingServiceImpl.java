package kz.salikhanova.healthapp.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.salikhanova.healthapp.dao.CalculatedHospitalRatingDao;
import kz.salikhanova.healthapp.model.CalculatedHospitalRating;

@Service("calculatedHospitalRatingService")
public class CalculatedHospitalRatingServiceImpl implements CalculatedHospitalRatingService {

	@Autowired
	private CalculatedHospitalRatingDao calculatedHospitalRatingDao;
	
	@Resource(name = "hospitalRatingService")
	private HospitalRatingService hospitalRatingService;
	
	@Override
	public CalculatedHospitalRating findByHospitalId(Long hospitalId) {
		CalculatedHospitalRating calcHospitalRating = calculatedHospitalRatingDao.findByHospitalId(hospitalId);
		if(calcHospitalRating==null){
			if(hospitalRatingService.findOne(hospitalId)!=null){
				calcHospitalRating = new CalculatedHospitalRating();
				calcHospitalRating.setHospitalId(hospitalId);
				calcHospitalRating.setPriceRating(hospitalRatingService.calculatePriceAvg(hospitalId));
				calcHospitalRating.setPriceCount(hospitalRatingService.calculatePriceCount(hospitalId));
				calcHospitalRating.setServiceRating(hospitalRatingService.calculateServiceAvg(hospitalId));
				calcHospitalRating.setServiceCount(hospitalRatingService.calculateServiceCount(hospitalId));
				this.save(calcHospitalRating);
				return calcHospitalRating;
			} else{
				return null;
			}
		} else{
			return calcHospitalRating;
		}
	}

	@Override
	public void save(CalculatedHospitalRating calculatedHospitalRating) {
		calculatedHospitalRatingDao.save(calculatedHospitalRating);
	}

}
