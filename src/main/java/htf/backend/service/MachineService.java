package htf.backend.service;

import java.util.List;

import htf.backend.domain.Machine;

public interface MachineService {
	Machine getMachine(Machine machine);

	List<Machine> getMachineList(Machine machine);

	void insertMachine(Machine machine);

	void updateMachine(Machine machine);

	void deleteMachine(Machine machine);
}
