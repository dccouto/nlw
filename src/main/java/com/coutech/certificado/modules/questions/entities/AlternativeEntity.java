package com.coutech.certificado.modules.questions.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_ALTERNATIVE")
public class AlternativeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "PK_ALTERNATIVE")
	private UUID id;
	
	@Column(name = "DS_DESCRIPTION")
	private String description;
	
	@Column(name = "is_correct")
	private Boolean isCorrect;
	
	@CreationTimestamp
	private LocalDateTime createdAt;

}
