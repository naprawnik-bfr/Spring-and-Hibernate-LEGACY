package hibernateTutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateTutorial.entity.Course;
import hibernateTutorial.entity.Instructor;
import hibernateTutorial.entity.InstructorDetail;
import hibernateTutorial.entity.Review;
import hibernateTutorial.entity.Student;

public class AddCoursesForMaryDemo {

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

			//create a courses
			Course tempCourse1 = new Course("Rubik's Cube course");
			Course tempCourse2 = new Course("Atari 2600 course");
			
			//get student Mary from db
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("\nLoaded student: " + tempStudent);
			System.out.println("\nCourses for loaded student: " + tempStudent.getCourses());

			//add students to the course
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			//save courses
			System.out.println("\nSaving courses....");
			session.save(tempCourse1);
			session.save(tempCourse2);
		
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
