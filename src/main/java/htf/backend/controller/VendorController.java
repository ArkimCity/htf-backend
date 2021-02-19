package htf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.domain.Machine;
import htf.backend.domain.Vendor;
import htf.backend.service.MachineService;
import htf.backend.service.VendorService;

@CrossOrigin
@RestController
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private MachineService machineService;
	
	@ModelAttribute("vendor")
	public Vendor setVendor() {
		return new Vendor();
	}

	@PostMapping("/insertVendor")
	public String insertVendor(@RequestBody Vendor vendor) {
		if (vendor.getVendorId() == null) {
			return "redirect:login";
		}
		vendorService.insertVendor(vendor);
		return "insertVendor";
	}
	
	
	@PostMapping("/deleteMachineByMchId")
	public String deleteMachine(@RequestBody Machine machine) {
		Machine deleteMachine = machineService.getMachine(machine);
		machineService.deleteMachine(deleteMachine);
		return "deleteMachine";
	}
}
