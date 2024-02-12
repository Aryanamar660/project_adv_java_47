package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import teams.crud_operations;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "SYSTEM";
		String pwd = "aryan123";

		Connection con = DriverManager.getConnection(url, username, pwd);
		Scanner sc = new Scanner(System.in);
		crud_operations ipl = new crud_operations();
		while (true) {
			System.out.println("\nChoose the operation you want to perform :");
			System.out.println("1. Perform Insert operation");
			System.out.println("2. Perform Read operation");
			System.out.println("3. Update Team's name");
			System.out.println("4. Update Team's captain");
			System.out.println("5. Update Team's coach");
			System.out.println("6. Perform Delete operation");
			System.out.println("7. Exit");
			System.out.println("\nPlease enter your choice :");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("\nPerforming INSERT operation......\n");
				ipl.insert_teams(con, sc);
				break;
			case 2:
				System.out.println("\nPerforming READ operation......\n");
				ipl.display_teams(con);
				break;
			case 3:
				System.out.println("\nUpdating Team's name......\n");
				ipl.update_team_Name(con, sc);
				break;
			case 4:
				System.out.println("\nUpdating Team's captain......\n");
				ipl.update_team_Captain(con, sc);
				break;
			case 5:
				System.out.println("\nUpdating Team's coach......\n");
				ipl.update_team_Coach(con, sc);
				break;
			case 6:
				System.out.println("\nPerforming DELETE operation......\n");
				ipl.remove_team(con, sc);
				break;
			case 7:
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
