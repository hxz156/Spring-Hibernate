package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationcontext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//check if they are the same
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("they are the same ? " + result);
		System.out.println("mem location for theCoach: "+ theCoach);
		System.out.println("mem location for alphaCoach: "+ alphaCoach);
		
		//close context
		context.close();
	}

}
