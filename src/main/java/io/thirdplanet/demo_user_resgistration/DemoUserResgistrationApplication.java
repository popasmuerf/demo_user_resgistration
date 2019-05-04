package io.thirdplanet.demo_user_resgistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class DemoUserResgistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoUserResgistrationApplication.class, args);
	}
}
