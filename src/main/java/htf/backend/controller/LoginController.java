package htf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import htf.backend.domain.Member;
import htf.backend.service.MemberService;

@SessionAttributes("member")
@Controller
public class LoginController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Member member, Model model) {
		Member findMember = memberService.getMember(member);

		if (findMember != null && findMember.getMem_pw().equals(member.getMem_pw())) {
			model.addAttribute("member", findMember);
			return "forward:getBoardList";
		} else {
			return "redirect:login.html";
		}
	}

	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:index.html";
	}

}
