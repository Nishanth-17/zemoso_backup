package hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String password="hbstudent";
		try {
			System.out.println("Connecting to "+ jdbcUrl);
			Connection con=DriverManager.getConnection(jdbcUrl,user,password);
			System.out.println("Connection Successfull!!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
