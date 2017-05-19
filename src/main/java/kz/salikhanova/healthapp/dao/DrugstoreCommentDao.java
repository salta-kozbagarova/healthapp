package kz.salikhanova.healthapp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import kz.salikhanova.healthapp.model.DrugstoreComment;

public interface DrugstoreCommentDao extends JpaRepository<DrugstoreComment, Long> {
	List<DrugstoreComment> findByDrugstoreId(Long drugstoreId);
	Page<DrugstoreComment> findByDrugstoreId(Long drugstoreId, Pageable pageRequest);
	List<DrugstoreComment> findFirst10ByDrugstoreIdOrderByDateDesc(Long drugstoreId);
}
