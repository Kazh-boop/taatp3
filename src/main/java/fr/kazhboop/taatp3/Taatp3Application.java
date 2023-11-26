package fr.kazhboop.taatp3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("fr.kazhboop.taatp3.domain")
public class Taatp3Application {

	public static void main(String[] args) {
		SpringApplication.run(Taatp3Application.class, args);
	}

}
