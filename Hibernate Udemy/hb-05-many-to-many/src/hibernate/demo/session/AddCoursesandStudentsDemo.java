package hibernate.demo.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import hibernate.demo.entity.Student;

public class AddCoursesandStudentsDemo {

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
			int theid=1;
			//Student tempStudent=session.get(Student.class,theid);
			//System.out.println("Student Courses :"+tempStudent.getCourses());
			Course tempc=new Course("Richard Lee theory"); 
			Course tempx=new Course("X Course");
			Student ts=new Student("bog","ellie","bog@gmal.com");
			//tempc.addStudent(tempStudent);
			//tempx.addStudent(tempStudent);
			tempc.addStudent(ts);
			session.save(ts);
			System.out.println("Course Object :"+tempc+"\n "+tempx);
			//Save the Course object
			//session.save(tempc);
			//session.save(tempx);
			session.save(tempc);
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