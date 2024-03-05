package politics.leaders.operations;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import politics.leaders.leaders;

public class updation_operation {

	public void Update_Record(Session session, Scanner scanner)
	{
		Transaction transaction = session.beginTransaction();
		leaders Leader = new leaders();
		System.out.println("\nUpdating the party of the leader......");
		System.out.println("\nEnter the id of the leader who's party you want to update -");
		int id = scanner.nextInt();
		Leader = session.get(leaders.class, id);
		if(Leader != null)
		{
		System.out.println("\nEnter the name of the new party for the leader -");
		String new_party = scanner.next();
		System.out.println();
		Leader.setPARTY_NAME(new_party);
		session.saveOrUpdate(Leader);
		System.out.println("Party - " + Leader + " updated successfully.\n");
		}
		else
		{
		System.out.println("\nLeader with ID " + id + " is not found.\n");	
		}
		transaction.commit();
	}	
}
