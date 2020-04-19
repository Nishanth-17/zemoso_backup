package hibernate.demo.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {
		//Create Session Factory
				SessionFactory factory=new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
		//create a Session object
		Session session=factory.getCurrentSession();
				
				try {
					int studentId=1;
					//begin a transcation
					session.beginTransaction();
					
					//retireve a student object
					Student myStudent=session.get(Student.class, studentId);
					System.out.println("Updating student with student ID : "+ studentId);
					myStudent.setFirstname("Scooby");
					
					// there is no save session object while update
					
					//commit the transaction
					session.getTransaction().commit();
					
					//Update Email for students
					session=factory.getCurrentSession();
					session.beginTransaction();
					session.createQuery("update Student set email='nish@gmail.com'")
							.executeUpdate();
					System.out.println("Done !!!");
					session.getTransaction().commit();
				}
				finally {
					factory.close();
				}
	}

}
