package htf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.domain.Admin;
import htf.backend.domain.Member;
import htf.backend.domain.Vendor;
import htf.backend.service.AdminService;
import htf.backend.service.JWTService;
import htf.backend.service.MemberService;
import htf.backend.service.VendorService;

@CrossOrigin
@RestController
public class LoginController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private JWTService jwtService;

	@PostMapping(path = "/loginMember")
    public String loginMember(@RequestBody Member member) throws Exception {
		String response = "{\"htfToken\":\"";
        try {
        	Member loginMember = memberService.findByMemId(member.getMemId());
        	if(loginMember != null && loginMember.getMemPw().equals(member.getMemPw())){
        		String token = jwtService.create(member.getMemId(), loginMember, "user");
        		response += token + "\", \"kakaoToken\":\"";
        		response += loginMember.getKakaoToken() + "\", \"memRank\":\"";
        		response += loginMember.getMemRank() + "\"}";
        	}
        } catch(Exception e) {
        	throw new Exception();
        }
		return response;
    }
	
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
	
	@PostMapping(path = "/loginVendor")
	public String loginVendor(@RequestBody Vendor vendor) throws Exception {
		String response = null;
		try {
			Vendor loginVendor = vendorService.findByVendorId(vendor.getVendorId());
			System.out.println(loginVendor);
			if(loginVendor != null && loginVendor.getVendorId().equals(vendor.getVendorId())){
				String token = jwtService.create(vendor.getVendorId(), loginVendor, "admin");
				response = token;
			}
		} catch(Exception e) {
			throw new Exception();
		}
		return response;
	}
}