package htf.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@ModelAttribute("machine")
	public Machine setMachine() {
		return new Machine();
	}

	@RequestMapping("/getMachineList")
	public List<Machine> getMachineList(@ModelAttribute("machine") Machine machine, Model model) {
		if (machine.getMchId() == null) {//?
		}
		List<Machine> machineList = machineService.getMachineList(machine);
		model.addAttribute("machineList", machineList);
		return machineList;
	}

	@GetMapping("/insertMachine")
	public String insertMachineView(@ModelAttribute("machine") Machine machine) {
		if (machine.getMchId() == null) {
			return "redirect:login";
		}
		return "insertMachine";
	}

	@PostMapping("/insertMachine")
	public String insertMachine(@ModelAttribute("machine") Machine machine) {
		if (machine.getMchId() == null) {
			return "redirect:login";
		}
		machineService.insertMachine(machine);
		return "getMachineList";
	}

	@GetMapping("/getMachine")
	public String getMachine(@ModelAttribute("machine")Machine machine, Model model) {
		if (machine.getMchId() == null) {
			return "redirect:login";
		}
		model.addAttribute("machine", machineService.getMachine(machine));
		return "getMachine";
	}

	@PostMapping("/updateMachine")
	public String updateMachine(@ModelAttribute("machine") Machine machine) {
		if (machine.getMchId() == null) {
			return "redirect:login";
		}
		machineService.updateMachine(machine);
		return "getMachineList";
	}

	@GetMapping("/deleteMachine")
	public String deleteMachine(@ModelAttribute("machine") Machine machine) {
		if (machine.getMchId() == null) {
			return "redirect:login";
		}
		machineService.deleteMachine(machine);
		return "getMachineList";
	}
	
	@CrossOrigin
	@PostMapping("/getMachineListByMemId")
	public List<Machine> getMachineListByMemId(@RequestBody Member member) {
		return machineService.getMachineListByMemId(memberService.findByMemId(member.getMemId()));
	}
	
	
}