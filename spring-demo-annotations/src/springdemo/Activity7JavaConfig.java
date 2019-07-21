package springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
public class Activity7JavaConfig {
	
	// define bean for service
	@Bean
	public FortuneService activity7FortuneService() {
		return new Activity7FortuneService();
	}
	
	
	// define bean for Coach
	@Bean
	public Coach activity7Coach() {
		return new Activity7Coach(activity7FortuneService());
	}
}




