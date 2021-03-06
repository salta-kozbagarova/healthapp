package kz.salikhanova.healthapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kz.salikhanova.healthapp.dao.HospitalCommentDao;
import kz.salikhanova.healthapp.model.HospitalComment;

@Service("hospitalCommentService")
public class HospitalCommentServiceImpl implements HospitalCommentService {

	@Autowired
	private HospitalCommentDao hospitalCommentDao;
	
	@Override
	public void save(HospitalComment hospitalComment) {
		hospitalCommentDao.save(hospitalComment);
	}

	@Override
	public List<HospitalComment> findByHospitalId(Long hospitalId) {
		return hospitalCommentDao.findByHospitalId(hospitalId);
	}

	@Override
	public Page<HospitalComment> findByHospitalId(Long hospitalId, Pageable pageRequest) {
		return hospitalCommentDao.findByHospitalId(hospitalId, pageRequest);
	}

	@Override
	public List<HospitalComment> findFirst10ByHospitalIdOrderByDateDesc(Long hospitalId) {
		return hospitalCommentDao.findFirst10ByHospitalIdOrderByDateDesc(hospitalId);
	}

}
