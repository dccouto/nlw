package com.coutech.certificado.modules.questions.dto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.coutech.certificado.modules.questions.entities.AlternativeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AlternativeResultDTO {
	private UUID id;
	private String description;

	public static List<AlternativeResultDTO> toListDto(List<AlternativeEntity> entities) {
		return entities.stream().map(alternative -> AlternativeResultDTO.builder().id(alternative.getId())
				.description(alternative.getDescription()).build()).collect(Collectors.toList());
	}

}
