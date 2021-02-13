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

import htf.backend.domain.Admin;
import htf.backend.domain.Admin;
import htf.backend.service.AdminService;

@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@ModelAttribute("admin")
	public Admin setAdmin() {
		return new Admin();
	}

//	@RequestMapping("/getAdminList")
//	public List<Admin> getAdminList(@ModelAttribute("admin") Admin admin, Model model) {
//		if (admin.getAdId() == null) {//?
//		}
//		List<Admin> adminList = adminService.getAdminList(admin);
//		System.out.println(adminList);
//		model.addAttribute("adminList", adminList);
//		return adminList;
//	}

	@PostMapping("/insertAdmin")
	public String insertAdmin(@RequestBody Admin admin) {
		if (admin.getAdId() == null) {
			return "redirect:login";
		}
		adminService.insertAdmin(admin);
		return "insertAdmin";
	}
	
	@PostMapping("/updateAdminToken")
	public void updateAdminToken(@RequestBody Admin admin) {
		Admin updateAdmin = adminService.findByAdId(admin.getAdId());
		updateAdmin.setKakaoToken(admin.getKakaoToken());
		adminService.updateAdmin(updateAdmin);
	}
//
//	@GetMapping("/getAdmin")
//	public String getAdmin(@ModelAttribute("admin")Admin admin, Model model) {
//		if (admin.getAdId() == null) {
//			return "redirect:login";
//		}
//		model.addAttribute("admin", adminService.getAdmin(admin));
//		return "getAdmin";
//	}

//	@PostMapping("/updateAdmin")
//	public String updateAdmin(@ModelAttribute("admin") Admin admin) {
//		if (admin.getAdId() == null) {
//			return "redirect:login";
//		}
//		adminService.updateAdmin(admin);
//		return "getAdminList";
//	}

//	@GetMapping("/deleteAdmin")
//	public String deleteAdmin(@ModelAttribute("admin") Admin admin) {
//		if (admin.getAdId() == null) {
//			return "redirect:login";
//		}
//		adminService.deleteAdmin(admin);
//		return "getAdminList";
//	}
}
