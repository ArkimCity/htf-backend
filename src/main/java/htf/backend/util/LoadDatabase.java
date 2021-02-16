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
			log.info("Preloading " + adminRepository.save(new Admin("a2sd","sad","21UGbv_hZKm4A10QAp99Yg31OJE_KjKg3yMDJgorDR4AAAF3n-gUjg")));
			log.info("Preloading " + adminRepository.save(new Admin("kju","kju","N-drt3L9K6WyfEjsh_3WHW4y9Z-1VmxeekMOhAopcBQAAAF3oAuBUQ")));
			
			log.info("Preloading " + vendorRespository.save(new Vendor("514684", "vpw")));
			
//			log.info("Preloading " + meberRepository.save(new Member(1L, "sh", "11", "silver", Timestamp.valueOf(LocalDateTime.now()), new Admin("a2sd","sad",null))));

			log.info("Preloading " + meberRepository.save(new Member(1L, "sh", "11", "silver", null, null, null, Admin.builder().adId("a2sd").build())));
			log.info("Preloading " + meberRepository.save(new Member(2L, "om", "11", "silver", null, null, null, Admin.builder().adId("asd").build())));
			log.info("Preloading " + meberRepository.save(new Member(3L, "ju", "11", "silver", null, null, null, Admin.builder().adId("a2sd").build())));
			
			log.info("Preloading " + machineRepository.save(new Machine("4561a65s1f", Member.builder().memKey(1L).build(), "TempSensor1","TempSensor", new Vendor("514684", "vpw"))));
			log.info("Preloading " + machineRepository.save(new Machine("7879awdd48", Member.builder().memKey(1L).build(), "TempSensor2","TempSensor", new Vendor("514684", "vpw"))));
			log.info("Preloading " + machineRepository.save(new Machine("1561sadsd5", Member.builder().memKey(1L).build(), "TempSensor3","TempSensor", new Vendor("514684", "vpw"))));

			log.info("Preloading " + machineRepository.save(new Machine("af1a561fas", Member.builder().memKey(2L).build(), "TempSensor11","TempSensor",new Vendor("514684", "vpw"))));
			log.info("Preloading " + machineRepository.save(new Machine("51a65f1afs", Member.builder().memKey(2L).build(), "TempSensor12","TempSensor",new Vendor("514684", "vpw"))));
			
			log.info("Preloading " + measureRepository.save(new Measure(1L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, null, new Admin("a2sd","sad",null)), "light1",null, new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(80), (System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(2L, new Machine("4561a65s1f", new Member(1L, "sh", "11", "silver", null, null, null, new Admin("a2sd","sad",null)), "light1",null, new Vendor("514684", "vpw")), "ligt", "Celcius", Double.valueOf(80), (System.currentTimeMillis()) ,null)));
			
		};
	}
}