import java.util.ArrayList;

public class Agent extends User {

	private String realtyGroup;
	private ArrayList<String> managedListings;
	
	public Agent(String realtyGroup) {
		super();
		this.realtyGroup = realtyGroup;
	}
	
	public String toString() {
		return super.toString() + "\nRealtyGroup: " + realtyGroup;
	}
	
}
