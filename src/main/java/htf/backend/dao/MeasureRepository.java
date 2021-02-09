package htf.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import htf.backend.domain.Machine;
import htf.backend.domain.Measure;

public interface MeasureRepository extends JpaRepository<Measure, Long> {
	List<Measure> getMeasureListByMchId(Machine mchId);

	@Query(nativeQuery=true, value="select * from (select * from measure where mch_id = ?1 order by measure_id desc) where rownum<=10")
	List<Measure> getMeasureListByMchIdTo10(Machine mchId);
	@Query(nativeQuery=true, value="select * from (select * from measure where mch_id = ?1 order by measure_id desc) where rownum=1")
	Measure getMeasureByMchIdTo1(String mchId);
	@Query(nativeQuery=true, value="select * from measure where value>50 and param='Celcius'")
	List<Measure> getDangerousTemparatureMeasure();
}
