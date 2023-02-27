package com.doongie.spring.ex.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doongie.spring.ex.jsp.dao.UserDAO;
import com.doongie.spring.ex.jsp.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	// 이름, 생년월일, 이메일, 자기소개 저장
	public int addUser(String name, String birthday, String email, String introduce) {
		
		return userDAO.insertUser(name, birthday, email, introduce);
	
	}
	
	public User getLastUser() {
		return userDAO.selectLastUser();
	}

}
