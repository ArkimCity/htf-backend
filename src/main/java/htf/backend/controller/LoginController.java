package htf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.domain.Admin;
import htf.backend.domain.Member;
import htf.backend.service.AdminService;
import htf.backend.service.JWTService;
import htf.backend.service.MemberService;

@CrossOrigin
@RestController
public class LoginController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private JWTService jwtService;

	@CrossOrigin
	@PostMapping(path = "/loginMember")
    public String loginMember(@RequestBody Member member) throws Exception {
    	String response = null;
        try {
        	Member loginMember = memberService.findByMemId(member.getMemId());
        	System.out.println(loginMember);
        	if(loginMember != null && loginMember.getMemPw().equals(member.getMemPw())){
        		String token = jwtService.create(member.getMemId(), loginMember, "user");
        		response = token;
        	}
        } catch(Exception e) {
        	throw new Exception();
        }
		return response;
    }
	
	@CrossOrigin
	@PostMapping(path = "/loginAdmin")
	public String loginAdmin(@RequestBody Admin admin) throws Exception {
    	String response = null;
        try {
        	Admin loginAdmin = adminService.findByAdId(admin.getAdId());
        	System.out.println(loginAdmin);
        	if(loginAdmin != null && loginAdmin.getAdId().equals(admin.getAdId())){
        		String token = jwtService.create(admin.getAdId(), loginAdmin, "admin");
        		response = token;
        	}
        } catch(Exception e) {
        	throw new Exception();
        }
		return response;
	}
}