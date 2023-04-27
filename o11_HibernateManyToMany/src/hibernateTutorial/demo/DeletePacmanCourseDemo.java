package hibernateTutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateTutorial.entity.Course;
import hibernateTutorial.entity.Instructor;
import hibernateTutorial.entity.InstructorDetail;
import hibernateTutorial.entity.Review;
import hibernateTutorial.entity.Student;

public class DeletePacmanCourseDemo {

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
			
			//start a transaction
			session.beginTransaction();
			
			//get the Pacman course
			int courseId = 10;
			Course tempCourse = session.get(Course.class, courseId);
			
			System.out.println("\nLoaded course: " + tempCourse);
			System.out.println("\nStudents for loaded course: " + tempCourse.getStudents());
			
			//delete the course
			System.out.println("\nDeleting course: " + tempCourse);
			session.delete(tempCourse);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			
			//add clean up code:
			session.close();
			
			factory.close();
		}
		
	}
	
}
