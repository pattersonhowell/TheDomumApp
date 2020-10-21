import java.util.ArrayList;

public class Agent extends User {

	private String realtyGroup;
	private ArrayList<Listing> managedListings;
	
	public Agent(String realtyGroup) {
		this.realtyGroup = realtyGroup;
	}
	
	public String toString() {
		return "";
	}
	
}
