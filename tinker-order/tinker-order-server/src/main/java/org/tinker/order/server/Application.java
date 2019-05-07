package org.tinker.order.server;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath:/spring-dubbo.xml")
@Service
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
