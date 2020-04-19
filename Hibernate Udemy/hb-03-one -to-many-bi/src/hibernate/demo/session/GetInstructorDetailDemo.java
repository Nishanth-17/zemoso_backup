package hibernate.demo.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.*;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create a Session object
		Session session=factory.getCurrentSession();
		
		try {
			//begin a transaction
			session.beginTransaction();
			
			//Get the instructor Detail object
			int theid=22;
			InstructorDetail temp=session.get(InstructorDetail.class, theid);
			
			//Get the associated object
			System.out.println("Instructor Object :"+ temp.getInstructor());
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done !!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//To avoid leak exception
			session.close();
			
			factory.close();
		}
	}

}