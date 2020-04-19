package hibernate.demo.session;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class QueryStudent {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
		session.beginTransaction();
		
		List<Student> myStudents;
		List<Student> theStudents;
		myStudents=session.createQuery("from Student s where s.lastname='Sync' OR s.firstname='Naren'").list();
		theStudents=session.createQuery("from Student s where s.email LIKE '%gmail%'").list();
		for(Student temp: theStudents) {
			System.out.println(temp);
		}
		session.getTransaction().commit();
		System.out.println("Done");
		}
		finally {
			factory.close();
		}
	}

}
