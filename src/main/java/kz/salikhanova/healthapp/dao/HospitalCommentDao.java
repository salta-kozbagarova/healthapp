package kz.salikhanova.healthapp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import kz.salikhanova.healthapp.model.HospitalComment;

public interface HospitalCommentDao extends JpaRepository<HospitalComment, Long> {
	List<HospitalComment> findByHospitalId(Long hospitalId);
	Page<HospitalComment> findByHospitalId(Long hospitalId, Pageable pageRequest);
	List<HospitalComment> findFirst10ByHospitalIdOrderByDateDesc(Long hospitalId);
}
