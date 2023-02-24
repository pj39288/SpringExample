package com.doongie.spring.ex.myBatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doongie.spring.ex.myBatis.bo.ReviewBO;
import com.doongie.spring.ex.myBatis.model.Review;

@Controller
public class ReviewController {

	@Autowired
	private ReviewBO reviewBO;
	
	// 전달받은 id와 일치하는 데이터 조회 후 결과를 json으로 response
	@RequestMapping("/mybatis/ex01")
	@ResponseBody
	public Review review(@RequestParam("id") int id) {
		
		// int id = Integer.parseInt(request.getParameter("id"));
		
		Review review = reviewBO.getReview(id);
		
		return review;
	}
	
	@RequestMapping("/mybatis/ex02")
	@ResponseBody
	public String addReview() {
		
		// int count = reviewBO.addReview(4, "콤비네이션피자", "김인규", 4.5, "할인도 받고 잘 먹었어요");
		
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("김인규");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클은 진리입니다");
		
		int count = reviewBO.addReviewByObject(review);
		
		return "실행결과 : " + count;
		
	}
}
