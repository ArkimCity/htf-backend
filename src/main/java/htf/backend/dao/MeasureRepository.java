package htf.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import htf.backend.domain.Machine;
import htf.backend.domain.Measure;

public interface MeasureRepository extends JpaRepository<Measure, Long> {
	List<Measure> getMeasureListByMchId(Machine mchId);

	@Query("select m from Measure m where rownum<11 order by m.created desc")
	List<Measure> getMeasureListByMchIdTo10(Machine mchId);
	@Query("select m from Measure m where rownum=1 order by m.created desc")
	Measure getMeasureByMchIdTo1(Machine mchId);
}
