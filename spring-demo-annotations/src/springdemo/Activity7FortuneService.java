package springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Activity7FortuneService implements FortuneService {
	@Value("${foo.email}")
	private String fortune;
	
	@Override
	public String getFortune() {
		return "activity7 fortune service: "+fortune;
	}

}
