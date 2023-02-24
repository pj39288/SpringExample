package com.doongie.spring.ex.myBatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.doongie.spring.ex.myBatis.model.Review;

@Repository
public interface ReviewDAO {

	public Review selectReview(@Param("id") int id);
	
	public int insertReview(
			@Param("storeId") int storeId
			, @Param("menu") String menu
			, @Param("userName") String userName
			, @Param("point") double point
			, @Param("review") String review);
	
	public int insertReviewByObject(Review review);
	
}
