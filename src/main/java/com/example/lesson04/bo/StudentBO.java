package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	
	
	@Autowired
	private StudentRepository studentRepository;	// JPA
	
	
	// JPA 문법
	// Lesson 07 (ex 01)
	// input : 파라미터들 / output : StudentEntity
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now()) 	// 직접 입력하고 싶을 때 (UTC로 들어감), Entity에 @UpdateTimestamp가 있으면 생략 가능
				.build();
		
		return studentRepository.save(student);
		
	}
	
	
	
	// Lesson 07 (ex 02)
	// input : id, dreamJob / output : 변경된 StudentEntity
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		if (student != null) {
			
			// 기존 값은 유지하고 세팅된 일부의 값(dreamJob)만 변경 => toBuilder
			student = student.toBuilder()	// 기존 값 유지
					.dreamJob(dreamJob)
					.build();
			
			// update
			studentRepository.save(student);	// db update 후 다시 셀렉트 된 결과
			
		}
		
		return student;		// null 또는 변경된 데이터가 보여짐
		
	}
	
	
	
	// Lesson 07 (ex 03)
	// input : id / output : X (void)
	public void deleteStudentById(int id) {
		
		// 방법 1
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		
//		if (student != null) {
//			
//			studentRepository.delete(student);
//		}
		
		
		// 방법 2
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);	// util로 임포트
		
		studentOptional.ifPresent(s -> studentRepository.delete(s)); 	// ifPresent : 이 객체가 null이 아니면 여기서 수행하겠다
								// s는 student의 s
		
	}
	
	
}
