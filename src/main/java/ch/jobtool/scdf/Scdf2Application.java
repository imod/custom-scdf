package ch.jobtool.scdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.cloud.common.security.CommonSecurityAutoConfiguration;
import org.springframework.cloud.dataflow.server.EnableDataFlowServer;

@SpringBootApplication(exclude = {
		SessionAutoConfiguration.class,
		CommonSecurityAutoConfiguration.class
})
@EnableDataFlowServer
public class Scdf2Application {

	public static void main(String[] args) {
		SpringApplication.run(Scdf2Application.class, args);
	}

}
