package teams.dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {
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

}
