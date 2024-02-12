package com.coutech.certificado.modules.students.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentCertificationAnswersDTO {
	
	private String email;
	private String technology;
	private List<QuestionAnswerDTO> questions;

}
