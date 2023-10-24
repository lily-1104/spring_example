package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	
	
	// Spring JPA DATA : JpaRepository
	
	// 1-2
	// save()  - id가 없으면 insert, id가 있으면 update
	// findById() - select를 하는 메소드
	
	
	// delete(객체) - delete
	
	
	// 2-1
	// findAll() - 전체 조회 
	
	
	// JPQL 문법 (기본적으로 제공되는 메소드 X) 
	// ex 02-1 방법2 (id 기준 내림차순 전체 조회)
	public List<StudentEntity> findAllByOrderByIdDesc();
	
	// ex 02-1 방법3 (id 기준 내림차순 3개만 조회) 
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	
	// ex 02-1 방법4 (이름이 유재석인 데이터 조회) 
	public List<StudentEntity> findByName(String name);
	
	// ex 02-1 방법5 (in 문으로 일치하는 값 모두 조회) 
	public List<StudentEntity> findByNameIn(List<String> names);
	
	// ex 02-1 방법6 (여러 컬럼 값과 일치하는 데이터 조회) 
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	
	// ex 02-1 방법7 (email 컬럼에 naver 키워드가 포함된 데이터 조회) 
	public List<StudentEntity> findByEmailContaining(String Email);
	
	// ex 02-1 방법8 (이름이 '유'로 시작하는 데이터 조회) 
	public List<StudentEntity> findByNameStartingWith(String name);
	
	// ex 02-1 방법9 (id가 1~5인 데이터 조회) 
	public List<StudentEntity> findByIdBetween(int start, int end);
	
	
	
	// ex 02-2
	// 1) JPQL : Entity로 조회
//	@Query(value = "select st from new_student st where st.dreamJob = :dreamJob") 	// :dreamJob은 밑의 @Param("dreamJob")과 일치
//	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);	// ★★★ Ibatis로 임포트하면 안됨!! ★★★
	
	
	
	// 2) native query로 조회 => 위에꺼랑 같아서 위에꺼 주석처리
	@Query(value = "select * from `new_student` where dreamJob = :dreamJob", nativeQuery = true)
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
	
	
}
