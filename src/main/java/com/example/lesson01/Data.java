package com.example.lesson01;

// 일반 자바 bean이라서 어노테이션 X
public class Data {
	
	// 필드
	private int id;
	private String name;
	
	
	// 메서드
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
