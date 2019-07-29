package springdemo;

public class TennisCoach implements Coach{
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "This is TennisCoach tell you practice back hand.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
}
