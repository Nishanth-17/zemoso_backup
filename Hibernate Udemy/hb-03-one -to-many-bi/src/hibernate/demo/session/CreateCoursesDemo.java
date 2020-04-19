package hibernate.demo.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.*;

public class CreateCoursesDemo {

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
			int theid=1;
			
			//begin a transaction
			session.beginTransaction();
			Instructor tempi=session.get(Instructor.class, theid);
			Course tempc=new Course("virus");
			Course tempc2=new Course("corona");
			
			//Associate the objects using the convenience method
			tempi.add(tempc);
			tempi.add(tempc2);
			
			//save the Course object
			session.save(tempc);
			session.save(tempc2);
			
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