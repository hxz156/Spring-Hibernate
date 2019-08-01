package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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
			
			// create the objects
			Instructor tempInstructor = 
					new Instructor("Anthony", "Davis", "@Davis.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"Lakers now", "Pelicans");
			
			// associate the objects
			tempInstructor.setInstructor_detail_id(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			// ** this will also save the details object because of CascadeType.ALL
			// ** save two seperate tables inthe same time
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
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
