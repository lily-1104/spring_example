package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson04.domain.User;

@Repository
public interface UserMapper {
	
	
	// 회원가입
	public void insertUser(
			@Param("name") String name, 
			@Param("yyyymmdd") String yyyymmdd, 
			@Param("introduce") String introduce, 
			@Param("email") String email);
	
	
	
	// 최신 가입자 한명 가져오는 페이지
	public User selectLatestUser();
	
	
	
	// lesson 06 - 이름 중복 확인 (DB 조회)
	public boolean existUserByName(String name);
	
	

}
