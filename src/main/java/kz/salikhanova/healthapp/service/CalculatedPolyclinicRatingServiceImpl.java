package kz.salikhanova.healthapp.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.salikhanova.healthapp.dao.CalculatedPolyclinicRatingDao;
import kz.salikhanova.healthapp.model.CalculatedPolyclinicRating;

@Service("calculatedPolyclinicRatingService")
public class CalculatedPolyclinicRatingServiceImpl implements CalculatedPolyclinicRatingService {

	@Autowired
	private CalculatedPolyclinicRatingDao calculatedPolyclinicRatingDao;
	
	@Resource(name = "polyclinicRatingService")
	private PolyclinicRatingService polyclinicRatingService;

	@Override
	public CalculatedPolyclinicRating findByPolyclinicId(Long polycliniclId) {
		CalculatedPolyclinicRating calcPolyclinicRating = calculatedPolyclinicRatingDao.findByPolyclinicId(polycliniclId);
		if(calcPolyclinicRating==null){
			if(polyclinicRatingService.findOne(polycliniclId)!=null){
				calcPolyclinicRating = new CalculatedPolyclinicRating();
				calcPolyclinicRating.setPolyclinicId(polycliniclId);
				calcPolyclinicRating.setPriceRating(polyclinicRatingService.calculatePriceAvg(polycliniclId));
				calcPolyclinicRating.setPriceCount(polyclinicRatingService.calculatePriceCount(polycliniclId));
				calcPolyclinicRating.setServiceRating(polyclinicRatingService.calculateServiceAvg(polycliniclId));
				calcPolyclinicRating.setServiceCount(polyclinicRatingService.calculateServiceCount(polycliniclId));
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
	public void save(CalculatedPolyclinicRating calculatedPolyclinicRating) {
		calculatedPolyclinicRatingDao.save(calculatedPolyclinicRating);
	}
}
