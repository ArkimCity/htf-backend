package htf.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import htf.backend.dao.AdminRepository;
import htf.backend.domain.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepo;

	public Admin getAdmin(Admin admin) {
		Optional<Admin> findAdmin = adminRepo.findById(admin.getAdId());
		if (findAdmin.isPresent()) {
			return findAdmin.get();
		}else {
			return null;
		}
	}

	public List<Admin> getAdminList(Admin admin) {
		return (List<Admin>) adminRepo.findAll();
	}

	public void insertAdmin(Admin admin) {
		adminRepo.save(admin);
	}

	public void updateAdmin(Admin admin) {
		Admin findAdmin = adminRepo.findById(admin.getAdId()).get();
		findAdmin.setAdPw(admin.getAdPw());
		adminRepo.save(findAdmin);
	}

	public void deleteAdmin(Admin admin) {
		adminRepo.deleteById(admin.getAdId());
	}

	@Override
	public Admin signIn(String id, String pw) {
		Admin admin = adminRepo.findByAdId(id);
		return admin;
	}

	@Override
	public Admin findByAdId(String adId) {
		return adminRepo.findByAdId(adId);
	}

}
