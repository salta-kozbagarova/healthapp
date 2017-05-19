package kz.salikhanova.healthapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kz.salikhanova.healthapp.model.DrugstoreComment;

public interface DrugstoreCommentService {

	void save(DrugstoreComment drugstoreComment);
	List<DrugstoreComment> findByDrugstoreId(Long drugstoreId);
	Page<DrugstoreComment> findByDrugstoreId(Long drugstoreId, Pageable pageRequest);
	List<DrugstoreComment> findFirst10ByDrugstoreIdOrderByDateDesc(Long drugstoreId);
}
