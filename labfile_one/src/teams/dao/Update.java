package teams.dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
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
}
