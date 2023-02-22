package com.doongie.spring.ex.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.doongie.spring.ex.database.model.UsedGoods;	

@Repository
public interface UsedGoodsDAO {

	// used_goods 테이블 데이터 조회리턴
	public List<UsedGoods> selectUsedGoodsList();
}
