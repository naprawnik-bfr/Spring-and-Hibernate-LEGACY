package hibernateTutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateTutorial.entity.Instructor;
import hibernateTutorial.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
	
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create the objects
//			Instructor tempInstructor =
//					new Instructor("Blazej", "Fraczek", "bf@gmail.com");
//			
//			InstructorDetail tempInstructorDetail =
//					new InstructorDetail("http://www.bf.com/youtube", "skiing");
			
			Instructor tempInstructor =
					new Instructor("Marta", "Fraczek", "mf@gmail.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://www.mf.com/youtube", "ukulele");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			//save the instructor
			// THIS WILL ALSO SAVE THE DETAILS OBJECT
			// BECAUSE OF CascadeType.All
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
	}
	
}
