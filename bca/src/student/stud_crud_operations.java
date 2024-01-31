package student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class stud_crud_operations {
 public stud_crud_operations() {
	 super();
 }
 public void insertStudent(Connection con, Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter the student's Id: ");
		int id = sc.nextInt();
		
		System.out.println("Enter the student's name: ");
		String name = sc.next();
		
		System.out.println("Enter the student's age: ");
		int age = sc.nextInt();
		
		System.out.println("Enter the student's marks: ");
		double marks = sc.nextDouble();
		
		System.out.println("Enter the student's gender: ");
		String gender = sc.next();
		
		String query = String.format("insert into student_info values(%d, '%s', %d, %f, '%s')", id, name, age, marks, gender);
	
		int rowsAffected = st.executeUpdate(query);
		System.out.println(rowsAffected + " record inserted!!!");
		
	}
 public void displayStudents(Connection con) throws SQLException {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from student_info");
		while(rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2)+"  " + rs.getInt(3) + "  " + rs.getDouble(4)+"  "+rs.getString(5));
		}
	}
 public void updateStudent(Connection con, Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter the student's Id: ");
		int id = sc.nextInt();
		System.out.println("Enter the student's new Name: ");
		String name = sc.next();
		String query = String.format("update student_info set name='%s' where id = %d", name, id);
		int rowsAffected = st.executeUpdate(query);
		System.out.println(rowsAffected+ " record updated!!!");
	}
 public void removeStudent(Connection con, Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter the student's id: ");
		int id = sc.nextInt();
		int rowsAffected = st.executeUpdate("delete from student_info where id = "+id);
		System.out.println(rowsAffected+ " record deleted!!!");
	}

}
