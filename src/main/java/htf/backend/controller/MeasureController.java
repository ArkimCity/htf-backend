package htf.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.domain.Machine;
import htf.backend.domain.Measure;
import htf.backend.service.MachineService;
import htf.backend.service.MeasureService;

@CrossOrigin
@RestController
public class MeasureController {

	@Autowired
	private MeasureService measureService;
	
	@Autowired
	private MachineService machineService;
	
	@PostMapping("/getMeasureListByMchId")
	public List<Measure> getMeasureListByMchId(@RequestBody Machine machine){
		return measureService.getMeasureListByMchId(machineService.findByMchId(machine.getMchId()));
	}
	
	@PostMapping("/getMeasureListByMchIdTo10")
	public List<Measure> getMeasureListByMchIdTo10(@RequestBody Machine machine){
		return measureService.getMeasureListByMchIdTo10(machineService.findByMchId(machine.getMchId()));
	}
	
	@PostMapping("/getMeasureListByMchIdTo1")
	public Measure getMeasureListByMchIdTo1(@RequestBody Machine machine){
		return measureService.getMeasureByMchIdTo1((machine.getMchId()));
	}
	
	@PostMapping("/tempCheck")
	public List<Measure> tempCheck(){
		System.out.println(measureService.getDangerousTemparatureMeasure());
		return measureService.getDangerousTemparatureMeasure();
	}
}
