package teams.dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
	public void remove_team(Connection con, Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter the team's id: ");
		int id = sc.nextInt();
		int rowsAffected = st.executeUpdate("delete from IPL_TEAMS where Team_ID = " + id);
		System.out.println();
		System.out.println(rowsAffected + " record deleted!!!");
	}
}
