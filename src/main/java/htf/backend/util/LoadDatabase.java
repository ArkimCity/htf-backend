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
			log.info("Preloading " + meberRepository.save(new Member(3L, "ju", "11", "silver", null, null, new Admin("a2sd","sad",null))));
			
			log.info("Preloading " + machineRepository.save(new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw"))));
			log.info("Preloading " + machineRepository.save(new Machine("7879awdd48", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light2",new Vendor("514684", "vpw"))));
			log.info("Preloading " + machineRepository.save(new Machine("1561sadsd5", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light3",new Vendor("514684", "vpw"))));
			log.info("Preloading " + machineRepository.save(new Machine("a25165fwaf", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light4",new Vendor("514684", "vpw"))));
			log.info("Preloading " + machineRepository.save(new Machine("561485a1fa", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light5",new Vendor("514684", "vpw"))));

			log.info("Preloading " + machineRepository.save(new Machine("165165daad", new Member(2L, "om", "11", "silver", null, null, new Admin("asd","sad",null)), "light1",new Vendor("514684", "vpw"))));
			log.info("Preloading " + machineRepository.save(new Machine("5614a65f1f", new Member(2L, "om", "11", "silver", null, null, new Admin("asd","sad",null)), "light2",new Vendor("514684", "vpw"))));
			log.info("Preloading " + machineRepository.save(new Machine("af1a561fas", new Member(2L, "om", "11", "silver", null, null, new Admin("asd","sad",null)), "light3",new Vendor("514684", "vpw"))));
			log.info("Preloading " + machineRepository.save(new Machine("51a65f1afs", new Member(2L, "om", "11", "silver", null, null, new Admin("asd","sad",null)), "light4",new Vendor("514684", "vpw"))));
			log.info("Preloading " + machineRepository.save(new Machine("84a9fasdas", new Member(2L, "om", "11", "silver", null, null, new Admin("asd","sad",null)), "light5",new Vendor("514684", "vpw"))));
			
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(23), String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(23), String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(23), String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(23), String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(23), String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(23), String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(23), String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(23), String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(23), String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(23), String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(23), String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(23), String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(23), String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(23), String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(23), String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(23), String.valueOf(System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, new Admin("a2sd","sad",null)), "light1",new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(80), String.valueOf(System.currentTimeMillis()) ,null)));
			
		};
	}
}