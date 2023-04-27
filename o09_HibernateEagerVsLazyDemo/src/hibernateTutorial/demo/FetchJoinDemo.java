package hibernateTutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hibernateTutorial.entity.Course;
import hibernateTutorial.entity.Instructor;
import hibernateTutorial.entity.InstructorDetail;

public class FetchJoinDemo {

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
			Query<Instructor> query = 
					session.createQuery("SELECT i FROM Instructor i "
										+ "JOIN FETCH i.courses "
										+ "WHERE i.id = :theInstructorId", 
										Instructor.class);
			
			//set parameter on query
			query.setParameter("theInstructorId", theId);
			
			//execute query and get instructor 
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("luv2code: Instructor: " + tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			System.out.println("\nThe session is now closed!\n");
			
			//since courses are lazy loaded...should fail
			//2 option to avoid fail: Hibernate query with HQL data loading. 
			
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
