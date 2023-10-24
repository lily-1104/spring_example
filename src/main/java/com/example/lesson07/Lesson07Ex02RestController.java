package com.example.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@RequestMapping("/lesson07/ex02")
@RestController
public class Lesson07Ex02RestController {
	
	
	// 이번에만 BO 생략
	@Autowired
	private StudentRepository studentRepository;
	
	
	// ex 02-1
	// 조회하는 다양한 방법
	// URL : http://localhost/lesson07/ex02/1
	@GetMapping("/1")
	public List<StudentEntity> getStudentList() {
		
		// 1) 쿼리 전체 조회 (기본으로 제공되는 메소드, Data JPA에 들어있음)
//		return studentRepository.findAll();
		
		// 2) id 기준 내림차순 전체 조회
//		return studentRepository.findAllByOrderByIdDesc();
		
		// 3) id 기준 내림차순 3개만 조회
//		return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4) 이름이 유재석인 데이터 조회
//		return studentRepository.findByName("유재석");
		
		// 5) in 문으로 일치하는 값 모두 조회
//		return studentRepository.findByNameIn(List.of("유재석", "신보람", "김유리"));
		
		// 6) 여러 컬럼 값과 일치하는 데이터 조회 => 이름과 dreamJob 모두 일치해야함
//		return studentRepository.findByNameAndDreamJob("유재석", "프로그래머");
		
		// 7) email 컬럼에 naver 키워드가 포함된 데이터 조회 (like 문) - %naver%
//		return studentRepository.findByEmailContaining("naver");		// contains or containing 둘 다 사용 가능
		
		// 8) 이름이 '유'로 시작하는 데이터 조회 (like) - 유%
//		return studentRepository.findByNameStartingWith("유");
		
		// 9) id가 1~5인 데이터 조회 (between)
		return studentRepository.findByIdBetween(1, 5);
		
	}
		
		
	
	// ex 02-2
	// URL : http://localhost/lesson07/ex02/2
	@GetMapping("/2")
	public List<StudentEntity> getStudentList2() {
			
		// 1) 장래희망이 개발자인 데이터 조회
		return studentRepository.findByDreamJob("개발자");
		
	}
	
	
}
