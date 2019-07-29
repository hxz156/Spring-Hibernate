package springdemo;
import java.util.Random;

public class randomFortuneService implements FortuneService {
	
	private String[]array3 = {
			"Monday","Tuesday","Wensday"
	};
	private Random myRandom = new Random();
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(array3.length);
		return array3[index];
	}

}
