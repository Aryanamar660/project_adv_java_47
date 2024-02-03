package bca.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "SYSTEM";
	 	String pwd = "aryan123";
		Connection con = DriverManager.getConnection(url, username, pwd);
		Scanner sc = new Scanner(System.in);
		App A = new App();
		while(true)
		{
			System.out.println("\nChoose the operation you want to perform :");
	        System.out.println("1. Create a new table");
	        System.out.println("2. Drop an existing table");
	        System.out.println("3. Reading a particular column from the table");
	        System.out.println("4. Select a range of records based on gender");
	        System.out.println("5. Select a range of records based on marks");
	        System.out.println("6. Select a range of records based on initial characters of the student's name");
	        System.out.println("7. Display no. of rows by sql aggregrate function count()");
	        System.out.println("8. Select highest marks student by sql aggregate function max()");
	        System.out.println("9. Select the student with nth highest marks");
	        System.out.println("10.Exit");
	        System.out.println("\nPlease enter your choice :");
	        
	        int choice = sc.nextInt();
	        
	        switch (choice) {
            case 1:
            	System.out.println("\nCreating a table(can only be done once)......\n");
                A.create_table(con);
                break;
            case 2:
            	System.out.println("\nDeleting an existing table...........\n");
                A.drop_table(con);
                break;
            case 3:
            	System.out.println("\nPerforming READ operation......\n");
                A.select_column(con);
                break;
            case 4:
            	System.out.println("\nPerforming READ operation......\n");
                A.select_on_gender(con,sc);
                break;
            case 5:
            	System.out.println("\nPerforming READ operation......\n");
            	A.select_on_marks(con,sc);
                break;
            case 6:
            	System.out.println("\nPerforming READ operation......\n");
            	A.select_on_ini_char(con,sc);
                break;
            case 7:
            	System.out.println("\nPerforming READ operation......\n");
                A.count_func(con);
                break;
            case 8:
            	System.out.println("\nPerforming READ operation......\n");
                A.max_func(con);
                break;
            case 9:
            	System.out.println("\nPerforming READ operation......\n");
                A.nth_highest(con,sc);
                break;
            case 10:
            	System.out.println("\nExiting......\n");
            	sc.close();
            	System.exit(0);
                break;
            default:
                System.out.println("\nInvalid choice\n");
        }

		}

	    
    }
    public void create_table(Connection con) throws SQLException 
    {
    	Statement st = con.createStatement();
    	String query = "Create Table amity_students(id int, name varchar(50), address varchar(50))";
    	int rows = st.executeUpdate(query);
    	System.out.println(rows + " Table(s) created successfully!!!");
    }  
    public void drop_table(Connection con) throws SQLException 
    {
    	Statement st = con.createStatement();
        String query = "drop table amity_students";
        int rows = st.executeUpdate(query);
    	System.out.println(rows + " Table(s) deleted successfully!!!");
    }  
    public void select_column(Connection con) throws SQLException 
    {
    	Statement st = con.createStatement();
    	ResultSet rs = st.executeQuery("select name,age,marks from student_info");
    	while(rs.next()) {
			System.out.println(rs.getString(1)+"      " + rs.getInt(2) + "       " + rs.getDouble(3));
		}
    }  
    public void select_on_gender(Connection con,Scanner sc) throws SQLException 
    {
    	Statement st = con.createStatement();
    	System.out.println("Enter the student's gender: ");
		String gender = sc.next();
    	String query = String.format("select * from student_info where gender = '%s'",gender);
    	ResultSet rs = st.executeQuery(query);
    	while(rs.next())
    	{
    		System.out.println(rs.getInt(1)+"    " + rs.getString(2) + "  " + rs.getInt(3) + "  " + rs.getDouble(4));
    	}
    }  
    public void select_on_marks(Connection con,Scanner sc) throws SQLException 
    {
    	Statement st = con.createStatement();
    	System.out.println("Enter the student's beginning marks: ");
		double beginmarks = sc.nextDouble();
		System.out.println("Enter the student's ending marks: ");
		double endmarks = sc.nextDouble();
    	String query = String.format("select * from student_info where marks > %f and marks < %f",beginmarks,endmarks);
    	ResultSet rs = st.executeQuery(query);
    	while(rs.next())
    	{
    		System.out.println(rs.getInt(1)+"    " + rs.getString(2) + "  " + rs.getInt(3) + "  " + rs.getDouble(4));
    	}
    }  
    public void select_on_ini_char(Connection con,Scanner sc) throws SQLException 
    {
    	Statement st = con.createStatement();
    	System.out.println("Enter the student's initial character: ");
		String initialchar = sc.next();
    	String query = String.format("select * from student_info where name like '%s'",initialchar);
    	ResultSet rs = st.executeQuery(query);
    	while(rs.next())
    	{
    		System.out.println(rs.getInt(1)+"    " + rs.getString(2) + "  " + rs.getInt(3) + "  " + rs.getDouble(4));
    	}
    }  
    public void count_func(Connection con) throws SQLException 
    {
    	Statement st = con.createStatement();
    	ResultSet rs = st.executeQuery("select count(*) from student_info");
    	if (rs.next())
    	{
    	System.out.println(rs.getInt(1));
    	}
    }  
    public void max_func(Connection con) throws SQLException 
    {
    	Statement st = con.createStatement();
    	String query = "select * from student_info where marks in (select max(marks) from student_info)";
    	ResultSet rs = st.executeQuery(query);
    	if (rs.next())
    	{
    	System.out.println(rs.getInt(1)+"    " + rs.getString(2) + "  " + rs.getInt(3) + "  " + rs.getDouble(4));
    	}
    }  
    public void nth_highest(Connection con,Scanner sc) throws SQLException 
    {
    	Statement st = con.createStatement();
    	System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
    	String query = "select * from(select id,name,age,marks, rank() over (order by marks DESC) ranking from student_info) where ranking = "+n;
    	ResultSet rs = st.executeQuery(query);
    	while(rs.next()) {
			System.out.println(rs.getInt(1)+"    " + rs.getString(2) + "  " + rs.getInt(3) + "  " + rs.getDouble(4));
		}
    }  
}

