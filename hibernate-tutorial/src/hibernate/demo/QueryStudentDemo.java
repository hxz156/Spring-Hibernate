package hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			for(Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			
			//Student who have last name of Davis
			System.out.println("\n\n Student who have last name of Davis");
			theStudents = session.createQuery("from Student s where s.last_name='Davis'").getResultList();
			for(Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			
			// Student who have last name of Davis or josh
			System.out.println("\n\n Student who have last name of Davis or josh");
			theStudents = session.createQuery("from Student s where s.last_name='Davis' or s.last_name='josh'").getResultList();
			for(Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			
			// Student whose email end with email.com
			System.out.println("\n\n Student whose email end with email.com");
			theStudents = session.createQuery("from Student s where s.email LIKE '%email.com' ").getResultList();
			for(Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
	}

}
