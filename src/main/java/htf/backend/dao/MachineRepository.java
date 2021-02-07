package htf.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import htf.backend.domain.Machine;
import htf.backend.domain.Member;

public interface MachineRepository extends JpaRepository<Machine, String> {
	List<Machine> getMachineListByMemId(Member memId);
	Machine findByMchId(String mchId);
}
