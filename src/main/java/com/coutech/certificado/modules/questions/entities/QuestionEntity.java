package com.coutech.certificado.modules.questions.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_QUESTION")
public class QuestionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "PK_QUESTION")
	private UUID id;
	
	@Column(name = "DS_TECHNOLOGY")
	private String technology;
	
	@Column(name = "DS_DESCRIPTION")
	private String description;
	
	@OneToMany
	@JoinColumn(name = "QUESTION_ID")
	private List<AlternativeEntity> alternatives;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	

}
