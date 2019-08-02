package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo_9 {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Remember that Human is just another typpe of Animal");
			
			// add some reviews
			tempCourse.addReview(new Review("Forget the negative situation!"));
			tempCourse.addReview(new Review("Face your failure is not hard!"));
			tempCourse.addReview(new Review("You don't have to prove yourself to anyone!"));
			
			// save the course ... and leverage the cascade all 
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			// add clean up code
			session.close();
			factory.close();
		}
		
	}

}
