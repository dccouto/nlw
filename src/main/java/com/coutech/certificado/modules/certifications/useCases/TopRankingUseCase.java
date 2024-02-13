package com.coutech.certificado.modules.certifications.useCases;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coutech.certificado.modules.students.entities.CertificationStudentEntity;
import com.coutech.certificado.modules.students.repositories.CertificationStudentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TopRankingUseCase {
	
	private final CertificationStudentRepository repository;
	
	public List<CertificationStudentEntity> execute(String top) {
		return repository.findTopByOrderGradeDesc(top);
	}

}
