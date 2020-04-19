package hibernate.demo.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import hibernate.demo.entity.Student;

public class DeleteCoursesandStudentsDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create a Session object
		Session session=factory.getCurrentSession();
		
		try {
			
			//begin a transaction
			session.beginTransaction();
			int theid=3;
			Student tempStudent=session.get(Student.class,theid);
			System.out.println("Student Courses :"+tempStudent.getCourses());
			
			//Delete the Student object or course object (No cascade delete applied)
			session.delete(tempStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done !!!");
		}
		finally {
			//add clean up code
			session.close();
			
			factory.close();
		}
	}

}