package com.doongie.spring.ex.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doongie.spring.ex.jsp.bo.UserBO;
import com.doongie.spring.ex.jsp.model.User;

@Controller
@RequestMapping("/jsp/user")
public class UserController {

	@Autowired
	private UserBO userBO;

	// 이름, 생년월일, 이메일, 자기소개 전달받고 데이터 저장
	// @RequestMapping(path="/add", method=RequestMethod.POST)
	@PostMapping("/add")
	// @ResponseBody
	public String addUser(
			@RequestParam("name") String name
			, @RequestParam("yyyymmdd") String yyyymmdd
			, @RequestParam("email") String email
			, @RequestParam("introduce") String introduce
			, Model model) {
		
		// int count = userBO.addUser(name, birthday, email, introduce);
		
		// return "삽입결과  : " + count;
		
		// insert문과 select문을 하나의 트랜잭션으로 묶을 필요가 있다
		// 방금 insert한 id를 얻어온다. 
		// 객체로 전달
		User user = new User();
		user.setName(name);
		user.setYyyymmdd(yyyymmdd);
		user.setEmail(email);
		user.setIntroduce(introduce);
		
		int count = userBO.addUserByObject(user);
		
		model.addAttribute("user", user);
		
		return "jsp/lastuser";

			
		
	}
	
	@GetMapping("/input")
	public String userInput() {
		
		return "jsp/userinput";
		
	}
	
	// 가장 최근에 등록된 사용자 정보를 html로 구성한다.
	@GetMapping("/lastuser")
	public String lastUser(Model model) {
		
		// 최근 등록된 사용자 조회
		User lastUser = userBO.getLastUser();
		
		// 조회결과를 jsp에 쓸수이도록 세팅
		model.addAttribute("user", lastUser);
		
		return "jsp/lastuser";
		
	}
	
	
	
}
