package driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import teams.dao.Insert;
import teams.dao.Select;
import teams.dao.Update;
import teams.dao.Delete;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "SYSTEM";
		String pwd = "aryan123";

		Connection con = DriverManager.getConnection(url, username, pwd);
		Scanner sc = new Scanner(System.in);
		//For insertion
		Insert insert = new Insert();
		//For retrieval
		Select select = new Select();
		//For update
		Update update = new Update();
		//For deletion
		Delete delete = new Delete();
		
		while (true) {
			System.out.println("\nChoose the operation you want to perform :");
			System.out.println("1. Perform Insert operation");
			System.out.println("2. Perform Select operation");
			System.out.println("3. Perform Update operation");
			System.out.println("4. Perform Delete operation");
			System.out.println("5. Exit");
			System.out.println("\nPlease enter your choice :");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("\nPerforming INSERT operation......\n");
				insert.insert_teams(con, sc);
				break;
			case 2:
				System.out.println("\nPerforming SELECT operation......\n");
				select.display_teams(con);
				break;
			case 3:
				System.out.println("\nPerforming UPDATE operation......\n");
				update.update_team_Captain(con, sc);
				break;
			case 4:
				System.out.println("\nPerforming DELETE operation......\n");
				delete.remove_team(con, sc);
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
