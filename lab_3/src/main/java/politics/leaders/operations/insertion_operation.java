package politics.leaders.operations;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import politics.leaders.leaders;

public class insertion_operation {
	 public void insert_Record(Session session, Scanner scanner)
	 {      
		    leaders Leader = new leaders();
		    Transaction transaction = session.beginTransaction();
			System.out.println("\nPerforming INSERT operation......");
			System.out.println("\nPlease enter the name of the leader -");
			String name = scanner.next();
			System.out.println("Please enter the name of the party, the leader is associated with -");
			String party = scanner.next();
			System.out.println("Please enter the title of the leader in the party -");
			String title = scanner.next();
			System.out.println("Please enter any one major achievement of the leader -");
			String achieve = scanner.next();
			System.out.println();
			Leader.setNAME(name);
			Leader.setPARTY_NAME(party);
			Leader.setLEADER_TITLE(title);
			Leader.setACCOMPLISHMENT(achieve);
			session.save(Leader);
			transaction.commit();
	 }
}
