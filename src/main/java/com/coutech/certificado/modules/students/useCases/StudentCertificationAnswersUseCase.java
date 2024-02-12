package com.coutech.certificado.modules.students.useCases;

import org.springframework.stereotype.Service;

import com.coutech.certificado.modules.questions.repositories.QuestionRepository;
import com.coutech.certificado.modules.students.dto.StudentCertificationAnswersDTO;
import com.coutech.certificado.modules.students.repositories.StudentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentCertificationAnswersUseCase {

	private final StudentRepository repository;
	private final QuestionRepository questionRepository;

	public StudentCertificationAnswersDTO execute(StudentCertificationAnswersDTO dto) {
//		if (!repository.existsByEmail(dto.getEmail())) {
//			throw new IllegalArgumentException();
//		}

		var questions = questionRepository.findByTechnology(dto.getTechnology());

		dto.getQuestions().stream().forEach(qa -> {

			var questionFilter = questions.stream().filter(question -> question.getId().equals(qa.getQuestionId()))
					.findFirst().get();

			var alternativeCorrect = questionFilter.getAlternatives().stream()
					.filter(alternative -> alternative.getIsCorrect()).findFirst().get();

			if (alternativeCorrect.getId().equals(qa.getAlternativeId())) {
				qa.setIsCorrect(Boolean.TRUE);
			} else {
				qa.setIsCorrect(Boolean.FALSE);
			}

		});
		return dto;
	}

}
