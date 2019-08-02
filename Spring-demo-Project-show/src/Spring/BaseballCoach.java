package Spring;

public class BaseballCoach implements Coach{
	
	// define a private field for the dependency
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	@Override
	public String getDailyWorkout() {
		return "Baseball coach tell you spend 30 minnutes review";
	}

	@Override
	public String getDailyFortune() {
		//use my fortuneService to get a fortune
		return fortuneService.getFortune();
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
