package htf.backend.service;

import java.util.List;

import htf.backend.domain.Admin;
import htf.backend.domain.Member;

public interface MemberService {

	Member getMember(Member member);
	
	Member signIn(String id, String pw);
	
	Member findByMemId(String memId);
	
	List<Member> getMemberList(Member member);

	void insertMember(Member member);

	void updateMember(Member member);

	void deleteMember(Member member);

	List<Member> getMemberListByAdId(Admin adId);

}