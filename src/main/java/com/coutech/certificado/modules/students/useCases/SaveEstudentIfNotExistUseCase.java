package com.coutech.certificado.modules.students.useCases;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coutech.certificado.modules.students.entities.StudentEntity;
import com.coutech.certificado.modules.students.repositories.StudentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SaveEstudentIfNotExistUseCase {

	private final StudentRepository repository;

	public StudentEntity execute(StudentEntity entity) {
		Optional<StudentEntity> student = repository.findByEmail(entity.getEmail());
		if(student.isEmpty()) {
			return save(entity);
		}
		return student.get();

	}
	
	private StudentEntity save(StudentEntity entity) {
		return repository.save(entity);
	}

}
