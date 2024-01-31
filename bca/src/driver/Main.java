package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import student.stud_crud_operations;

public class Main {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
        Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "SYSTEM";
	 	String pwd = "aryan123";
		
		Connection con = DriverManager.getConnection(url, username, pwd);
		Scanner sc = new Scanner(System.in);
		stud_crud_operations S = new stud_crud_operations();
		while(true) {
			//Display menu 
			System.out.println("\nChoose the operation you want to perform :");
	        System.out.println("1. Insert");
	        System.out.println("2. Select");
	        System.out.println("3. Update");
	        System.out.println("4. Delete");
	        System.out.println("5. Exit");
	        System.out.println("\nPlease enter your choice :");

	        // Reading the input from the user
	       // java.util.Scanner input = new java.util.Scanner(System.in);
	        int choice = sc.nextInt();

	        switch (choice) {
	            case 1:
	            	System.out.println("\nPerforming INSERT operation......\n");
	                S.insertStudent(con, sc);
	                break;
	            case 2:
	            	System.out.println("\nPerforming SELECT operation......\n");
	                S.displayStudents(con);
	                break;
	            case 3:
	            	System.out.println("\nPerforming UPDATE operation......\n");
	                S.updateStudent(con, sc);
	                break;
	            case 4:
	            	System.out.println("\nPerforming DELETE operation......\n");
	                S.removeStudent(con, sc);
	                break;
	            case 5:
	            	System.out.println("\nExiting......\n");
	            	sc.close();
	            	System.exit(0);
	                break;
	            default:
	                System.out.println("\nInvalid choice\n");
	        }
			}
	}

}
