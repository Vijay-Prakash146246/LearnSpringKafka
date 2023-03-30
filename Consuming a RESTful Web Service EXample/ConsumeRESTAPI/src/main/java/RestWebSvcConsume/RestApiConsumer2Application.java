package RestWebSvcConsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class RestApiConsumer2Application {

	public static void main(String[] args)
	{
		//SpringApplication.run(RestApiConsumer2Application.class, args);
		SpringApplication app = new SpringApplication(RestApiConsumer2Application.class);
		app.setDefaultProperties(Collections.singletonMap("spring.config.name", "application-second"));
		app.run(args);
	}

}
