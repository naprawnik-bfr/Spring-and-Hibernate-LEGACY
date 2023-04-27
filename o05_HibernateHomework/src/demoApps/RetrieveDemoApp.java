package demoApps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Employee;

public class RetrieveDemoApp {
	
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
			
			//reading and showing student object
			Employee theEmployee = session.get(Employee.class, 3);
			System.out.println(theEmployee);
			
			//commit a transaction
			session.getTransaction().commit();
				
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
				
	}
	
}
