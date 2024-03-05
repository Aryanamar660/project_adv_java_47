package politics.leaders.operations;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class exit_operation {
	public void exitProgram(Session session, SessionFactory factory, Scanner scanner) 
	{
		 System.out.println("\nExiting...\n");
	     scanner.close();
	     session.close();
	     factory.close();
	     System.exit(0);	
	}
}
