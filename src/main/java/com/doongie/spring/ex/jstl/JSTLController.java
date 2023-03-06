package com.doongie.spring.ex.jstl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jstl")
public class JSTLController {

	@GetMapping("/ex01")
	public String ex01() {
		return "jstl/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		//과일 이름 리스트
		List <String> fruitList = new ArrayList();
		fruitList.add("사과");
		fruitList.add("딸기");
		fruitList.add("바나나");
				
		model.addAttribute("fruitList", fruitList);

		
		
		
		List<Map<String, Object>> userList = new ArrayList<>();
		
		
		// 사용자 정보 리스트 (이름, 나이, 취미) -- 각각이 key 들임
		// user 한사람 만든것
		Map<String, Object> user = new HashMap<>();
		user.put("name", "김인규");
		user.put("age", 28);
		user.put("hobby", "댄스");
		userList.add(user);
		
		
		user= new HashMap<>();
		user.put("name", "김바다");
		user.put("age", 5);
		user.put("hobby", "사냥");
		userList.add(user);
		
		
		// model에 userList라는 키로 해당값을 저장
		// jsp에서 그대로 쓸수있게 하기 위해서
		model.addAttribute("userList", userList);
		

		return "/jstl/ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(Model model) {
		
		Date now = new Date();
		model.addAttribute("now", now);
		
		String dateString = "2023/03/03 12:11:10";
		model.addAttribute("dateString", dateString);
		
		return "jstl/ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04() {
		
		return "jstl/ex04";
		
	}
	
}
