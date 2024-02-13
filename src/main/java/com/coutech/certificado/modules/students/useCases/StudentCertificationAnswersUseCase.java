package com.coutech.certificado.modules.students.useCases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.coutech.certificado.modules.questions.repositories.QuestionRepository;
import com.coutech.certificado.modules.students.dto.StudentCertificationAnswersDTO;
import com.coutech.certificado.modules.students.dto.VerifyhasCertificationDTO;
import com.coutech.certificado.modules.students.entities.AnswersCertificantionEntity;
import com.coutech.certificado.modules.students.entities.CertificationStudentEntity;
import com.coutech.certificado.modules.students.entities.StudentEntity;
import com.coutech.certificado.modules.students.repositories.CertificationStudentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentCertificationAnswersUseCase {

	private final QuestionRepository questionRepository;
	private final CertificationStudentRepository certificationStudentRepository;

	private final SaveEstudentIfNotExistUseCase saveEstudentIfNotExistUseCase;
	private final VerifyIfHasCertificationUseCase hasCertificationUseCase;

	public CertificationStudentEntity execute(StudentCertificationAnswersDTO dto) {

		if (hasCertificationUseCase.execute(
				VerifyhasCertificationDTO.builder().email(dto.getEmail()).technology(dto.getTechnology()).build())) {
			throw new RuntimeException("Certificação já obtida");
		}

		var studentEntity = saveEstudentIfNotExistUseCase
				.execute(StudentEntity.builder().email(dto.getEmail()).build());

		var questions = questionRepository.findByTechnology(dto.getTechnology());

		List<AnswersCertificantionEntity> answers = new ArrayList<>();

		AtomicInteger correctAnswers = new AtomicInteger(0);

		dto.getQuestions().stream().forEach(qa -> {

			var questionFilter = questions.stream().filter(question -> question.getId().equals(qa.getQuestionId()))
					.findFirst().get();

			var alternativeCorrect = questionFilter.getAlternatives().stream()
					.filter(alternative -> alternative.getIsCorrect()).findFirst().get();

			if (alternativeCorrect.getId().equals(qa.getAlternativeId())) {
				qa.setIsCorrect(Boolean.TRUE);
				correctAnswers.incrementAndGet();
			} else {
				qa.setIsCorrect(Boolean.FALSE);
			}

			answers.add(AnswersCertificantionEntity.builder().answerId(qa.getQuestionId())
					.questionId(qa.getQuestionId()).isCorrect(qa.getIsCorrect()).build());

		});
		CertificationStudentEntity certificationStudentEntity = CertificationStudentEntity.builder()
				.studentEntity(studentEntity).grade(correctAnswers.get()).technology(dto.getTechnology()).build();

		certificationStudentRepository.save(certificationStudentEntity);

		answers.stream().forEach(aw -> {
			aw.setCertificationId(certificationStudentEntity.getId());
			aw.setCertificationStudentEntity(certificationStudentEntity);
		});
		certificationStudentEntity.setAnswersCertifications(answers);
		return certificationStudentRepository.save(certificationStudentEntity);

	}

}
