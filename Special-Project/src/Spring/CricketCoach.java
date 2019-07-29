package Spring;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	//create a no-arg constructor
	public CricketCoach() {
		//System.out.println("Cricket Coach: in no-arg constructor");
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		//System.out.println("Cricket Coach: in setter method: setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		//System.out.println("Cricket Coach: in setter method: setTeam");
		this.team = team;
	}

	//our setter method
	public void setFortuneService(FortuneService fortuneService) {
		//System.out.println("Cricket Coach: in setter method setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Cricket Coach tell you work out";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
