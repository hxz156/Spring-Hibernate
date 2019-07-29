package springdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	
	public TrackCoach() {}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Track coach tell you run 1 hours";
	}

	@Override
	public String getDailyFortune() {
		return "Track coach tell you" +  fortuneService.getFortune();
	}
	
	// add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach class doMyStartupStuff method");
	}
	
	// add a destroy method
	public void doMyCleanStuff() {
		System.out.println("TrackCoach class doMyCleanStuff method");
	}
}






