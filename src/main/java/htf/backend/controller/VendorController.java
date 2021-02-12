package htf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.domain.Vendor;
import htf.backend.service.VendorService;

@CrossOrigin
@RestController
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@ModelAttribute("vendor")
	public Vendor setVendor() {
		return new Vendor();
	}

//	@RequestMapping("/getVendorList")
//	public List<Vendor> getVendorList(@ModelAttribute("vendor") Vendor vendor, Model model) {
//		if (vendor.getVendorId() == null) {//?
//		}
//		List<Vendor> vendorList = vendorService.getVendorList(vendor);
//		System.out.println(vendorList);
//		model.addAttribute("vendorList", vendorList);
//		return vendorList;
//	}

	@PostMapping("/insertVendor")
	public String insertVendor(@RequestBody Vendor vendor) {
		if (vendor.getVendorId() == null) {
			return "redirect:login";
		}
		vendorService.insertVendor(vendor);
		return "insertVendor";
	}
//
//	@GetMapping("/getVendor")
//	public String getVendor(@ModelAttribute("vendor")Vendor vendor, Model model) {
//		if (vendor.getVendorId() == null) {
//			return "redirect:login";
//		}
//		model.addAttribute("vendor", vendorService.getVendor(vendor));
//		return "getVendor";
//	}

//	@PostMapping("/updateVendor")
//	public String updateVendor(@ModelAttribute("vendor") Vendor vendor) {
//		if (vendor.getVendorId() == null) {
//			return "redirect:login";
//		}
//		vendorService.updateVendor(vendor);
//		return "getVendorList";
//	}

//	@GetMapping("/deleteVendor")
//	public String deleteVendor(@ModelAttribute("vendor") Vendor vendor) {
//		if (vendor.getVendorId() == null) {
//			return "redirect:login";
//		}
//		vendorService.deleteVendor(vendor);
//		return "getVendorList";
//	}
}
