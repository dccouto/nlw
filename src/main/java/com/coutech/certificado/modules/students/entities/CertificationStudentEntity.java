package com.coutech.certificado.modules.students.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_CERTIFICATION")
public class CertificationStudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "PK_CERTIFICATION")
	private UUID id;
	
	@Column(name = "DS_TECHNOLOGY")
	private String technology;
	
	@Column(name = "DS_GRADE")
	private int grade;
	
		
	@ManyToOne
	@JoinColumn(name  = "FK_STUDENT", insertable = false, updatable = false)
	private StudentEntity studentEntity;
	
	@OneToMany
	@JoinColumn(name = "answer_certification_id")
	List<AnswersCertificantionEntity> answersCertifications;
}
