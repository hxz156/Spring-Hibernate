package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import hibernate.demo.entity.Student;

public class AddCoursesForStudentDemo_11 {

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
			
			// get the student magic from database
			int theId = 1;
			Student tempStudent = session.get(Student.class, theId);
			System.out.println("\n loaded student is: " + tempStudent);
			System.out.println("Courses: " + tempStudent.getCourses());
			
			// create more courses
			Course tempCourse1 = new Course("Meditate every day");
			Course tempCourse2 = new Course("Think less during working");
			
			// add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			// save the courses
			System.out.println("\n Saving the new courses: ...");
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
