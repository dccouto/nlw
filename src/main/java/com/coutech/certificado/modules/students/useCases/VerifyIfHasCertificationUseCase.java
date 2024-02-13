package com.coutech.certificado.modules.students.useCases;

import org.springframework.stereotype.Service;

import com.coutech.certificado.modules.students.dto.VerifyhasCertificationDTO;
import com.coutech.certificado.modules.students.repositories.CertificationStudentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VerifyIfHasCertificationUseCase {
	
	private final CertificationStudentRepository repository;
	
	public Boolean execute(VerifyhasCertificationDTO dto) {
		return !repository.findByStudentEntityEmailAndTechnology(dto.getEmail(), dto.getTechnology()).isEmpty();

	}

}
