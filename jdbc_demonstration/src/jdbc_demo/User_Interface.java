package jdbc_demo;

import java.sql.SQLException;

import Student_Details.Student;

public class User_Interface {

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		
		Student S1 = new Student();
		while(true) {
		//Display menu 
		System.out.println("\nChoose the operation you want to perform :");
        System.out.println("1. Insert");
        System.out.println("2. Select");
        System.out.println("3. Delete");
        System.out.println("4. Update");
        System.out.println("5. Exit");
        System.out.println("\nPlease enter your choice :");

        // Reading the input from the user
        java.util.Scanner input = new java.util.Scanner(System.in);
        int choice = input.nextInt();

        switch (choice) {
            case 1:
            	System.out.println("\nPerforming INSERT operation......\n");
                S1.insert();
                break;
            case 2:
            	System.out.println("\nPerforming SELECT operation......\n");
                S1.select();
                break;
            case 3:
            	System.out.println("\nPerforming DELETE operation......\n");
                S1.delete();
                break;
            case 4:
            	System.out.println("\nPerforming UPDATE operation......\n");
                S1.update();
                break;
            case 5:
            	System.out.println("\nExiting......\n");
            	input.close();
            	System.exit(0);
                break;
            default:
                System.out.println("\nInvalid choice\n");
        }
		}
	}

}
