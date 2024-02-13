package com.coutech.certificado.modules.students.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class VerifyhasCertificationDTO {
	private String email;
	private String technology;

}
