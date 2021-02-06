package htf.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import htf.backend.domain.Machine;

public interface MachineRepository extends JpaRepository<Machine, String> {

}
