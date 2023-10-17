package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	
	
	// 1
	public Review selectReview(int id);
	
	
	
	// 2-1
	// return int는 MyBatis가 성공된 행의 개수를 리턴해준다
	public int insertReview(Review review);
	
	
	
	// 2-2
	public int insertReviewAsField(
			
			// 파라미터가 2개 이상이면 map으로 만든다 => @Param이 해줌
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	
	
	// 3 
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review") String review);
	
	
	
	// 4
	public int deleteReviewById(int id);	// 파라미터가 id 하나라서 map으로 감싸지않아도 됨
			// int ,void 둘 다 사용 가능
	
	
}
