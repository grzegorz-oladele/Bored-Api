package pl.grzegorz.boredapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@EnableAsync
@SpringBootApplication
public class BoredApiApplication {
	//Bardzo ładnie napisany kod, dobrze popakietowany, dobre użycie wzorców projektówych.
	public static void main(String[] args) {
		SpringApplication.run(BoredApiApplication.class, args);
	}

	//FIXME is this needed?
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
