package htf.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.domain.Machine;
import htf.backend.domain.Member;
import htf.backend.service.MachineService;
import htf.backend.service.MemberService;
@CrossOrigin
@RestController
public class MachineController {
	
	@Autowired
	private MachineService machineService;
	
	@Autowired
	private MemberService memberService;
	
	@CrossOrigin
	@PostMapping("/getMachineListByMemId")
	public List<Machine> getMachineListByMemId(@RequestBody Member member) {
		return machineService.getMachineListByMemId(memberService.findByMemId(member.getMemId()));
	}
	
	
}
