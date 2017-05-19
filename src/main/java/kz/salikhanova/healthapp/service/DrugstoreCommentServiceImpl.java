package kz.salikhanova.healthapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kz.salikhanova.healthapp.dao.DrugstoreCommentDao;
import kz.salikhanova.healthapp.model.DrugstoreComment;

@Service("drugstoreCommentService")
public class DrugstoreCommentServiceImpl implements DrugstoreCommentService {

	@Autowired
	private DrugstoreCommentDao drugstoreCommentDao;
	
	@Override
	public void save(DrugstoreComment drugstoreComment) {
		drugstoreCommentDao.save(drugstoreComment);
	}

	@Override
	public List<DrugstoreComment> findByDrugstoreId(Long drugstoreId) {
		return drugstoreCommentDao.findByDrugstoreId(drugstoreId);
	}

	@Override
	public Page<DrugstoreComment> findByDrugstoreId(Long drugstoreId, Pageable pageRequest) {
		return drugstoreCommentDao.findByDrugstoreId(drugstoreId, pageRequest);
	}

	@Override
	public List<DrugstoreComment> findFirst10ByDrugstoreIdOrderByDateDesc(Long drugstoreId) {
		return drugstoreCommentDao.findFirst10ByDrugstoreIdOrderByDateDesc(drugstoreId);
	}

}
