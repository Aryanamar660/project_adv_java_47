package politics.leaders.operations;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import politics.leaders.leaders;

public class everything_retrieval {

	public void every_Record_Retrieval(Session session)
	{
		Transaction transaction = session.beginTransaction();
		System.out.println("\nRetrieving everything from the table......\n");
		Query<leaders> query = session.createQuery("FROM leaders", leaders.class);
		List<leaders> leaders_list = query.list();
		for (leaders leader : leaders_list) 
		{
		System.out.println("Leader - " + leader);
		}
		transaction.commit();
	}
}
