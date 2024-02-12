package lab_one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class IPL_TEAMS_CRUD {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "SYSTEM";
		String pwd = "aryan123";

		Connection con = DriverManager.getConnection(url, username, pwd);
		Scanner sc = new Scanner(System.in);
		IPL_TEAMS_CRUD ipl = new IPL_TEAMS_CRUD();
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

	public void insert_teams(Connection con, Scanner sc) throws SQLException

	{
		Statement st = con.createStatement();
		System.out.println("Enter the team's Id: ");
		int id = sc.nextInt();

		System.out.println("Enter the team's name: ");
		String name = sc.next();

		System.out.println("Enter the team's city: ");
		String city = sc.next();

		System.out.println("Enter the team's captain: ");
		String captain = sc.next();

		System.out.println("Enter the team's coach: ");
		String coach = sc.next();

		String query = String.format("insert into IPL_TEAMS values(%d, '%s', '%s', '%s', '%s')", id, name, city,
				captain, coach);

		int rowsAffected = st.executeUpdate(query);
		System.out.println();
		System.out.println(rowsAffected + " record inserted!!!");
	}

	public void display_teams(Connection con) throws SQLException {

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from IPL_TEAMS");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4)
					+ "  " + rs.getString(5));
		}
	}

	public void update_team_Name(Connection con, Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter the team's id: ");
		int id = sc.nextInt();
		System.out.println("Enter the team's new name: ");
		String name = sc.next();
		String query = String.format("update IPL_TEAMS set Team_Name='%s' where Team_ID = %d", name, id);
		int rowsAffected = st.executeUpdate(query);
		System.out.println();
		System.out.println(rowsAffected + " record updated!!!");
	}

	public void update_team_Captain(Connection con, Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter the team's id: ");
		int id = sc.nextInt();
		System.out.println("Enter the team's new captain: ");
		String captain = sc.next();
		String query = String.format("update IPL_TEAMS set Captain='%s' where Team_ID = %d", captain, id);
		int rowsAffected = st.executeUpdate(query);
		System.out.println();
		System.out.println(rowsAffected + " record updated!!!");
	}

	public void update_team_Coach(Connection con, Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter the team's id: ");
		int id = sc.nextInt();
		System.out.println("Enter the team's new coach: ");
		String coach = sc.next();
		String query = String.format("update IPL_TEAMS set Coach='%s' where Team_ID = %d", coach, id);
		int rowsAffected = st.executeUpdate(query);
		System.out.println();
		System.out.println(rowsAffected + " record updated!!!");
	}

	public void remove_team(Connection con, Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter the team's id: ");
		int id = sc.nextInt();
		int rowsAffected = st.executeUpdate("delete from IPL_TEAMS where Team_ID = " + id);
		System.out.println();
		System.out.println(rowsAffected + " record deleted!!!");
	}

}
