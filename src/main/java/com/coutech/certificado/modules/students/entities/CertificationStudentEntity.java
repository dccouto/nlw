package com.coutech.certificado.modules.students.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
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
	
	@Column(name = "DS_GRADE", length = 10)
	private int grade;
	
		
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name  = "FK_STUDENT")
	@JsonManagedReference
	private StudentEntity studentEntity;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "answer_certification_id")
	@JsonManagedReference
	List<AnswersCertificantionEntity> answersCertifications;
}
