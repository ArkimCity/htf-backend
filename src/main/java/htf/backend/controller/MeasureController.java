package htf.backend.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import htf.backend.domain.Machine;
import htf.backend.domain.Measure;
import htf.backend.service.Crawler;
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
	
	@PostMapping("/getTempMeasureListByMchIdTo10")
	public List<Measure> getTempMeasureListByMchIdTo10(@RequestBody Machine machine){
		return measureService.getTempMeasureListByMchIdTo10(machineService.findByMchId(machine.getMchId()));
	}
	
	@PostMapping("/getTempMeasureListByMchIdTo1")
	public Measure getTempMeasureListByMchIdTo1(@RequestBody Machine machine){
		return measureService.getTempMeasureByMchIdTo1((machine.getMchId()));
	}
	
	@PostMapping("/getHumidMeasureListByMchIdTo10")
	public List<Measure> getHumidMeasureListByMchIdTo10(@RequestBody Machine machine){
		return measureService.getHumidMeasureListByMchIdTo10(machineService.findByMchId(machine.getMchId()));
	}
	
	@PostMapping("/getHumidMeasureListByMchIdTo1")
	public Measure getHumidMeasureListByMchIdTo1(@RequestBody Machine machine){
		return measureService.getHumidMeasureByMchIdTo1((machine.getMchId()));
	}
	
	@PostMapping("/getDustMeasureListByMchIdTo10")
	public List<Measure> getDustMeasureListByMchIdTo10(@RequestBody Machine machine){
		return measureService.getDustMeasureListByMchIdTo10(machineService.findByMchId(machine.getMchId()));
	}
	
	@PostMapping("/getDustMeasureListByMchIdTo1")
	public Measure getDustMeasureListByMchIdTo1(@RequestBody Machine machine){
		return measureService.getDustMeasureByMchIdTo1((machine.getMchId()));
	}
	
	@PostMapping("/naverDust")
	public String naverDust() throws IOException {
		return Crawler.naverDustCrawler();
	}
	
	@GetMapping("/naverTempCrawler")
	public String naverTempCrawler() throws IOException {
		return Crawler.naverTempCrawler();
	}
	
	@GetMapping("/naverHumidtyCrawler")
	public String naverHumidtyCrawler() throws IOException {
		return Crawler.naverHumidtyCrawler();
	}
	
	@GetMapping("/deleteMeasurebyMchId")
	public void deleteMeasurebyMchId(Machine mchId) {
		measureService.deleteByMchId(mchId);
	}
}
