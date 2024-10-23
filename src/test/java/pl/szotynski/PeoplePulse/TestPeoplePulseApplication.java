package pl.szotynski.PeoplePulse;

import org.springframework.boot.SpringApplication;

public class TestPeoplePulseApplication {

	public static void main(String[] args) {
		SpringApplication.from(PeoplePulseApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
