package kz.salikhanova.healthapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.salikhanova.healthapp.dao.RatingDao;
import kz.salikhanova.healthapp.model.Rating;

@Service("ratingService")
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingDao ratingDao;
	
	@Override
	public Rating findOne(Long id) {
		return ratingDao.findOne(id);
	}

}
