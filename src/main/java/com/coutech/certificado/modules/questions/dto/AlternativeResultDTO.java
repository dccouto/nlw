package com.coutech.certificado.modules.questions.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlternativeResultDTO {
	private UUID id;
	private String description;

}
