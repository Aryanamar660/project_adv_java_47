package employee.annotation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.Scanner;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Scanner sc = new Scanner(System.in);
		while(true)
		{   
			System.out.println("\nChoose the operation you want to perform :");
			System.out.println("1. Insert a record into the table");
			System.out.println("2. Retrieve a particular record from the table");
			System.out.println("3. Retrieve all the records from the table");
			System.out.println("4. Update some record from the table ");
			System.out.println("5. Delete some record from the table ");
			System.out.println("7. Exit");
			System.out.println("\nPlease enter your choice :");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1 : insert_record(session, sc);
			         break;
			case 2 : retrieve_record(session, sc);
	                 break;
			case 3 : retrieve_all_records(session);
	                 break;
			case 4 : update_record(session, sc);
	                 break;
			case 5 : delete_record(session, sc);
	                 break;
			case 6 : exit_program(session, factory, sc);
	                 break;
			}
		}
    }
    private static void insert_record(Session session, Scanner sc)
    {
                Transaction transaction = session.beginTransaction();
    			System.out.println("\nPerforming INSERT operation......");
    			System.out.println("\nPlease enter the first name of the employee -");
    			String fname = sc.next();
    			System.out.println("Please enter the last name of the employee -");
    			String lname = sc.next();
    			System.out.println("Please enter the department of the employee -");
    			String dept = sc.next();
    			System.out.println("Please enter the salary of the employee -");
    			double sal = sc.nextDouble();
    			System.out.println();
    			Employee emp_insert = new Employee();
    			emp_insert.setF_name(fname);
    			emp_insert.setL_name(lname);
    			emp_insert.setE_dept(dept);
    			emp_insert.setE_sal(sal);
    			session.save(emp_insert);
    			transaction.commit();
    }
    private static void retrieve_record(Session session, Scanner sc)
    {
    	 Transaction transaction = session.beginTransaction();
		 System.out.println("\nRetrieving a particular employee from the table based on his/her id......");
	     System.out.println("\nEnter the id of the employee who's information you want to retrieve - ");
		 int retrieved_id = sc.nextInt();
		 System.out.println();
		 Employee E = session.get(Employee.class, retrieved_id);
		 if (E != null) 
		 { 
		 System.out.println("Employee - " + E);
		 } 
	     else	 
	     {	 
	     System.out.println("Employee with ID " + retrieved_id + " doesn't exist.\n");
	     }
		 transaction.commit();
    }
    private static void retrieve_all_records(Session session)
    {
    	Transaction transaction = session.beginTransaction();
		System.out.println("\nRetrieving everything from the table......\n");
		Query<Employee> query = session.createQuery("FROM leaders", Employee.class);
		List<Employee> employees_list = query.list();
		for (Employee emp : employees_list) 
		{
		System.out.println("Employee - " + emp);
		}
		transaction.commit();
    }
    private static void update_record(Session session, Scanner sc)
    {
    	Transaction transaction = session.beginTransaction();
		System.out.println("\nUpdating the department of the employee......");
		System.out.println("\nEnter the id of the employee who's department you want to update -");
		int id = sc.nextInt();
		Employee emp_update = session.get(Employee.class, id);
		if(emp_update != null)
		{
		System.out.println("\nEnter the name of the new department for the employee -");
		String new_dept = sc.next();
		System.out.println();
		emp_update.setE_dept(new_dept);
		session.saveOrUpdate(emp_update);
		System.out.println("Department - " + emp_update + " updated successfully.\n");
		}
		else
		{
		System.out.println("\nEmployee with ID " + id + " doesn't exist.\n");	
		}
		transaction.commit();
    }
    private static void delete_record(Session session, Scanner sc)
    {
    	Transaction transaction = session.beginTransaction();
		System.out.println("\nDeleting some record from the table......");
		System.out.println("\nEnter the id of the employee whose information you want to delete -");
		int id = sc.nextInt();
		System.out.println();
		Employee emp_delete = session.get(Employee.class, id);
		if (emp_delete != null) 
		{	
		session.delete(emp_delete);
		System.out.println("Record - " + emp_delete + " deleted successfully.\n");
		} 
		else 
		{
			System.out.println("\nEmployee with ID " + id + " is not found.\n");
		}
		transaction.commit();
    }
    private static void exit_program(Session session, SessionFactory factory, Scanner sc) 
    {
    	 System.out.println("\nExiting...\n");
	     sc.close();
	     session.close();
	     factory.close();
	     System.exit(0);
    }
}
