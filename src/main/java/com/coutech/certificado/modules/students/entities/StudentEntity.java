package com.coutech.certificado.modules.students.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_STUDENT")
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "PK_STUDENT")
	private UUID id;
	
	@Column(name = "DS_EMAIL")
	private String email;
	
	@OneToMany(mappedBy = "studentEntity")
	private List<CertificationStudentEntity> certifications;
}
