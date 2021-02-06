package htf.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import htf.backend.dao.MemberRepository;
import htf.backend.domain.Member;
import htf.backend.service.JWTService;
import htf.backend.service.MemberService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class LoginController {

    @Autowired
    private MemberRepository memberRepository;
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