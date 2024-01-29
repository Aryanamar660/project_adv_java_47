package Student_Details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {

public void insert()throws SQLException, ClassNotFoundException  {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","aryan123");
	Statement st= con.createStatement();
	int rows_inserted = st.executeUpdate("insert into student values(999,'Shri_Ram',99,'GOD',TO_DATE('22-01-2024','DD-MM-YYYY'))");
	System.out.println(rows_inserted + " rows inserted successfully.\n");
	con.close();
}

public void select() throws SQLException, ClassNotFoundException {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","aryan123");
	Statement st= con.createStatement();
	ResultSet rs = st.executeQuery("select * from student");
	while(rs.next()) {
	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getDate(5));
	}
	con.close();
}

public void delete() throws SQLException, ClassNotFoundException  {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","aryan123");
	Statement st= con.createStatement();
	int rows_deleted = st.executeUpdate("delete from student where NAME = 'Jhon'"); 
	System.out.println(rows_deleted + " rows deleted successfully.\n");
	con.close();
}
public void update() throws SQLException, ClassNotFoundException {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","aryan123");
	Statement st= con.createStatement();
	int rows_updated = st.executeUpdate("update student set NAME = 'Bajrang' where ID = 47");
	System.out.println(rows_updated + " rows updated successfully.\n");
	con.close();
}

}
