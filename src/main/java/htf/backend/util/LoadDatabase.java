package htf.backend.util;


import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import htf.backend.dao.AdminRepository;
import htf.backend.dao.MemberRepository;
import htf.backend.domain.Admin;
import htf.backend.domain.Member;

@Aspect
@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase1(AdminRepository adminRepository) {
		
		return args -> {
			log.info("Preloading " + adminRepository.save(new Admin("asd","sad")));
			log.info("Preloading " + adminRepository.save(new Admin("a2sd","sad")));
			
		};
	}
	@Bean
	CommandLineRunner initDatabase2(MemberRepository meberRepository) {
 
		return args -> {
			log.info("Preloading " + meberRepository.save(new Member(11L, "sh", "11", "silver", new Admin("a2sd","sad"))));
			log.info("Preloading " + meberRepository.save(new Member(11L, "sh", "11", "silver", new Admin("a2sd","sad"))));
			log.info("Preloading " + meberRepository.save(new Member(12L, "om", "11", "silver", new Admin("asd","sad"))));
			
		};
	}
}