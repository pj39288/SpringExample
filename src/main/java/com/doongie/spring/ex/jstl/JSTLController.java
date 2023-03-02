package com.doongie.spring.ex.jstl;

import java.util.ArrayList;
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
		
		// List<Map>
		// 사용자 정보 Map (이름, 나이, 취미)
		List<Map<String, Object>> userList = new ArrayList();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "김인규");
		map.put("age", 28);
		map.put("hobby", "댄스");
		
		userList.add(map);

		
		model.addAttribute("fruitList", fruitList);

		
		return "/jstl/ex02";
	}
	
}
