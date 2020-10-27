import java.util.ArrayList;

public class Agent extends User {

	private String realtyGroup;
	private ArrayList<Integer> managedListings;
	
	public Agent(int id, String name, String password, String address, String phone, String email, ArrayList<Review> reviews,String realtyGroup) {
		super(id, name, password, address, phone, email);
		this.realtyGroup = realtyGroup;
		managedListings = new ArrayList<>();
	}
	public String getRealtyGroup() {
		return this.realtyGroup;
	}
	public void setRealtyGroup(String realtyGroup) {
		this.realtyGroup = realtyGroup;
	}
	public ArrayList<Integer> getManagedListings() {
		return this.managedListings;
	}
	public void setManagedListings(ArrayList<Integer> managedListings) {
		this.managedListings = managedListings;
	}
	public String toString() {
		return super.toString() + "\nRealtyGroup: " + realtyGroup;
	}
	
}
