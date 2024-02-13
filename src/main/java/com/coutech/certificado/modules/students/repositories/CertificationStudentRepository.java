package com.coutech.certificado.modules.students.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coutech.certificado.modules.students.entities.CertificationStudentEntity;

public interface CertificationStudentRepository extends JpaRepository<CertificationStudentEntity, UUID> {

	List<CertificationStudentEntity> findByStudentEntityEmailAndTechnology(String email, String technology);
	
	@Query("SELECT c FROM TB_CERTIFICATION c ORDER BY c.grade DESC LIMIT :top")
	List<CertificationStudentEntity> findTopByOrderGradeDesc(String top);

}
