package htf.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import htf.backend.dao.MemberRepository;
import htf.backend.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepo;

	public Member getMember(Member member) {
		Optional<Member> findMember = memberRepo.findById(member.getMem_key());
		if (findMember.isPresent()) {
			return findMember.get();
		} else {
			return null;
		}
	}

	public List<Member> getMemberList(Member member) {
		return (List<Member>) memberRepo.findAll();
	}

	public void insertMember(Member member) {
		memberRepo.save(member);
	}

	public void updateMember(Member member) {
		Member findMember = memberRepo.findById(member.getMem_key()).get();
		findMember.setMemPw(member.getMemPw());
		memberRepo.save(findMember);
	}

	public void deleteMember(Member member) {
		memberRepo.deleteById(member.getMem_key());
	}

	@Override
	public Member signIn(String id, String pw) {
		Member member = memberRepo.findByMemId(id);
//		Objects.requireNonNull(member, SIGNIN_EXCEPTION_MSG);
//		
//		if (!this.isAccordPassword(member, password)) {
//			throw new IllegalStateException(SIGNIN_EXCEPTION_MSG);
//		}
		return member;
	}
}
