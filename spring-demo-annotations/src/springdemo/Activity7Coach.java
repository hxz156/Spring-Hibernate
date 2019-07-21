package springdemo;

import org.springframework.stereotype.Component;

@Component
public class Activity7Coach implements Coach {

	private FortuneService fortuneService;
	
	public Activity7Coach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "Activity7Coach class, getDailyWorkout()";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
