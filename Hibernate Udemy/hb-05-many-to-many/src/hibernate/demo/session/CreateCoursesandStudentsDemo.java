package hibernate.demo.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import hibernate.demo.entity.Student;

public class CreateCoursesandStudentsDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create a Session object
		Session session=factory.getCurrentSession();
		
		try {
			
			//begin a transaction
			session.beginTransaction();
			Course tempc=new Course("Corona");
			//save the Course object
			session.save(tempc);
			//Associate the objects using the convience method
			
			Student ts1=new Student("Nishanth","Badim","nish@gma.com");
			Student ts2=new Student("Yashwanth","Badim","yash@gma.com");
			tempc.addStudent(ts1);
			tempc.addStudent(ts2);
			
			//Save the student object
			session.save(ts1);
			session.save(ts2);
			
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