package com.example.lesson05;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {
	
	
	// URL : http://localhost/lesson05/ex01
	@GetMapping("/ex01")
	public String ex01() {
		
		return "lesson05/ex01";
		
	}
	
	
	
	// URL : http://localhost/lesson05/ex02
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		// List<String>
		List<String> fruits = List.of("apple", "melon", "peach", "grape", "mango");
		model.addAttribute("fruits", fruits);
		
		
		// List<Map<String, Object>>
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> user = new HashMap<>();
		user.put("name", "김지현");
		user.put("age", 30);
		user.put("hobby", "독서");
		list.add(user);
		
		user = new HashMap<>();
		user.put("name", "김바다");
		user.put("age", 5);
		user.put("hobby", "사냥");
		list.add(user);
		
		model.addAttribute("users", list);
		
		
		return "lesson05/ex02";
		
	}
	
	
	
	// URL : http://localhost/lesson05/ex03
	@GetMapping("/ex03")
	public String ex03(Model model) {
		
		Date today = new Date();
		model.addAttribute("today", today);
		
		return "lesson05/ex03";
		
	}
	
	
	
	// URL : http://localhost/lesson05/ex04
	@GetMapping("/ex04")
	public String ex04() {
		
		return "lesson05/ex04";
		
	}
	
	
}
