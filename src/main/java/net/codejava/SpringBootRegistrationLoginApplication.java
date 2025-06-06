package net.codejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "net.codejava")
@EntityScan(basePackages = "net.codejava")
public class SpringBootRegistrationLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRegistrationLoginApplication.class, args);
	}

}
