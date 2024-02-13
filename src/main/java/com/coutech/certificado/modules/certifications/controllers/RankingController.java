package com.coutech.certificado.modules.certifications.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coutech.certificado.modules.certifications.useCases.TopRankingUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("ranking")
public class RankingController {
	
	private final TopRankingUseCase rankingUseCase;
	
	@GetMapping("/{top}")
	public ResponseEntity<?> rankingTop(@PathVariable String top){
		return ResponseEntity.ok(rankingUseCase.execute(top));
		
	}

}
