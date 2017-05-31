package kz.salikhanova.healthapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.salikhanova.healthapp.dao.HospitalRatingDao;
import kz.salikhanova.healthapp.dao.MedicalCenterRatingDao;
import kz.salikhanova.healthapp.model.MedicalCenterRating;

@Service("medicalCenterRatingService")
public class MedicalCenterRatingServiceImpl implements MedicalCenterRatingService {

	@Autowired
	private MedicalCenterRatingDao medicalCenterRatingDao;
	
	@Override
	public MedicalCenterRating findOne(Long id) {
		return medicalCenterRatingDao.findOne(id);
	}

	@Override
	public void save(MedicalCenterRating medicalCenterRating) {
		medicalCenterRatingDao.save(medicalCenterRating);
	}

	@Override
	public Short calculatePriceAvg(Long medicalCenterId) {
		Long sum = medicalCenterRatingDao.getPriceSum(medicalCenterId);
		Long count = medicalCenterRatingDao.getPriceCount(medicalCenterId);
		if(sum==null || count==null){
			return null;
		} else{
			return (short) (sum/count);
		}
	}

	@Override
	public Short calculateServiceAvg(Long medicalCenterId) {
		Long sum = medicalCenterRatingDao.getServiceSum(medicalCenterId);
		Long count = medicalCenterRatingDao.getServiceCount(medicalCenterId);
		if(sum==null || count==null){
			return null;
		} else{
			return (short) (sum/count);
		}
	}

	@Override
	public Long calculatePriceCount(Long medicalCenterId) {
		return medicalCenterRatingDao.getPriceCount(medicalCenterId);
	}

	@Override
	public Long calculateServiceCount(Long medicalCenterId) {
		return medicalCenterRatingDao.getServiceCount(medicalCenterId);
	}

	@Override
	public MedicalCenterRating findByUserForMedicalCenter(Long userId, Long medicalCenterId) {
		return medicalCenterRatingDao.findByUserIdAndMedicalCenterId(userId, medicalCenterId);
	}

}
