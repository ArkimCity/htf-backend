package htf.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import htf.backend.dao.MachineRepository;
import htf.backend.domain.Machine;
import htf.backend.domain.Member;

@Service
public class MachineServiceImpl implements MachineService {
	
	@Autowired
	private MachineRepository machineRepo;

	public Machine getMachine(Machine machine) {
		Optional<Machine> findMachine = machineRepo.findById(machine.getMchId());
		if (findMachine.isPresent()) {
			return findMachine.get();
		}else {
			return null;
		}
	}

	public List<Machine> getMachineList(Machine machine) {
		return (List<Machine>) machineRepo.findAll();
	}

	public void insertMachine(Machine machine) {
		machineRepo.save(machine);
	}

	public void updateMachine(Machine machine) {
		Machine findMachine = machineRepo.findById(machine.getMchId()).get();
		findMachine.setDescription(machine.getDescription());
		machineRepo.save(findMachine);
	}

	public void deleteMachine(Machine machine) {
		machineRepo.deleteById(machine.getMchId());
	}

	public List<Machine> getMachineListByMemId(Member memId) {
		return machineRepo.getMachineListByMemId(memId);
	}

	public Machine findByMchId(String mchId) {
		return machineRepo.findByMchId(mchId);
	}

}
