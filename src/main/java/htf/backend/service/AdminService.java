package htf.backend.service;

import java.util.List;

import htf.backend.domain.Admin;

public interface AdminService {

	Admin getAdmin(Admin admin);
	
	List<Admin> getAdminList(Admin admin);
	
	void insertAdmin(Admin admin);

	void updateAdmin(Admin admin);

	void deleteAdmin(Admin admin);

}