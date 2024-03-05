package politics.leaders.operations;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import politics.leaders.leaders;

public class deletion_operation {
	public void Delete_Record(Session session, Scanner scanner)
	{
		Transaction transaction = session.beginTransaction();
		leaders Leader = new leaders();
		System.out.println("\nDeleting some record from the table......");
		System.out.println("\nEnter the id of the leader you want to delete -");
		int id = scanner.nextInt();
		System.out.println();
		Leader = session.get(leaders.class, id);
		if (Leader != null) 
		{	
		session.delete(Leader);
		System.out.println("Record - " + Leader + " deleted successfully.\n");
		} 
		else 
		{
			System.out.println("\nLeader with ID " + id + " is not found.\n");
		}
		transaction.commit();

	}
}
