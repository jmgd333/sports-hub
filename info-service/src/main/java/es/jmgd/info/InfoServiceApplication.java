package es.jmgd.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class InfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoServiceApplication.class, args);
	}

}
