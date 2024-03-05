package politics.leaders;

public class leaders {
	
private int ID;
private String NAME;
private String PARTY_NAME;
private String LEADER_TITLE;
private String ACCOMPLISHMENT;

public leaders() {
	super();
	// TODO Auto-generated constructor stub
}

public leaders(int iD, String nAME, String pARTY_NAME, String lEADER_TITLE, String aCCOMPLISHMENT) {
	super();
	ID = iD;
	NAME = nAME;
	PARTY_NAME = pARTY_NAME;
	LEADER_TITLE = lEADER_TITLE;
	ACCOMPLISHMENT = aCCOMPLISHMENT;
}

public int getID() {
	return ID;
}

public void setID(int iD) {
	ID = iD;
}

public String getNAME() {
	return NAME;
}

public void setNAME(String nAME) {
	NAME = nAME;
}

public String getPARTY_NAME() {
	return PARTY_NAME;
}

public void setPARTY_NAME(String pARTY_NAME) {
	PARTY_NAME = pARTY_NAME;
}

public String getLEADER_TITLE() {
	return LEADER_TITLE;
}

public void setLEADER_TITLE(String lEADER_TITLE) {
	LEADER_TITLE = lEADER_TITLE;
}

public String getACCOMPLISHMENT() {
	return ACCOMPLISHMENT;
}

public void setACCOMPLISHMENT(String aCCOMPLISHMENT) {
	ACCOMPLISHMENT = aCCOMPLISHMENT;
}

@Override
public String toString() {
	return "leaders [ID=" + ID + ", NAME=" + NAME + ", PARTY_NAME=" + PARTY_NAME + ", LEADER_TITLE=" + LEADER_TITLE
			+ ", ACCOMPLISHMENT=" + ACCOMPLISHMENT + "]";
}




}
