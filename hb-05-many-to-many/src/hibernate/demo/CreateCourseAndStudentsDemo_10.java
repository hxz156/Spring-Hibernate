package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo_10 {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Remember that Human is just another typpe of Animal");
			
			// save the course
			System.out.println("Save the course:");
			session.save(tempCourse);
			
			// create the students
			Student tempStudent1 = new Student("Magic", "Johnson", "@magic.email");
			Student tempStudent2 = new Student("Kyle", "Kuzma", "@kuz.email"); 
			
			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			// save the students
			System.out.println("\n save the student ... \n");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved students: " + tempCourse.getStudents());
			
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
