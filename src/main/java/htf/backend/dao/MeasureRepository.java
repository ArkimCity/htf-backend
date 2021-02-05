package htf.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import htf.backend.domain.Admin;
import htf.backend.domain.Machine;
import htf.backend.domain.Measure;

public interface MeasureRepository extends JpaRepository<Measure, Long> {

}
