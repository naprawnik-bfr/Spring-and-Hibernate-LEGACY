package demoApps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Employee;

public class CreateDemoApp {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a student object	
			Employee tempEmployee = new Employee("Piotr", "Kozlowski", "Precon");
			
			//start a transaction
			session.beginTransaction();
			
			//saving the student object
			session.save(tempEmployee);
			
			//commit a transaction
			session.getTransaction().commit();
				
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
				
	}
	
}
