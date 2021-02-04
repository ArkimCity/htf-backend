package htf.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("test")
	public String testMethod() {
		return "백엔드 서버 테스트";
	}
}
