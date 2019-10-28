package bex.packsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PacksServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacksServiceApplication.class, args);
	}

}
