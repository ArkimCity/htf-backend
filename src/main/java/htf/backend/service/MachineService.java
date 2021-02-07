package htf.backend.service;

import java.util.List;

import htf.backend.domain.Machine;
import htf.backend.domain.Member;

public interface MachineService {
	
	Machine getMachine(Machine machine);
	
	List<Machine> getMachineList(Machine machine);

	List<Machine> getMachineListByMemId(Member memId);

	void insertMachine(Machine machine);

	void updateMachine(Machine machine);

	void deleteMachine(Machine machine);
}
