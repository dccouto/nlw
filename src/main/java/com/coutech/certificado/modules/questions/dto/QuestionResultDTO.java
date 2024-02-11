package com.coutech.certificado.modules.questions.dto;

import java.util.List;
import java.util.UUID;

import com.coutech.certificado.modules.questions.entities.QuestionEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionResultDTO {
	private UUID id;
	private String technology;
	private String description;

	List<AlternativeResultDTO> alternatives;

	public static List<QuestionResultDTO> toListDto(List<QuestionEntity> entities) {
		return entities.stream()
				.map(question -> new QuestionResultDTO(question.getId(), question.getTechnology(),
						question.getDescription(), AlternativeResultDTO.toListDto(question.getAlternatives())))
				.toList();
	}

}
