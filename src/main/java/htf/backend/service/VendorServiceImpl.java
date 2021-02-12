package htf.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import htf.backend.dao.VendorRepository;
import htf.backend.domain.Vendor;

@Service
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	private VendorRepository vendorRepo;

	public Vendor getVendor(Vendor vendor) {
		Optional<Vendor> findVendor = vendorRepo.findById(vendor.getVendorId());
		if (findVendor.isPresent()) {
			return findVendor.get();
		}else {
			return null;
		}
	}

	public List<Vendor> getVendorList(Vendor vendor) {
		return (List<Vendor>) vendorRepo.findAll();
	}

	public void insertVendor(Vendor vendor) {
		vendorRepo.save(vendor);
	}

	public void updateVendor(Vendor vendor) {
		Vendor findVendor = vendorRepo.findById(vendor.getVendorId()).get();
		findVendor.setVendorPw(vendor.getVendorPw());
		vendorRepo.save(findVendor);
	}

	public void deleteVendor(Vendor vendor) {
		vendorRepo.deleteById(vendor.getVendorId());
	}

	@Override
	public Vendor signIn(String id, String pw) {
		Vendor vendor = vendorRepo.findByVendorId(id);
		return vendor;
	}

	@Override
	public Vendor findByVendorId(String adId) {
		return vendorRepo.findByVendorId(adId);
	}

	@Override
	public List<Vendor> getVendorList() {
		return vendorRepo.findAll();
	}

	@Override
	public void deletVendor(Vendor vendor) {
		vendorRepo.deleteById(vendor.getVendorId());
		
	}

}
