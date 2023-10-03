package com.example.lesson02.domain;

import java.util.Date;

// 이 클래스는 DTO, model, domain 이런 이름 전부 사용 가능
public class UsedGoods {
	
	// 필드
	private int id;		// MYSQL에서 이 값이 NULL이면 int가 아닌 Integer로 써야함
	private int sellerId;
	private String title;
	private int price;
	private String description;
	private String picture;
	private Date createdAt;
	private Date updatedAt;		// java.util.Date로 임포트 
	
	
	// 메소드
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


}
