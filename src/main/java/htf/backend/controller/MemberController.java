package htf.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.domain.Admin;
import htf.backend.domain.Member;
import htf.backend.service.MemberService;

@CrossOrigin
@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	@ModelAttribute("member")
	public Member setMember() {
		return new Member();
	}

//	@RequestMapping("/getMemberList")
//	public List<Member> getMemberList(@ModelAttribute("member") Member member, Model model) {
//		if (member.getMemId() == null) {
//		}
//		List<Member> memberList = memberService.getMemberList(member);
//		System.out.println(memberList);
//		model.addAttribute("memberList", memberList);
//		return memberList;
//	}
	
	@PostMapping("/getMemberListByAdId")
	public List<Member> getMemberListByAdId(@RequestBody Admin admin) {
		if (admin == null) {
			System.out.println(admin);
		}
		List<Member> memberList = memberService.getMemberListByAdId(admin);
		System.out.println(memberList);
		return memberList;
	}

//	@GetMapping("/insertMember")
//	public String insertMemberView(@ModelAttribute("member") Member member) {
//		if (member.getMemId() == null) {
//			return "redirect:login";
//		}
//		return "insertMember";
//	}

	@PostMapping("/insertMember")
	public String insertMember(@RequestBody Member member) {
		if (member.getMemId() == null) {
			return "redirect:login";
		}
		memberService.insertMember(member);
		System.out.println("-------insertMember----------------------");
		return "redirect:getMemberList";
	}

	@PostMapping("/getMember")
	public Member getMember(@RequestBody Member member) {
		if (member.getMemId() == null) {
			return null;
		}
		Member findMember = memberService.findByMemId(member.getMemId());
		return findMember;
	}

	@PostMapping("/updateMemberRank")
	public String updateMemberRank(@RequestBody Member member) {
		Member updateMember = memberService.findByMemId(member.getMemId()); 
		updateMember.setMemRank(member.getMemRank());
		memberService.updateMember(updateMember);
		return updateMember.getMemRank();
	}
	
	@PostMapping("/updateMemberEmail")
	public String updateMemberEmail(@RequestBody Member member) {
		Member updateMember = memberService.findByMemId(member.getMemId()); 
		updateMember.setEmail(member.getEmail());
		memberService.updateMember(updateMember);
		return updateMember.getEmail();
	}
	@PostMapping("/updateMemberContact")
	public String updateMemberContact(@RequestBody Member member) {
		Member updateMember = memberService.findByMemId(member.getMemId()); 
		updateMember.setContact(member.getContact());
		memberService.updateMember(updateMember);
		return updateMember.getContact();
	}
	@PostMapping("/updateMemberAddress")
	public String updateMemberAddress(@RequestBody Member member) {
		Member updateMember = memberService.findByMemId(member.getMemId()); 
		updateMember.setAdress(member.getAdress());
		memberService.updateMember(updateMember);
		return updateMember.getAdress();
	}
	@PostMapping("/updateMemberPw")
	public String updateMemberPw(@RequestBody Member member) {
		Member updateMember = memberService.findByMemId(member.getMemId()); 
		updateMember.setMemPw(member.getMemPw());
		memberService.updateMember(updateMember);
		return updateMember.getMemPw();
	}
	
//	@GetMapping("/deleteMember")
//	public String deleteMember(@ModelAttribute("member") Member member) {
//		if (member.getMemId() == null) {
//			return "redirect:login";
//		}
//		memberService.deleteMember(member);
//		return "getMemberList";
//	}

	@PostMapping("/updateMemberToken")
	public String updateMemberToken(@RequestBody Member member) {
		Member updateMember = memberService.findByMemId(member.getMemId());
		updateMember.setKakaoToken(member.getKakaoToken());
		memberService.updateMember(updateMember);
		return updateMember.getKakaoToken();
	}
}
