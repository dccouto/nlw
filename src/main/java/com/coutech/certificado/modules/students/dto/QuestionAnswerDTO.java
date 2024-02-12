package com.coutech.certificado.modules.students.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class QuestionAnswerDTO {
	
	private UUID questionId;
	private UUID alternativeId;
	private Boolean isCorrect;


}
