package kz.salikhanova.healthapp.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.salikhanova.healthapp.dao.CalculatedMedicalCenterRatingDao;
import kz.salikhanova.healthapp.model.CalculatedMedicalCenterRating;

@Service("calculatedMedicalCenterRatingService")
public class CalculatedMedicalCenterRatingServiceImpl implements CalculatedMedicalCenterRatingService {

	@Autowired
	private CalculatedMedicalCenterRatingDao calculatedMedicalCenterRatingDao;
	
	@Resource(name = "medicalCenterRatingService")
	private MedicalCenterRatingService medicalCenterRatingService;
	
	@Override
	public CalculatedMedicalCenterRating findByMedicalCenterId(Long medicalCenterId) {
		CalculatedMedicalCenterRating calcPolyclinicRating = calculatedMedicalCenterRatingDao.findByMedicalCenterId(medicalCenterId);
		if(calcPolyclinicRating==null){
			if(medicalCenterRatingService.findOne(medicalCenterId)!=null){
				calcPolyclinicRating = new CalculatedMedicalCenterRating();
				calcPolyclinicRating.setMedicalCenterId(medicalCenterId);
				calcPolyclinicRating.setPriceRating(medicalCenterRatingService.calculatePriceAvg(medicalCenterId));
				calcPolyclinicRating.setPriceCount(medicalCenterRatingService.calculatePriceCount(medicalCenterId));
				calcPolyclinicRating.setServiceRating(medicalCenterRatingService.calculateServiceAvg(medicalCenterId));
				calcPolyclinicRating.setServiceCount(medicalCenterRatingService.calculateServiceCount(medicalCenterId));
				this.save(calcPolyclinicRating);
				return calcPolyclinicRating;
			} else{
				return null;
			}
		} else{
			return calcPolyclinicRating;
		}
	}

	@Override
	public void save(CalculatedMedicalCenterRating calculatedMedicalCenterRating) {
		calculatedMedicalCenterRatingDao.save(calculatedMedicalCenterRating);
	}

}
