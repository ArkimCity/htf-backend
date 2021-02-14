package htf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.domain.Admin;
import htf.backend.domain.Member;
import htf.backend.domain.Vendor;
import htf.backend.kakao.KakaoService;
import htf.backend.service.AdminService;
import htf.backend.service.JWTService;
import htf.backend.service.MemberService;
import htf.backend.service.VendorService;
import net.minidev.json.JSONObject;

@CrossOrigin
@RestController
public class AlarmController {

	@Autowired
	private AdminService adminService;
	
	private KakaoService kakaoService;
	
	@PostMapping(path = "/fireKakao")
    public String fireKakao(@RequestBody Admin admin) throws Exception {
		JSONObject clientList = new JSONObject();
		String token = adminService.findByAdId(admin.getAdId()).getKakaoToken();
		System.out.println(token);
		System.out.println("======================================================");
		try {
			System.out.println(token);
			clientList = kakaoService.getList(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("======================================================");
		kakaoService.sendAlarm(clientList, token);
		return token;
    }

}