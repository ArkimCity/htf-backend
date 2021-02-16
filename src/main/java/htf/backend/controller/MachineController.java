package htf.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.domain.Machine;
import htf.backend.domain.Member;
import htf.backend.domain.Vendor;
import htf.backend.service.MachineService;
import htf.backend.service.MemberService;
import htf.backend.service.VendorService;
@CrossOrigin
@RestController
public class MachineController {
	
	@Autowired
	private MachineService machineService;
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private VendorService vendorService;
	
	@ModelAttribute("machine")
	public Machine setMachine() {
		return new Machine();
	}

//	@RequestMapping("/getMachineList")
//	public List<Machine> getMachineList(@ModelAttribute("machine") Machine machine, Model model) {
//		if (machine.getMchId() == null) {//?
//		}
//		List<Machine> machineList = machineService.getMachineList(machine);
//		model.addAttribute("machineList", machineList);
//		return machineList;
//	}

//	@GetMapping("/insertMachine")
//	public String insertMachineView(@RequestBody Machine machine) {
//		if (machine.getMchId() == null) {
//			return "redirect:login";
//		return "insertMachine";
//	}

	@PostMapping("/insertMachine")
	public String insertMachine(@RequestBody Machine machine) {
		if (machine.getMchId() == null) {
			return "redirect:login";
		}
		machineService.insertMachine(machine);
		return "getMachineList";
	}

	@PostMapping("/getAdIdByMchId")
	public String getMachine(@RequestBody Machine machine) {
		System.out.println(machine);
		if (machine.getMchId() == null) {
			return "redirect:login";
		}
		String adId = machineService.findByMchId(machine.getMchId()).getMemId().getAdId().getAdId();
		return adId;
	}

	@PostMapping("/updateMachine")
	public String updateMachine(@RequestBody Machine machine) {
		if (machine.getMchId() == null) {
			return "redirect:login";
		}
		machineService.updateMachine(machine);
		return "getMachineList";
	}
	
	@PostMapping("/updateMachineType")
	public String updateMachineType(@RequestBody Machine machine) {
		if (machine.getMchId() == null) {
			return "redirect:login";
		}
		Machine newMachine = machineService.findByMchId(machine.getMchId());
		newMachine.setType(machine.getType());
		machineService.updateMachine(newMachine);
		return "getMachineList";
	}

//	@GetMapping("/deleteMachine")
//	public String deleteMachine(@ModelAttribute("machine") Machine machine) {
//		if (machine.getMchId() == null) {
//			return "redirect:login";
//		}
//		machineService.deleteMachine(machine);
//		return "getMachineList";
//	}
	
	@PostMapping("/getMachineListByMemId")
	public List<Machine> getMachineListByMemId(@RequestBody Member member) {
		return machineService.getMachineListByMemId(memberService.findByMemId(member.getMemId()));
	}
	
	@PostMapping("/getMachineListByVendorId")
	public List<Machine> getMachineListByVendorId(@RequestBody Vendor vendor) {
		return machineService.getMachineListByVendorId(vendorService.findByVendorId(vendor.getVendorId()));
	}
}
