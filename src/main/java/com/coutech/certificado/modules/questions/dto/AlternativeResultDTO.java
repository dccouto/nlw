package com.coutech.certificado.modules.questions.dto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.coutech.certificado.modules.questions.entities.AlternativeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlternativeResultDTO {
	private UUID id;
	private String description;

	public static List<AlternativeResultDTO> toListDto(List<AlternativeEntity> entities) {
		return entities.stream()
				.map(alternative -> new AlternativeResultDTO(alternative.getId(), alternative.getDescription()))
				.collect(Collectors.toList());
	}

}
