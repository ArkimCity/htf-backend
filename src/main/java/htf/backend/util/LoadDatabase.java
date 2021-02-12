package htf.backend.util;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import htf.backend.dao.AdminRepository;
import htf.backend.dao.MachineRepository;
import htf.backend.dao.MeasureRepository;
import htf.backend.dao.MemberRepository;
import htf.backend.dao.VendorRepository;
import htf.backend.domain.Admin;
import htf.backend.domain.Machine;
import htf.backend.domain.Measure;
import htf.backend.domain.Member;
import htf.backend.domain.Vendor;

@Aspect
@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase1(AdminRepository adminRepository, VendorRepository vendorRespository, MemberRepository meberRepository, MachineRepository machineRepository, MeasureRepository measureRepository) {
		
		return args -> {
			log.info("Preloading " + adminRepository.save(new Admin("asd","sad",null)));
			log.info("Preloading " + adminRepository.save(new Admin("a2sd","sad",null)));
			
			log.info("Preloading " + vendorRespository.save(new Vendor("514684", "vpw")));
			
//			log.info("Preloading " + meberRepository.save(new Member(1L, "sh", "11", "silver", Timestamp.valueOf(LocalDateTime.now()), new Admin("a2sd","sad",null))));

			log.info("Preloading " + meberRepository.save(new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null))));
			log.info("Preloading " + meberRepository.save(new Member(2L, "om", "11", "silver", null, null, new Admin("asd","sad",null))));
			
			log.info("Preloading " + machineRepository.save(new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw"))));
			log.info("Preloading " + machineRepository.save(new Machine("7879awdd48", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light2",new Vendor("514684", "vpw"))));
			
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "20", String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "21", String.valueOf(System.currentTimeMillis()-1) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "22", String.valueOf(System.currentTimeMillis()-2) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "23", String.valueOf(System.currentTimeMillis()-3) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "24", String.valueOf(System.currentTimeMillis()-4) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "25", String.valueOf(System.currentTimeMillis()-5) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "26", String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "27", String.valueOf(System.currentTimeMillis()-1) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "28", String.valueOf(System.currentTimeMillis()-2) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "29", String.valueOf(System.currentTimeMillis()-3) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "30", String.valueOf(System.currentTimeMillis()-4) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "31", String.valueOf(System.currentTimeMillis()-5) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "32", String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "33", String.valueOf(System.currentTimeMillis()-1) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "34", String.valueOf(System.currentTimeMillis()-2) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "35", String.valueOf(System.currentTimeMillis()-3) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "36", String.valueOf(System.currentTimeMillis()-4) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", "37", String.valueOf(System.currentTimeMillis()-5) ,null)));
			
		};
	}
}