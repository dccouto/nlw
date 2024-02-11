package com.coutech.certificado.modules.questions.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coutech.certificado.modules.questions.dto.QuestionResultDTO;
import com.coutech.certificado.modules.questions.useCases.FindByTechnology;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/question")
public class QuestionController {
	
	private final FindByTechnology findByTechnology;
	
	@GetMapping("/technology/{technology}")
	public ResponseEntity<?> findByTechnology(@PathVariable String technology){
		return ResponseEntity.ok(QuestionResultDTO.toListDto(findByTechnology.execute(technology)));
		
	}

}
