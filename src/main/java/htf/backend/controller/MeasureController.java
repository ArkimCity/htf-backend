package htf.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@CrossOrigin
	public List<Measure> getMeasureListByMchId(@RequestBody Machine machine){
		return measureService.getMeasureListByMchId(machineService.findByMchId(machine.getMchId()));
	}
}
