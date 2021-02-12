package htf.backend.service;

import java.util.List;

import htf.backend.domain.Machine;
import htf.backend.domain.Member;
import htf.backend.domain.Vendor;

public interface MachineService {
	
	Machine getMachine(Machine machine);
	
	Machine findByMchId(String mchId);
	
	List<Machine> getMachineList(Machine machine);

	List<Machine> getMachineListByMemId(Member memId);
	
	List<Machine> getMachineListByVendorId(Vendor vendorId);

	void insertMachine(Machine machine);

	void updateMachine(Machine machine);

	void deleteMachine(Machine machine);
}
