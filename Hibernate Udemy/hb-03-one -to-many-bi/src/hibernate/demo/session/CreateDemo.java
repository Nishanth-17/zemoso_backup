package hibernate.demo.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.*;

public class CreateDemo {

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
			//create Instructor and Instructor Detail objects
			System.out.println("Creating Objects ...");
			/*Instructor tempi=new Instructor("Nishanth","Badim","nish@gmail.com");
			InstructorDetail tempid=new InstructorDetail("youtube/nish.com","Movies");*/
			Instructor tempi=new Instructor("bush","george","bush@gmail.com");
			InstructorDetail tempid=new InstructorDetail("youtube/bush.com","george reddy");
			
			System.out.println("Instructor object : "+tempi);
			
			// Associate the objects
			//This will also save the Instructor Detail object because of CascadeType.ALL
			tempi.setInstructorDetail(tempid);
			
			//begin a transaction
			session.beginTransaction();
			
			//save the Instructor object
			session.save(tempi);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done !!!");
		}
		finally {
			factory.close();
		}
	}

}