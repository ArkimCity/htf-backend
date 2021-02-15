package htf.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.subscription.KakaoSubscription;

@CrossOrigin
@RestController
public class KakaoController {
	@PostMapping("initSub")
	public String initSub() throws Exception {
		return KakaoSubscription.requestPayment();
	}
	
	@GetMapping("kakaoSub")
	public void kakaoSub(@RequestParam String pg_token) throws Exception {
		KakaoSubscription ks = new KakaoSubscription();
		System.out.println("pg_token : "+pg_token);
		String tid = ks.tid;
		System.out.println("getTid : "+tid);
		KakaoSubscription.requestApprove(tid, pg_token);
	}
}
