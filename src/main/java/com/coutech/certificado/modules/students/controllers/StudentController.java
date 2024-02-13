package com.coutech.certificado.modules.students.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coutech.certificado.modules.students.dto.StudentCertificationAnswersDTO;
import com.coutech.certificado.modules.students.dto.VerifyhasCertificationDTO;
import com.coutech.certificado.modules.students.useCases.StudentCertificationAnswersUseCase;
import com.coutech.certificado.modules.students.useCases.VerifyIfHasCertificationUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
	
	private final VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;
	private final StudentCertificationAnswersUseCase studentCertificationAnswersUseCase;
	
	@PostMapping
	public ResponseEntity<?> verifyIfHasCertification(@RequestBody VerifyhasCertificationDTO verifyhasCertificationDTO) {
		
		
		return ResponseEntity.ok(verifyIfHasCertificationUseCase.execute(verifyhasCertificationDTO));
	}
	
	@PostMapping("/cetification/answer")
	public ResponseEntity<?> certificationAnswer(@RequestBody StudentCertificationAnswersDTO dto) {
		try {
			return ResponseEntity.ok(studentCertificationAnswersUseCase.execute(dto));
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		
	}

}
