package htf.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import htf.backend.domain.Machine;
import htf.backend.domain.Measure;

public interface MeasureRepository extends JpaRepository<Measure, Long> {
	List<Measure> getMeasureListByMchId(Machine mchId);
	void deleteByMchId(Machine mchId);

	@Query(nativeQuery=true, value="select * from (select * from measure where mch_id = ?1 and param='Celcius' order by measure_id desc) where rownum<=10")
	List<Measure> getTempMeasureListByMchIdTo10(Machine mchId);
	@Query(nativeQuery=true, value="select * from (select * from measure where mch_id = ?1 and param='Celcius' order by measure_id desc) where rownum=1")
	Measure getTempMeasureByMchIdTo1(String mchId);
	
	@Query(nativeQuery=true, value="select * from (select * from measure where mch_id = ?1 and param='Percentage' order by measure_id desc) where rownum<=10")
	List<Measure> getHumidMeasureListByMchIdTo10(Machine mchId);
	@Query(nativeQuery=true, value="select * from (select * from measure where mch_id = ?1 and param='Percentage' order by measure_id desc) where rownum=1")
	Measure getHumidMeasureByMchIdTo1(String mchId);
	
	@Query(nativeQuery=true, value="select * from (select * from measure where mch_id = ?1 and param='PM' order by measure_id desc) where rownum<=10")
	List<Measure> getDustMeasureListByMchIdTo10(Machine mchId);
	@Query(nativeQuery=true, value="select * from (select * from measure where mch_id = ?1 and param='PM' order by measure_id desc) where rownum=1")
	Measure getDustMeasureByMchIdTo1(String mchId);
}
