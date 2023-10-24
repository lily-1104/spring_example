package com.example.lesson07.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString	// 객체를 출력할 때 모든 내용이 보여짐
@AllArgsConstructor	// 파라미터가 모두 있는 생성자 => @Builder에 에러가 없어짐
@NoArgsConstructor	// 파라미터 없는 기본 생성자
@Getter
@Builder(toBuilder = true)	// @Builder : setter의 대용 / toBuilder = true : true이면 수정 허용 (업데이트)
@Entity(name="new_student")		// 이 객체는 Entity다 (JPA-DB 통신 사이에 있음)
@Table(name="new_student")
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber")	// CamelCase 있는 곳에 추가
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp	// 시간을 넣지 않아도 현재 시간으로 자동으로 들어감
	@Column(name = "createdAt", updatable = false)	// updatable = false : update 할 때 createdAt은 변경 안되고 updatedAt만 변경 (업데이트시 변경 X)
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
	
}
