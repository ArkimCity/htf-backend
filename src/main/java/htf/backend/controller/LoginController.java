package htf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.domain.Member;
import htf.backend.service.JWTService;
import htf.backend.service.MemberService;

@CrossOrigin(origins="*")
@RestController
public class LoginController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private JWTService jwtService;

	@PostMapping(path = "/login")
    public String login(@RequestBody Member member) throws Exception {
    	String response = null;
        try {
        	Member loginMember = memberService.findByMemId(member.getMemId());
        	if(loginMember != null && loginMember.getMemPw().equals(member.getMemPw())){
        		String token = jwtService.create(member.getMemId(), loginMember, "user");
        		response = token;
        	}
        } catch(Exception e) {
        	throw new Exception();
        }
		return response;
    }
}