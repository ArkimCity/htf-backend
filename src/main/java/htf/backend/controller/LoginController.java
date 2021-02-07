package htf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.domain.Member;
import htf.backend.service.JWTService;
import htf.backend.service.MemberService;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private JWTService jwtService;

    @PostMapping(path = "/login")
    public String login(@RequestBody Member member) {
    	Member loginMember;
        try {
        	loginMember = memberService.signIn(member.getMemId(), member.getMemPw());
            String token = jwtService.create("member", loginMember, "user");
            return token;
        } catch(Exception e) {
            return "failed";
        }
    }
    
}