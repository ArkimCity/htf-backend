package htf.backend.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
	private static MemberService memberService;
	
	@PostMapping("initSub")
	public String initSub(@RequestBody String s) throws Exception {
		JSONObject param = new JSONObject(s);
		System.out.println("param : "+s);
		JSONObject res = KakaoSubscription.requestPayment(param.getString("memId"), param.getString("rank"), param.getString("price"));
		return "{\"tid\":\""+res.getString("tid")+"\",\"url\":\""+res.getString("next_redirect_pc_url")+"\"}";
	}
	
	@PostMapping("kakaoSub")
	public void kakaoSub(@RequestBody String s) throws Exception {
		JSONObject param = new JSONObject(s);
		JSONObject res = KakaoSubscription.requestApprove(param.getString("tid"), param.getString("pg_token"), param.getString("memId"));
		System.out.println("final result : "+res);
		Member updateMember = memberService.findByMemId(res.getString("partner_user_id"));
		updateMember.setMemId(res.getString("partner_user_id"));
		updateMember.setMemRank(res.getString("item_name"));
		updateMember.setSid(res.getString("sid"));
		String approveData = res.getString("approved_at").replace("T", " ");
		Timestamp t = Timestamp.valueOf(approveData);
		System.out.println("Payment date : "+t);
		updateMember.setPaymentDate(t);
		memberService.updateMember(updateMember);
	}
	
	public static void kakaoSubPay(String memId, String sid, String rank) throws Exception {
		if(rank.equals("pro")) {
			KakaoSubscription.requestSubscribe(sid, "5000", memId);
		} else if(rank.equals("enterprise")) {
			KakaoSubscription.requestSubscribe(sid, "10000", memId);
		}
		Timestamp t = memberService.findByMemId(memId).getPaymentDate();
		Calendar currentCal = Calendar.getInstance();
		currentCal.add(currentCal.DATE, 0);
		if(!t.equals(null) && (t.getDate() == currentCal.get(Calendar.DATE) && t.getMonth() == currentCal.get(Calendar.MONTH)+2)) {
			System.out.println("it's time to Pay!");
			t.setMonth(t.getMonth()+1);
			Member updateMember = new Member();
			updateMember.setPaymentDate(t);
			memberService.updateMember(updateMember);
		} else {
			System.out.println(t);
			System.out.println(currentCal);
		}
	}
	public static void checkSubDate(String memId, String sid, String rank) {
		int sleepDay = 1; // 실행간격 : 하루
		final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
		exec.scheduleAtFixedRate(new Runnable() {
			public void run() {
				try {
					kakaoSubPay(memId, sid, rank);
				} catch (Exception e) {
					e.printStackTrace();
					// 에러 발생시 Executor를 중지시킨다
					exec.shutdown();
				}
			}
		}, 0, sleepDay, TimeUnit.DAYS);
	}
}
