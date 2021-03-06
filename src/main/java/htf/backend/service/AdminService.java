package htf.backend.service;

import java.util.List;

import htf.backend.domain.Admin;

public interface AdminService {

	Admin getAdmin(Admin admin);
	
	Admin signIn(String id, String pw);
	
	Admin findByAdId(String adId);
	
	List<Admin> getAdminList(Admin admin);
	
	void insertAdmin(Admin admin);

	void updateAdmin(Admin admin);

	void updateAdminToken(Admin admin);

	void deleteAdmin(Admin admin);

}