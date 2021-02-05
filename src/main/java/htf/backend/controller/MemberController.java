package htf.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import htf.backend.domain.Admin;
import htf.backend.domain.Member;
import htf.backend.service.MemberService;

@SessionAttributes("member")
@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	@ModelAttribute("member")
	public Member setMember() {
		return new Member();
	}

	@RequestMapping("/getMemberList")
	public String getMemberList(@ModelAttribute("member") Member member, Model model, Admin admin) {

		if (member.getMem_id() == null) {
			return "redirect:login.html";
		}

		List<Member> memberList = memberService.getMemberList(member);

		System.out.println(memberList);
		model.addAttribute("memberList", memberList);
		return "getMemberList";
	}

	@GetMapping("/insertMember")
	public String insertMemberView(@ModelAttribute("member") Member member) {
		if (member.getMem_id() == null) {
			return "redirect:login";
		}
		return "insertMember";
	}

	@PostMapping("/insertMember")
	public String insertMember(@ModelAttribute("member") Member member, Admin admin) {
		if (member.getMem_id() == null) {
			return "redirect:login";
		}
		memberService.insertMember(member);
		System.out.println("-------insertMember----------------------");
		return "redirect:getMemberList";
	}

	@GetMapping("/getMember")
	public String getMember(@ModelAttribute("member")Member member, Admin admin, Model model) {
		if (member.getMem_id() == null) {
			return "redirect:login";
		}

		model.addAttribute("member", memberService.getMember(member));
		return "getMember";
	}

	@PostMapping("/updateMember")
	public String updateMember(@ModelAttribute("member") Member member, Admin admin) {
		if (member.getMem_id() == null) {
			return "redirect:login";
		}

		memberService.updateMember(member);
		return "forward:getMemberList";
	}

	@GetMapping("/deleteMember")
	public String deleteMember(@ModelAttribute("member") Member member, Admin admin) {
		if (member.getMem_id() == null) {
			return "redirect:login";
		}

		memberService.deleteMember(member);
		return "forward:getMemberList";
	}

}
