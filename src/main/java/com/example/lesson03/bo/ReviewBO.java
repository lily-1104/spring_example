package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	
	// 1
	// input : id / output : Review (단건)
	public Review getReview(int id) {
		
		return reviewMapper.selectReview(id);
		
	}
	
	
	
	// 2-1
	// input : Review (단건) / output : int (성공된 행의 개수)
	public int addReview(Review review) {
		
		return reviewMapper.insertReview(review);
		
	}
	
	
	
	// 2-2
	// addReviewAsField(4, "콤비네이션R", "김바다", 5.0, "역시 맛있다!!!")
	public int addReviewAsField(int storeId, String menu, String userName, Double point, String review) {	// Double은 null 가능
		
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);	// 자동완성이랑 위의 파라미터랑 순서 같은지 확인하기
		
	}
	
	
	
	// 3 
	// input(컨트롤러가 넘겨주는 것) : id, review / output : int (성공된 행의 개수 => mybatis가 채워서 보내줌)
	public int updateReviewById(int id, String review) {
		
		return reviewMapper.updateReviewById(id, review);
		
	}
	
	
	
	// 4
	// input : id / output : 내 맘대로
	public void deleteReviewById(int id) {	// void : 컨트롤러가 성공된 행의 개수를 필요로 하지 않아서 안 줄거면 void 써도 됨 (int ,void 둘 다 사용 가능)
		
		reviewMapper.deleteReviewById(id);	// delete는 return X
		
	}

	
}
