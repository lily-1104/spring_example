package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

@RequestMapping("/lesson04/ex01")
@Controller		// jsp로 보낼 때는 @ResponseBody가 없어야한다
public class Lesson04Ex01Controller {
	
	
	@Autowired
	private UserBO userBO;
	
	
	// 1-1 회원가입 페이지
	// URL : http://localhost/lesson04/ex01/sign-up-view
	@RequestMapping(path = "/sign-up-view", method = RequestMethod.GET)
	public String signUpView() {
		
		return "lesson04/signUp";	// jsp view 경로 
		
	}
	
	
	
	// 회원가입 수행 (DB에 insert) 후 결과 페이지로 이동
	// URL : http://localhost/lesson04/ex01/sign-up
	@PostMapping("/sign-up")
	public String signUp(
			@RequestParam("name") String name,	// "name"은 signUP.jsp에서 id 값이 아닌 name 값!
			@RequestParam("yyyymmdd") String yyyymmdd, 		
			@RequestParam(value="introduce", required=false) String introduce,		// introduce는 NULL이라서 비필수이기 때문에 이렇게 씀
			@RequestParam(value="email", required=false) String email) {	
		
		
		// NULL이 NO이면 필수이니까 필수 항목만 @RequestParam 사용??
		
		// DB Insert
		userBO.addUser(name, yyyymmdd, introduce, email);
		
		return "lesson04/signUpResult";
		
	}
	
	
	
	// 최신 가입자 한명 가져오는 페이지
	// URL : http://localhost/lesson04/ex01/get-latest-user-view
	@GetMapping("/get-latest-user-view")
	public String getLatestUserView(Model model) {
		
		// DB select 조회
		User user = userBO.getLatestUser();
		model.addAttribute("result", user);		// model에 담기 위해 addAttribute 사용, view에서 꺼내서 사용하려면 이 코드 꼭 있어야함
		model.addAttribute("title", "최신 유저 정보");
		
		return "lesson04/getLatestUser";	// 결과 jsp 경로
		
	}
	
	
}
