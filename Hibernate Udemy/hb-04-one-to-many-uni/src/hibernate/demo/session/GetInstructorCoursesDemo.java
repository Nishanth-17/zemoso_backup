package hibernate.demo.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;

public class GetInstructorCoursesDemo {

public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create a Session object
		Session session=factory.getCurrentSession();
		
		try {
			int theid=10;
			
			//begin a transaction
			session.beginTransaction();
			Course tempi=session.get(Course.class, theid);
			
			System.out.println("REviews are : "+ tempi.getReviews());
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
