package kz.salikhanova.healthapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kz.salikhanova.healthapp.dao.HospitalCommentDao;
import kz.salikhanova.healthapp.dao.PolyclinicCommentDao;
import kz.salikhanova.healthapp.model.PolyclinicComment;

@Service("polyclinicCommentService")
public class PolyclinicCommentServiceImpl implements PolyclinicCommentService {

	@Autowired
	private PolyclinicCommentDao polyclinicCommentDao;
	
	@Override
	public void save(PolyclinicComment polyclinicComment) {
		polyclinicCommentDao.save(polyclinicComment);
	}

	@Override
	public List<PolyclinicComment> findByPolyclinicId(Long polyclinicId) {
		return polyclinicCommentDao.findByPolyclinicId(polyclinicId);
	}

	@Override
	public Page<PolyclinicComment> findByPolyclinicId(Long polyclinicId, Pageable pageRequest) {
		return polyclinicCommentDao.findByPolyclinicId(polyclinicId, pageRequest);
	}

	@Override
	public List<PolyclinicComment> findFirst10ByPolyclinicIdOrderByDateDesc(Long polyclinicId) {
		return polyclinicCommentDao.findFirst10ByPolyclinicIdOrderByDateDesc(polyclinicId);
	}

}
