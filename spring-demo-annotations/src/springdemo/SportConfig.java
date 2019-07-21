package springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	// define sad fortuneService
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define swim coach
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
