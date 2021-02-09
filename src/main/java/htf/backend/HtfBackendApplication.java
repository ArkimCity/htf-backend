package htf.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScans({@ComponentScan("htf.backend.controller"),
				@ComponentScan("htf.backend.logger")})
@EnableJpaRepositories(basePackages="htf.backend.dao")
@EntityScan("htf.backend.domain")
@SpringBootApplication
public class HtfBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtfBackendApplication.class, args);
	}

}
