package htf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.domain.Admin;
import htf.backend.kakao.KakaoTalkService;
import htf.backend.service.AdminService;
import net.minidev.json.JSONObject;

@CrossOrigin
@RestController
public class AlarmController {

	@Autowired
	private AdminService adminService;
	
	private KakaoTalkService kakaoService;
	
	@PostMapping(path = "/fireKakao")
    public String fireKakao(@RequestBody Admin admin) throws Exception {
		JSONObject clientList = new JSONObject();
		String token = adminService.findByAdId(admin.getAdId()).getKakaoToken();
		try {
			clientList = kakaoService.getList(token);
		} catch (Exception e) {
			return e.getMessage();
		}
		kakaoService.sendAlarm(clientList, token);
		return token;
    }

}