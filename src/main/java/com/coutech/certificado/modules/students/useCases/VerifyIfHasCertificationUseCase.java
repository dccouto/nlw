package com.coutech.certificado.modules.students.useCases;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coutech.certificado.modules.students.dto.VerifyhasCertificationDTO;
import com.coutech.certificado.modules.students.entities.CertificationStudentEntity;
import com.coutech.certificado.modules.students.repositories.CertificationStudentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VerifyIfHasCertificationUseCase {
	
	private final CertificationStudentRepository repository;
	
	public Boolean execute(VerifyhasCertificationDTO dto) {
		List<CertificationStudentEntity> findByStudentEntityEmailAndTechnology = repository.findByStudentEntityEmailAndTechnology(dto.getEmail(), dto.getTechnology());
		return !repository.findByStudentEntityEmailAndTechnology(dto.getEmail(), dto.getTechnology()).isEmpty();

	}

}
