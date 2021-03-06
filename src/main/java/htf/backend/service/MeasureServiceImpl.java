package htf.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import htf.backend.dao.MeasureRepository;
import htf.backend.domain.Machine;
import htf.backend.domain.Measure;

@Service
public class MeasureServiceImpl implements MeasureService {
	
	@Autowired
	private MeasureRepository measureRepo;
	
	public Measure getMeasure(Measure measure) {
		Optional<Measure> findMeasure = measureRepo.findById(measure.getMeasureId());
		if (findMeasure.isPresent()) {
			return findMeasure.get();
		}else {
			return null;
		}
	}
	
	public void deleteByMchId(Machine mchId) {
		measureRepo.deleteByMchId(mchId);
	}
	
	public List<Measure> getMeasureList(Measure measure) {
		return (List<Measure>) measureRepo.findAll();
	}

	@Override
	public List<Measure> getMeasureListByMchId(Machine mchId) {
		return measureRepo.getMeasureListByMchId(mchId);
	}

	@Override
	public List<Measure> getTempMeasureListByMchIdTo10(Machine mchId) {
		return measureRepo.getTempMeasureListByMchIdTo10(mchId);
	}

	@Override
	public Measure getTempMeasureByMchIdTo1(String mchId) {
		return measureRepo.getTempMeasureByMchIdTo1(mchId);
	}
	
	@Override
	public List<Measure> getHumidMeasureListByMchIdTo10(Machine mchId) {
		return measureRepo.getHumidMeasureListByMchIdTo10(mchId);
	}
	
	@Override
	public Measure getHumidMeasureByMchIdTo1(String mchId) {
		return measureRepo.getHumidMeasureByMchIdTo1(mchId);
	}
	
	@Override
	public List<Measure> getDustMeasureListByMchIdTo10(Machine mchId) {
		return measureRepo.getDustMeasureListByMchIdTo10(mchId);
	}
	
	@Override
	public Measure getDustMeasureByMchIdTo1(String mchId) {
		return measureRepo.getDustMeasureByMchIdTo1(mchId);
	}
	
	@Override
	public List<Measure> getDustTenMeasureListByMchIdTo10(Machine mchId) {
		return measureRepo.getDustTenMeasureListByMchIdTo10(mchId);
	}
	
	@Override
	public Measure getDustTenMeasureListByMchIdTo1(String mchId) {
		return measureRepo.getDustTenMeasureListByMchIdTo1(mchId);
	}

}
