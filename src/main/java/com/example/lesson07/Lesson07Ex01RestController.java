package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	
	@Autowired
	private StudentBO studentBO;	// mybatis => lesson 04에 있음
	
	
	// C U D
	
	// 1
	// C : Create => insert 문
	// URL : http://localhost/lesson07/ex01/1
	@GetMapping("/1")
	public StudentEntity create() {
		
		String name = "신보람";
		String phoneNumber = "010-1111-1111";
		String email = "eee@kakao.com";
		String dreamjob = "개발자";
		
		// 지금 들어간 id 값도 바로 꺼낼 수 있음 => getId();
		return studentBO.addStudent(name, phoneNumber, email, dreamjob);
		
	}
	
	
	
	// 2
	// U : Update
	// URL : http://localhost/lesson07/ex01/2
	@GetMapping("/2")
	public StudentEntity update() {
		
		// id가 3번인 데이터의 dreamJob을 변경 (개발자 -> 디자이너)
		return studentBO.updateStudentDreamJobById(3, "디자이너");	
		
	}
	
	
	
	// 3 
	// D : Delete
	// URL : http://localhost/lesson07/ex01/3
	@GetMapping("/3")
	public String delete() {
		
		// id : 2
		studentBO.deleteStudentById(2);
		
		return "삭제 완료";
		
	}
	
	
}
