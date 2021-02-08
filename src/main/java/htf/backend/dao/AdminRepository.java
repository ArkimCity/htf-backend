package htf.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import htf.backend.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	Admin findByAdId(String adId);
}
