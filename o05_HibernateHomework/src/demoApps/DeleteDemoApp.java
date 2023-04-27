package demoApps;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Employee;

public class DeleteDemoApp {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
						
			//start a transaction
			session.beginTransaction();
			
			//saving the student object
			session.createQuery("DELETE Employee WHERE firstName = 'Piotr'").executeUpdate();
			
			//commit a transaction
			session.getTransaction().commit();
				
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
				
	}
	
}
