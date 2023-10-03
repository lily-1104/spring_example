package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller		// jsp를 뿌릴 때는 @ResponseBody가 없는 @Controller를 사용해야 함
public class LessonEx02Controller {
	
	// 요청 URL : http://localhost/lesson01/ex02	 => 포트 번호 80으로 바꿔서 :8080 없어도 됨
	@RequestMapping("/lesson01/ex02")
	public String ex02() {
		
		// jsp 경로를 리턴
		return "lesson01/ex02";		// jsp view 경로와 이름
	}

}
