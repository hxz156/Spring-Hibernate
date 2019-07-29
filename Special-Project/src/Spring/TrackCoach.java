package Spring;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	public TrackCoach() {}

	@Override
	public String getDailyWorkout() {
		return "Track coach tell you run 1 hours";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	// add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach class doMyStartupStuff method");
	}
	
	// add a destroy method
	public void doMyCleanStuff() {
		System.out.println("TrackCoach class doMyCleanStuff method");
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
}






