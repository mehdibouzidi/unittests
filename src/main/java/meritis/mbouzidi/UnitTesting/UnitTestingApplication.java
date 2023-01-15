package meritis.mbouzidi.UnitTesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnitTestingApplication {

	public static void main(String[] args) {
		System.out.println("Hello Tests");
		SpringApplication.run(UnitTestingApplication.class, args);
	}

}
