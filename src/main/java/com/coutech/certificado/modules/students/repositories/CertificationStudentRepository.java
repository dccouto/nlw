package com.coutech.certificado.modules.students.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coutech.certificado.modules.students.entities.CertificationStudentEntity;

public interface CertificationStudentRepository extends JpaRepository<CertificationStudentEntity, UUID> {

	List<CertificationStudentEntity> findByStudentEntityEmailAndTechnology(String email, String technology);

}
