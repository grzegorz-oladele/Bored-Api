package pl.grzegorz.boredapi;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled
class BoredApiApplicationTests {

	@Test
	void contextLoads() {
	}

	public static void main(String[] args) {
		RestAssured.config();
	}

}
