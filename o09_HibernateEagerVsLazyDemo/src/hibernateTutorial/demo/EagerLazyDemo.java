package hibernateTutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateTutorial.entity.Course;
import hibernateTutorial.entity.Instructor;
import hibernateTutorial.entity.InstructorDetail;

public class EagerLazyDemo {

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
			
			//start a transaction
			session.beginTransaction();

			//get the instructor from db
			int theId =1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("luv2code: Instructor: " + tempInstructor);

			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			
			//commit transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			System.out.println("\nThe session is now closed!\n");
			
			//since courses are lazy loaded...should fail
			//1 option to avoid fail: call getter method while session is open, then recall courses from memory. 
			
			//get course for the instructor
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			
			System.out.println("luv2code: Done!");
			
		}
		finally {
			
			//add clean up code:
			session.close();
			
			factory.close();
		}
		
	}
	
}
