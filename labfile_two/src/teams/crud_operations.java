package teams;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class crud_operations {
	public crud_operations()
	{
		super();
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
