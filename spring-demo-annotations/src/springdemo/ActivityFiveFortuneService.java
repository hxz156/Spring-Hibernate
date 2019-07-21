package springdemo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class ActivityFiveFortuneService implements FortuneService {

	private String fileName = "src/fortune-data.txt";
	private List<String> theFortunes;
	Random myRandom = new Random();
	
	public ActivityFiveFortuneService() {
		File theFile = new File(fileName);
		System.out.println("Reading fortunes from file: " + theFile);
		System.out.println("File exists: " + theFile.exists());
		theFortunes = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(
				new FileReader(theFile))) {
			String tempLine;
			while ((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// before destroy
	@PreDestroy
	public void doMyCleanupStuff() {
		int index=myRandom.nextInt(theFortunes.size());
		System.out.println("activityFive class, CleanUp() method "+ theFortunes.get(index));
	}
	
	@Override
	public String getFortune() {
		int index=myRandom.nextInt(theFortunes.size());
		return theFortunes.get(index);
	}
}







