package hibernate.demo.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.*;

public class DeleteDemo {

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
			int theid=2;

			//begin a transaction
			session.beginTransaction();
			
			InstructorDetail temp=session.get(InstructorDetail.class,theid);
			System.out.println("InstructorDetail object : "+temp);
			
			// Delete 
			//This will also delete the Instructor Detail object because of CascadeType.ALL
			session.delete(temp);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done !!!");
		}
		finally {
			factory.close();
		}
	}

}