package htf.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import htf.backend.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByMemId(String memId);
}
