package hibernate.demo.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
			/*//begin a transaction
			session.beginTransaction();
			
			//Get the instructor Detail object
			int theid=1;
			
			//Eager Loading: All the mapped entries are fetched when the object is retrieved.
			Instructor temp=session.get(Instructor.class, theid);
			System.out.println("Instructor object :"+temp);
			
			//Get the associated object
			//Lazy Loading: The mapped entries are fetched only on DEMAND.
			//We cannot perform Lazy loading after the session is closed, whereas we can do it by Eager Loading	
			System.out.println("Courses Object :"+ temp.getCourses());
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done !!!");
			*/
			
			//Avoid Issue in Lazy Loading(Out of Session retrieval) with HQL
			
			//begin a transaction
			session.beginTransaction();
			
			//Get the instructor Detail object
			int theid=1;
			
			Query<Instructor> query=session.createQuery("select i from Instructor i JOIN FETCH i.courses where"
					+ " i.id=:theInstructorId", Instructor.class);
			
			//set parameter on query
			query.setParameter("theInstructorId",theid);

			//Execute Query and get instructor
			Instructor temp=query.getSingleResult();

			System.out.println("Instructor : "+temp);
			//commit the transaction
			session.getTransaction().commit();

			session.close();
			
			System.out.println("Courses Object :"+ temp.getCourses());
			
			
			System.out.println("Done !!!");
		}
		finally {
			//add clean up code
			
			factory.close();
		}
	}

}
