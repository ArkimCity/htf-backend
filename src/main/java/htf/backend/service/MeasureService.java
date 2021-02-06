package htf.backend.service;

import java.util.List;

import htf.backend.domain.Measure;

public interface MeasureService {
	Measure getMeasure(Measure measure);

	List<Measure> getMeasureList(Measure measure);
}
