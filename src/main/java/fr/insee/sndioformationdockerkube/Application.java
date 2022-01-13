package fr.insee.sndioformationdockerkube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Run as War application
	 * https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto.traditional-deployment.war
	 * @param application
	 * @return
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}
