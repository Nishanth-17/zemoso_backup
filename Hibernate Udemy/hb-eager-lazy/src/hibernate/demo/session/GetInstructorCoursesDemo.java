package hibernate.demo.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create a Session object
		Session session=factory.getCurrentSession();
		
		try {

			//begin a transaction
			session.beginTransaction();
			
			//Get the instructor Detail object
			int theid=22;
			Instructor temp=session.get(Instructor.class, theid);
			
			//Get the associated object
			System.out.println("Courses Object :"+ temp.getCourses());
			
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
