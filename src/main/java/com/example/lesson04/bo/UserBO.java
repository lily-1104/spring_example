package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.User;
import com.example.lesson04.mapper.UserMapper;

@Service
public class UserBO {
	
	
	@Autowired
	private UserMapper userMapper;
	
	
	// 회원가입
	// input : 컬럼들 4개 / output : X
	public void addUser(String name, String yyyymmdd, String introduce, String email) {		// 아무것도 리턴하지 않아서 void 사용
		
		userMapper.insertUser(name, yyyymmdd, introduce, email);
		
	}
	
	
	
	// 최신 가입자 한명 가져오는 페이지
	// input : X / output : User (최신 가입자 1명)
	public User getLatestUser() {
		
		return userMapper.selectLatestUser();
		
	}
	
	
	
	// lesson 06 - 이름 중복 확인 (DB 조회)
	// input : name / output : boolean (중복이면 true, 아니면 false)
	public boolean existUserByName(String name) {
		
		return userMapper.existUserByName(name);
				
	}
	
	
}
