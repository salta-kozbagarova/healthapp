package kz.salikhanova.healthapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.salikhanova.healthapp.dao.PolyclinicRatingDao;
import kz.salikhanova.healthapp.model.PolyclinicRating;

@Service("polyclinicRatingService")
public class PolyclinicRatingServiceImpl implements PolyclinicRatingService {

	@Autowired
	private PolyclinicRatingDao polyclinicRatingDao;
	
	@Override
	public PolyclinicRating findOne(Long id) {
		return polyclinicRatingDao.findOne(id);
	}

	@Override
	public void save(PolyclinicRating polyclinicRating) {
		polyclinicRatingDao.save(polyclinicRating);
	}

	@Override
	public Short calculatePriceAvg(Long polyclinicId) {
		Long sum = polyclinicRatingDao.getPriceSum(polyclinicId);
		Long count = polyclinicRatingDao.getPriceCount(polyclinicId);
		if(sum==null || count==null){
			return null;
		} else{
			return (short) (sum/count);
		}
	}

	@Override
	public Short calculateServiceAvg(Long polyclinicId) {
		Long sum = polyclinicRatingDao.getServiceSum(polyclinicId);
		Long count = polyclinicRatingDao.getServiceCount(polyclinicId);
		if(sum==null || count==null){
			return null;
		} else{
			return (short) (sum/count);
		}
	}

	@Override
	public Long calculatePriceCount(Long polyclinicId) {
		return polyclinicRatingDao.getPriceCount(polyclinicId);
	}

	@Override
	public Long calculateServiceCount(Long polyclinicId) {
		return polyclinicRatingDao.getServiceCount(polyclinicId);
	}

	@Override
	public PolyclinicRating findByUserForPolyclinic(Long userId, Long polyclinicId) {
		return polyclinicRatingDao.findByUserIdAndPolyclinicId(userId, polyclinicId);
	}

}
