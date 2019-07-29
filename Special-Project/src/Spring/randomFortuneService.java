package Spring;
import java.util.Random;

public class randomFortuneService implements FortuneService {
	
	private String[]array3 = {
			"1000 dollar", "A new car", "A new house"
	};
	private Random myRandom = new Random();
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(array3.length);
		return "Random fortune is: " + array3[index];
	}

}
