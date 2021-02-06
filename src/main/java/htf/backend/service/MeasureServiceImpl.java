package htf.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import htf.backend.dao.MeasureRepository;
import htf.backend.domain.Measure;

@Service
public class MeasureServiceImpl implements MeasureService {
	
	@Autowired
	private MeasureRepository measureRepo;
	
	public Measure getMeasure(Measure measure) {
		Optional<Measure> findMeasure = measureRepo.findById(measure.getMeasure_id());
		if (findMeasure.isPresent()) {
			return findMeasure.get();
		}else {
			return null;
		}
	}

	public List<Measure> getMeasureList(Measure measure) {
		return (List<Measure>) measureRepo.findAll();
	}


}
