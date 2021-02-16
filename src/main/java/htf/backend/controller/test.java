package htf.backend.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.dao.MemberRepository;
import htf.backend.domain.Member;
import htf.backend.service.MemberService;
import htf.backend.service.MemberServiceImpl;

@CrossOrigin
@RestController
public class test {
	@Autowired
	private MemberService memberservice;
	
	@PostMapping("test")
	public void test() {
		Member m = memberservice.findByMemId("sh");

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
//        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
//        System.out.println(sdf.format(timestamp)); // format을 사용해 출력
		
		m.setPaymentDate(timestamp);
		KakaoController.checkSubDate("sh", "test", "testtest", m.getPaymentDate());
	}

}
