package htf.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import htf.backend.domain.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, String> {

	Vendor findByVendorId(String vendorId);
}
