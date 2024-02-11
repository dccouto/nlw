package com.coutech.certificado.modules.students.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VerifyhasCertificationDTO {
	private String email;
	private String technology;

}
