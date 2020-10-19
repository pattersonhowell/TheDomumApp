import java.util.ArrayList;

public class Agent extends User {

	private String realtyGroup;
	private int employeeID;
	private ArrayList<Listing> managedListings;
	
	public Agent(String realtyGroup, int employeeID) {
		this.realtyGroup = realtyGroup;
		this.employeeID = employeeID;
	}
	
	public String toString() {
		return "";
	}
	
}
