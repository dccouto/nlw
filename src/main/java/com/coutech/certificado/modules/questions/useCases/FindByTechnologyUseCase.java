package com.coutech.certificado.modules.questions.useCases;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coutech.certificado.modules.questions.entities.QuestionEntity;
import com.coutech.certificado.modules.questions.repositories.QuestionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindByTechnologyUseCase {

	private final QuestionRepository repository;

	public List<QuestionEntity> execute(String technology) {
		return repository.findByTechnology(technology);
	}

}
