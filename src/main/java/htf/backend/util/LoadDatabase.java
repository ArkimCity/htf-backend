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
			log.info("Preloading " + adminRepository.save(new Admin("admin1","11",null)));
			log.info("Preloading " + adminRepository.save(new Admin("admin2","sad","21UGbv_hZKm4A10QAp99Yg31OJE_KjKg3yMDJgorDR4AAAF3n-gUjg")));
			
			log.info("Preloading " + vendorRespository.save(new Vendor("vendor1", "11")));
			
			log.info("Preloading " + meberRepository.save(new Member(1L, "sh", "11", "enterprise", "sh@test.com", "101동 101호", "010-1234-5678", null, null, Admin.builder().adId("admin1").build())));
			log.info("Preloading " + meberRepository.save(new Member(2L, "om", "11", "pro", "om@test.com", "101동 102호", "010-8765-4321", "kakaoTokenPosition", "kakaoSidPosition", Admin.builder().adId("admin2").build())));
			log.info("Preloading " + meberRepository.save(new Member(3L, "ju", "11", "basic",  "ju@test.com", "101동 103호", "010-1357-2468", null, null, Admin.builder().adId("admin1").build())));
			
			log.info("Preloading " + machineRepository.save(new Machine("4561a65s1f", Member.builder().memKey(1L).build(), "TempHumidSensor1","TempHumidSensor", new Vendor("vendor1", "11"))));
			log.info("Preloading " + machineRepository.save(new Machine("7879awdd48", Member.builder().memKey(1L).build(), "TempSensor2","TempSensor", new Vendor("vendor1", "11"))));
			log.info("Preloading " + machineRepository.save(new Machine("1561sadsd5", Member.builder().memKey(1L).build(), "TempSensor3","TempSensor", new Vendor("vendor1", "11"))));
			
			log.info("Preloading " + machineRepository.save(new Machine("adsd5ad8sd", Member.builder().memKey(1L).build(), "DustSensor1","DustSensor", new Vendor("vendor1", "11"))));

			log.info("Preloading " + machineRepository.save(new Machine("af1a561fas", Member.builder().memKey(2L).build(), "TempSensor11","TempSensor",new Vendor("vendor1", "11"))));
			log.info("Preloading " + machineRepository.save(new Machine("51a65f1afs", Member.builder().memKey(2L).build(), "TempSensor12","TempSensor",new Vendor("vendor1", "11"))));
			
			log.info("Preloading " + measureRepository.save(new Measure(1L, Machine.builder().mchId("4561a65s1f").build(), "DHT11", "Celcius", Double.valueOf(80), (System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(2L, Machine.builder().mchId("4561a65s1f").build(), "DHT11", "Percentage", Double.valueOf(80), (System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(3L, Machine.builder().mchId("adsd5ad8sd").build(), "PM2008", "PM10micrometer", Double.valueOf(40), (System.currentTimeMillis()) ,null)));
			log.info("Preloading " + measureRepository.save(new Measure(4L, Machine.builder().mchId("adsd5ad8sd").build(), "PM2008", "PM2.5micrometer", Double.valueOf(25), (System.currentTimeMillis()) ,null)));
			
		};
	}
}