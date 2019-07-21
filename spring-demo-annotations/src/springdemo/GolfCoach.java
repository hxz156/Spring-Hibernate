package springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GolfCoach implements Coach {
	@Autowired
	@Qualifier("activityFiveFortuneService")
	private FortuneService fortuneService;
	
	public GolfCoach() {
		System.out.println("golfCoach class, defaul method");
	}
	@Override
	public String getDailyWorkout() {
		return "GolfCoach tell you workout";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
