package teams.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
	public void display_teams(Connection con) throws SQLException {

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from IPL_TEAMS");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4)
					+ "  " + rs.getString(5));
		}
	}
}
