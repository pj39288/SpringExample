package com.doongie.spring.ex.myBatis.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.doongie.spring.ex.myBatis.dao.ReviewDAO;
import com.doongie.spring.ex.myBatis.model.Review;

@Service
public class ReviewBO {

	@Autowired
	private ReviewDAO reviewDAO;
	
	// 전달받은 id와 일치하는 데이터 조회 후 결과 리턴
	public Review getReview(@RequestParam("id") int id) {
		
		Review review = reviewDAO.selectReview(id);
		
		return review;
	}
}
