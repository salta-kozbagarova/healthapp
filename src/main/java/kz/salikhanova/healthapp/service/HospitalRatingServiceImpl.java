package kz.salikhanova.healthapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.salikhanova.healthapp.dao.HospitalRatingDao;
import kz.salikhanova.healthapp.model.HospitalRating;

@Service("hospitalRatingService")
public class HospitalRatingServiceImpl implements HospitalRatingService {

	@Autowired
	private HospitalRatingDao hospitalRatingDao;
	
	@Override
	public HospitalRating findOne(Long id) {
		return hospitalRatingDao.findOne(id);
	}

	@Override
	public void save(HospitalRating hospitalRating) {
		hospitalRatingDao.save(hospitalRating);
	}

	@Override
	public Short calculatePriceAvg(Long hospitalId) {
		Long sum = hospitalRatingDao.getPriceSum(hospitalId);
		Long count = hospitalRatingDao.getPriceCount(hospitalId);
		if(sum==null || count==null){
			return null;
		} else{
			return (short) (sum/count);
		}
	}

	@Override
	public Short calculateServiceAvg(Long hospitalId) {
		Long sum = hospitalRatingDao.getServiceSum(hospitalId);
		Long count = hospitalRatingDao.getServiceCount(hospitalId);
		if(sum==null || count==null){
			return null;
		} else{
			return (short) (sum/count);
		}
	}

	@Override
	public Long calculatePriceCount(Long hospitalId) {
		return hospitalRatingDao.getPriceCount(hospitalId);
	}

	@Override
	public Long calculateServiceCount(Long hospitalId) {
		return hospitalRatingDao.getServiceCount(hospitalId);
	}

	@Override
	public HospitalRating findByUserForHospital(Long userId, Long hospitalId) {
		return hospitalRatingDao.findByUserIdAndHospitalId(userId, hospitalId);
	}

}
