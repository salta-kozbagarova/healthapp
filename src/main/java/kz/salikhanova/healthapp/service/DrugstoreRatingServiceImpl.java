package kz.salikhanova.healthapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.salikhanova.healthapp.dao.DrugstoreRatingDao;
import kz.salikhanova.healthapp.model.DrugstoreRating;

@Service("drugstoreRatingService")
public class DrugstoreRatingServiceImpl implements DrugstoreRatingService {

	@Autowired
	private DrugstoreRatingDao drugstoreRatingDao;
	
	@Override
	public DrugstoreRating findOne(Long id) {
		return drugstoreRatingDao.findOne(id);
	}

	@Override
	public void save(DrugstoreRating drugstoreRating) {
		drugstoreRatingDao.save(drugstoreRating);
	}

	@Override
	public Short calculatePriceAvg(Long drugstoreId) {
		Long sum = drugstoreRatingDao.getPriceSum(drugstoreId);
		Long count = drugstoreRatingDao.getPriceCount(drugstoreId);
		if(sum==null || count==null){
			return null;
		} else{
			return (short) (sum/count);
		}
	}

	@Override
	public Short calculateDrugsAvailabilityAvg(Long drugstoreId) {
		Long sum = drugstoreRatingDao.getDrugsAvailabilitySum(drugstoreId);
		Long count = drugstoreRatingDao.getDrugsAvailabilityCount(drugstoreId);
		if(sum==null || count==null){
			return null;
		} else{
			return (short) (sum/count);
		}
	}

	@Override
	public Long calculatePriceCount(Long drugstoreId) {
		return drugstoreRatingDao.getPriceCount(drugstoreId);
	}

	@Override
	public Long calculateDrugsAvailabilityCount(Long drugstoreId) {
		return drugstoreRatingDao.getDrugsAvailabilityCount(drugstoreId);
	}

	@Override
	public DrugstoreRating findByUserForDrugstore(Long userId, Long drugstoreId) {
		return drugstoreRatingDao.findByUserIdAndDrugstoreId(userId, drugstoreId);
	}

}
