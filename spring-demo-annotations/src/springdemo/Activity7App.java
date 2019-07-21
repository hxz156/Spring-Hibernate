package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Activity7App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(Activity7JavaConfig.class);
		Activity7Coach myCoach = context.getBean("activity7Coach",Activity7Coach.class);
		
		System.out.println("7 fortune is: "+ myCoach.getDailyFortune());
		System.out.println("7 workout is: "+ myCoach.getDailyWorkout());
		
		context.close();

	}

}
