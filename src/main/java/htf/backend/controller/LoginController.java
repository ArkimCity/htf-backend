package htf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.dao.MemberRepository;
import htf.backend.domain.Member;
import htf.backend.service.JWTService;
import htf.backend.service.MemberService;

@CrossOrigin
@RestController
public class LoginController {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberService memberService;
	@Autowired
	private JWTService jwtService;

	@PostMapping(path = "/login")
    public String login(@RequestBody Member member) throws Exception {
    	String response = null;
        try {
        	Member loginMember = memberService.getMember(member);
        	if(loginMember != null && loginMember.getMemPw().equals(member.getMemPw())){
        		System.out.println("++++++++++++++++" + loginMember);
        		System.out.println("++++++++++++++++++++++" + member);
        		String token = jwtService.create("member", loginMember, "user");
        		response = token;
        	}
        } catch(Exception e) {
        	throw new Exception();
        }
		return response;
    }

}