package htf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.domain.Admin;
import htf.backend.service.AdminService;
import htf.backend.service.JWTService;

@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private JWTService jwtService;
	
	@ModelAttribute("admin")
	public Admin setAdmin() {
		return new Admin();
	}

	@PostMapping("/insertAdmin")
	public String insertAdmin(@RequestBody Admin admin) throws Exception {
		if (admin.getAdId() == null) {
			return "redirect:login";
		}
		adminService.insertAdmin(admin);
		
    	String response = null;
        try {
    		String token = jwtService.create(admin.getAdId(), admin, "admin");
    		response = token;
        } catch(Exception e) {
        	throw new Exception();
        }
		return response;
	}
	
	@PostMapping("/updateAdminToken")
	public void updateAdminToken(@RequestBody Admin admin) {
		Admin updateAdmin = adminService.findByAdId(admin.getAdId());
		updateAdmin.setKakaoToken(admin.getKakaoToken());
		System.out.println(updateAdmin);
		adminService.updateAdminToken(updateAdmin);
	}
}
