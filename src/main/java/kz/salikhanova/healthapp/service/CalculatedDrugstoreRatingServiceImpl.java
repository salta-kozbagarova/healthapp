package kz.salikhanova.healthapp.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.salikhanova.healthapp.dao.CalculatedDrugstoreRatingDao;
import kz.salikhanova.healthapp.dao.DrugstoreRatingDao;
import kz.salikhanova.healthapp.model.CalculatedDrugstoreRating;
import kz.salikhanova.healthapp.model.DrugstoreRating;

@Service("calculatedDrugstoreRatingService")
public class CalculatedDrugstoreRatingServiceImpl implements CalculatedDrugstoreRatingService {

	@Autowired
	private CalculatedDrugstoreRatingDao calculatedDrugstoreRatingDao;
	
	@Resource(name = "drugstoreRatingService")
	private DrugstoreRatingService drugstoreRatingService;

	@Override
	public CalculatedDrugstoreRating findByDrugstoreId(Long drugstoreId) {
		CalculatedDrugstoreRating calcDrugstoreRating = calculatedDrugstoreRatingDao.findByDrugstoreId(drugstoreId);
		if(calcDrugstoreRating==null){
			if(drugstoreRatingService.findOne(drugstoreId)!=null){
				calcDrugstoreRating = new CalculatedDrugstoreRating();
				calcDrugstoreRating.setDrugstoreId(drugstoreId);
				calcDrugstoreRating.setPriceRating(drugstoreRatingService.calculatePriceAvg(drugstoreId));
				calcDrugstoreRating.setPriceCount(drugstoreRatingService.calculatePriceCount(drugstoreId));
				calcDrugstoreRating.setDrugsAvailabilityRating(drugstoreRatingService.calculateDrugsAvailabilityAvg(drugstoreId));
				calcDrugstoreRating.setDrugsAvailabilityCount(drugstoreRatingService.calculateDrugsAvailabilityCount(drugstoreId));
				this.save(calcDrugstoreRating);
				return calcDrugstoreRating;
			} else{
				return null;
			}
		} else{
			return calcDrugstoreRating;
		}
	}

	@Override
	public void save(CalculatedDrugstoreRating calculatedDrugstoreRating) {
		calculatedDrugstoreRatingDao.save(calculatedDrugstoreRating);
	}
}
