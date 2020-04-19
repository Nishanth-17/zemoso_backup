package hibernate.demo.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
			SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
					addAnnotatedClass(Student.class).buildSessionFactory();
			Session session=factory.getCurrentSession();
			
			try {
				Student myStudent=new Student("nishanth","b","gma@com");
				session.beginTransaction();
				session.save(myStudent);
				session.getTransaction().commit();
				session=factory.getCurrentSession();
				session.beginTransaction();
				Student temp=session.get(Student.class,myStudent.getId());
				session.delete(temp);
				session.createQuery("delete from Student s where id=3").executeUpdate();
				Transaction tr=session.getTransaction();
						tr.commit();
				}
			finally {
				factory.close();
			}
	}

}
