package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo_9 {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			
			System.out.println("debug Instructor: " + tempInstructor);
			System.out.println("debug Courses : " + tempInstructor.getCourses());
			
			
			// commit transaction
			session.getTransaction().commit();
			session.close();
			
			System.out.println("debug Courses : " + tempInstructor.getCourses());
			System.out.println("debug Done!");
			
		}
		finally {
			// add clean up code
			session.close();
			factory.close();
		}
		
	}

}
