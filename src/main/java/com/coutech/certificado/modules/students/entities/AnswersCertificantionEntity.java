package com.coutech.certificado.modules.students.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_ANSWER")
public class AnswersCertificantionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "PK_ANSWER")
	private UUID id;
	
	@Column(name  = "certification_Id")
	private UUID certificationId;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name  = "certification_Id", insertable = false, updatable = false)
	private CertificationStudentEntity certificationStudentEntity;
	
	
	@Column(name  = "student_Id")
	private UUID studentId;
	
	@ManyToOne
	@JoinColumn(name  = "student_Id", insertable = false, updatable = false)
	private StudentEntity studentEntity;
	
	@Column(name  = "question_Id")
	private UUID questionId;
	
	@Column(name  = "answer_Id")
	private UUID answerId;
	
	@Column(name = "is_correct")
	private Boolean isCorrect;
	
	@CreationTimestamp
	private LocalDateTime createdAt;

}
