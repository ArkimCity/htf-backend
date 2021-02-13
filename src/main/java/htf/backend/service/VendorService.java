package htf.backend.service;

import java.util.List;

import htf.backend.domain.Vendor;

public interface VendorService {

	Vendor getVendor(Vendor vendor);
	
	Vendor signIn(String id, String pw);
	
	Vendor findByVendorId(String vendorId);
	
	List<Vendor> getVendorList();
	
	void insertVendor(Vendor vendor);

	void updateVendor(Vendor vendor);

	void deletVendor(Vendor vendor);

}