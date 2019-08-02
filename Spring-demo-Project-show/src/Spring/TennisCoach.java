package Spring;

public class TennisCoach implements Coach{
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
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
	
}
