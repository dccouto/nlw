package com.coutech.certificado.modules.questions.dto;

import java.util.List;
import java.util.UUID;

import com.coutech.certificado.modules.questions.entities.QuestionEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class QuestionResultDTO {
	private UUID id;
	private String technology;
	private String description;

	List<AlternativeResultDTO> alternatives;

	public static List<QuestionResultDTO> toListDto(List<QuestionEntity> entities) {
		return entities.stream()
				.map(question -> QuestionResultDTO.builder().id(question.getId()).technology(question.getTechnology())
						.description(question.getDescription())
						.alternatives(AlternativeResultDTO.toListDto(question.getAlternatives())).build())
				.toList();
	}

}
