package practice.activity_8;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Employee.class)
									 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a Employee object
			System.out.println("Create a employee object");
			Employee theEmployee = new Employee("Magic", "Johnson", "OKC");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(theEmployee);
			
			// commit transaction
			session.getTransaction().commit();
			
			// get a new session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrive a new employee by getid
			Employee newEmployee = session.get(Employee.class, theEmployee.getId());
			System.out.println("Using session.get() to get a new Employee: ");
			System.out.println(newEmployee);
			
			//commit the transaction
			session.getTransaction().commit();
			
			/*
			 * query to find employees for LAC
			 */
			System.out.println("query to find employees for LAC");
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// create a List of Employee to receive result
			List<Employee> theEmployees =  session.createQuery("from Employee e where e.company='LAC' ").getResultList();
			
			// print out
			System.out.println("Result of query is: \n" );
			for(Employee temp : theEmployees) {
				System.out.println(temp);
			}
			
			//commit the transanction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
		
		

	}

}
