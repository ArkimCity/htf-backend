package htf.backend.service;

import java.util.List;

import htf.backend.domain.Machine;
import htf.backend.domain.Measure;

public interface MeasureService {
	Measure getMeasure(Measure measure);

	List<Measure> getMeasureList(Measure measure);
	
	List<Measure> getMeasureListByMchId(Machine mchId);
	
	List<Measure> getTempMeasureListByMchIdTo10(Machine mchId);
	
	Measure getTempMeasureByMchIdTo1(String mchId);
	
	List<Measure> getHumidMeasureListByMchIdTo10(Machine mchId);
	
	Measure getHumidMeasureByMchIdTo1(String mchId);
	
	List<Measure> getDustMeasureListByMchIdTo10(Machine mchId);
	
	Measure getDustMeasureByMchIdTo1(String mchId);

	void deleteByMchId(Machine mchId);
}
