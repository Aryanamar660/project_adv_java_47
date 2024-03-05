package politics.leaders;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;
import politics.leaders.operations.*;

public class App 
{
    public static void main( String[] args )
    {
    	 Configuration config = new Configuration();
         config.configure(); 
         SessionFactory factory = config.buildSessionFactory();
         Session session = factory.openSession();
         Scanner scanner = new Scanner(System.in);
         //for insertion
         insertion_operation I = new insertion_operation();
         //for retrieval of any particular record
         particular_retrieval P = new particular_retrieval();
         //for retrieval of each and every record
         everything_retrieval E = new everything_retrieval();
         //Updating any record from the table
         updation_operation U = new updation_operation();
         //Deleting any record from the table
         deletion_operation D = new deletion_operation();
         //For exiting the program
         exit_operation Exit = new exit_operation();
         try
         {
        	while(true) 
        	{
        		 System.out.println("\nChoose the operation you want to perform:");
                 System.out.println("1. Insert a record into the table");
                 System.out.println("2. Retrieve a particular record from the table");
                 System.out.println("3. Retrieve all the records from the table");
                 System.out.println("4. Update a record in the table");
                 System.out.println("5. Delete a record from the table");
                 System.out.println("6. Exit");
                 System.out.print("\nPlease enter your choice: ");
                 int choice = scanner.nextInt();
                 
                 switch(choice)
                 {
                 case 1 : I.insert_Record(session, scanner);
                	      break;
                 case 2 : P.single_Record_Retrieval(session, scanner);
           	              break;	      
                 case 3 : E.every_Record_Retrieval(session);
      	                  break;
                 case 4 : U.Update_Record(session, scanner);
      	                  break;
                 case 5 : D.Delete_Record(session, scanner);
      	                  break;
                 case 6 : Exit.exitProgram(session, factory, scanner);
      	                  break;
      	         default : System.out.println("\nInvalid choice. Please try again.\n");
                 }
        	}
         }
         finally
         {
        	 session.close();
             factory.close();
             scanner.close(); 
         }
    }
}
