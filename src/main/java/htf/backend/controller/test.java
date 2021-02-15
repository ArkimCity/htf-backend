package htf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import htf.backend.dao.MemberRepository;
import htf.backend.domain.Member;
import htf.backend.service.MemberService;
import htf.backend.service.MemberServiceImpl;

@Component
@EnableAutoConfiguration
public class test {

	@Autowired
	private static MemberService memberservice;
	
	public static void main(String[] args) {
		Member member = new Member();
		member.setMemId("sh");
		memberservice.findByMemId("sh");
//		memberRepo.findByMemId("sh");
//		KakaoController.checkSubDate("sh", "test", "testtest");
	}

}
