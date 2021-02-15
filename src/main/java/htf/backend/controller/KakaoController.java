package htf.backend.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.domain.Member;
import htf.backend.service.MemberService;
import htf.backend.subscription.KakaoSubscription;

@CrossOrigin
@RestController
public class KakaoController {
	@Autowired
	private MemberService memberService;
	
	@PostMapping("initSub")
	public String initSub(@RequestBody String s) throws Exception {
		JSONObject param = new JSONObject(s);
		System.out.println("param : "+s);
		JSONObject res = KakaoSubscription.requestPayment(param.getString("memId"), param.getString("rank"), param.getString("price"));
		return "{\"tid\":\""+res.getString("tid")+"\",\"url\":\""+res.getString("next_redirect_pc_url")+"\"}";
	}
	
	@PostMapping("kakaoSub")
	public void kakaoSub(@RequestBody String s , @RequestBody Member member) throws Exception {
		JSONObject param = new JSONObject(s);
		JSONObject res = KakaoSubscription.requestApprove(param.getString("tid"), param.getString("pg_token"), param.getString("memId"));
		System.out.println("final result : "+res);
	
		//sid를 DB에 update시키고, rank도 update시키고, memId도 알고있음
	}
}
