package com.doongie.spring.ex.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doongie.spring.ex.jsp.bo.UserBO;
import com.doongie.spring.ex.jsp.model.User;

@Controller
@RequestMapping("/ajax")
public class NewUserController {
	
	@Autowired
	private UserBO userBO;
	
	@GetMapping("/user")
	public String userList(Model model) {
		
		List<User> userList = userBO.getUserList();
		
		model.addAttribute("userList", userList);
		
		return "ajax/user";
	}
	
	@GetMapping("/add")
	@ResponseBody
	public Map<String, String> addUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email
			, @RequestParam("introduce") String introduce) {
		
		int count = userBO.addUser(name, birthday, email, introduce);
		
		// 성공여부 json
		// 성공 : {"result":"success"}
		// 실패 : {"result":"fail"}
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
		// return "redirect:/ajax/user";
		
	}
	
	@GetMapping("/input")
	public String inputUser() {
		return "ajax/input";
	}
	
	// email 전달받고 중복여부 확인하고 
	// 중복여부 결과를 response로 전달
	@GetMapping("/is_duplicate")
	@ResponseBody
	public Map<String, Boolean> isDuplicateEmail(@RequestParam("email") String email) {
		
		// json 데이터 만들면됨 (key, value) 형태로
		// 중복된경우
		// {is_duplicate: true}
		// 중복아닌경우
		// {is_duplicate: false}
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
		if(userBO.isDuplicateEmail(email)) {
			// 중복된 경우 (true값이므로 if문안에서 사용가능)
			resultMap.put("is_duplicate", true); 
		} else {
			resultMap.put("is_duplicate", false);
		}
		
		return resultMap;
		
	}
}
