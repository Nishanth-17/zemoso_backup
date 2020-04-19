package hibernate.demo.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class ReadStudentDemo {

public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a Session object
		Session session=factory.getCurrentSession();
		
		try {
			//create a student object
			System.out.println("Creating a student object");
			Student temp=new Student("Naren","Raju","naren@gmail.com");
			//begin a transcation
			session.beginTransaction();
			//save the student object
			session.save(temp);
			//commit the transaction
			session.getTransaction().commit();
			
			//Now we will get the student object with the help of the primary key id
			session=factory.getCurrentSession();
			session.beginTransaction();
			Student readStudent=session.get(Student.class, temp.getId());
			session.getTransaction().commit();
			System.out.println("Student Object retrieved : "+ readStudent.getFirstname());			
			System.out.println("Done !!!");
		}
		finally {
			factory.close();
		}
	}

}
