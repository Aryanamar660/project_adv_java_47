package politics.leaders.operations;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import politics.leaders.leaders;

public class particular_retrieval {
	public void single_Record_Retrieval(Session session, Scanner scanner)
	{
		 Transaction transaction = session.beginTransaction();
		 leaders Leader = new leaders();
		 System.out.println("\nRetrieving a particular leader from the table based on the id of the leader......");
	     System.out.println("\nEnter the id of the leader who's information you want to retrieve - ");
		 int retrieved_id = scanner.nextInt();
		 System.out.println();
		 Leader = session.get(leaders.class, retrieved_id);
		 if (Leader != null) 
		 { 
		 System.out.println("Leader - " + Leader);
		 } 
	     else	 
	     {	 
	     System.out.println("Leader with ID " + retrieved_id + " is not available.\n");
	     }
		 transaction.commit();
	}
}
