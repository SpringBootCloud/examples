package net.boddin.clouddemo;

import net.boddin.clouddemo.auditing.AuditorAwareImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class CloudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudDemoApplication.class, args);
	}

}
