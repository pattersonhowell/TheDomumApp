import java.util.ArrayList;

public class Agent extends User {

	private String realtyGroup;
	private ArrayList<Integer> managedListings;
	
	public Agent(String id, String name, String password, String address, String phone, String email, ArrayList<Review> reviews,String realtyGroup) {
		super(id, name, password, address, phone, email, reviews);
		this.realtyGroup = realtyGroup;
	}
	
	public String toString() {
		return super.toString() + "\nRealtyGroup: " + realtyGroup;
	}
	
}
