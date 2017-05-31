package kz.salikhanova.healthapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kz.salikhanova.healthapp.dao.MedicalCenterCommentDao;
import kz.salikhanova.healthapp.model.MedicalCenterComment;

@Service("medicalCenterCommentService")
public class MedicalCenterCommentServiceImpl implements MedicalCenterCommentService {

	@Autowired
	private MedicalCenterCommentDao medicalCenterCommentDao;
	
	@Override
	public void save(MedicalCenterComment medicalCenterComment) {
		medicalCenterCommentDao.save(medicalCenterComment);
	}

	@Override
	public List<MedicalCenterComment> findByMedicalCenterId(Long medicalCenterId) {
		return medicalCenterCommentDao.findByMedicalCenterId(medicalCenterId);
	}

	@Override
	public Page<MedicalCenterComment> findByMedicalCenterId(Long medicalCenterId, Pageable pageRequest) {
		return medicalCenterCommentDao.findByMedicalCenterId(medicalCenterId, pageRequest);
	}

	@Override
	public List<MedicalCenterComment> findFirst10ByMedicalCenterIdOrderByDateDesc(Long medicalCenterId) {
		return medicalCenterCommentDao.findFirst10ByMedicalCenterIdOrderByDateDesc(medicalCenterId);
	}

}
