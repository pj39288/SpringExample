package com.doongie.spring.ex.myBatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doongie.spring.ex.myBatis.bo.ReviewBO;
import com.doongie.spring.ex.myBatis.model.Review;

import jakarta.servlet.http.HttpServletRequest;

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
}
