package com.doongie.spring.ex.myBatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.doongie.spring.ex.myBatis.model.Review;

@Repository
public interface ReviewDAO {

	public Review selectReview(@Param("id") int id);
	
}
