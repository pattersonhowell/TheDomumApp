import java.util.ArrayList;

public class Agent extends User {

	private String realtyGroup;
	private ArrayList<Listing> managedListings;
	
	public Agent(String id, String name, String password, String address, String phone, String email ,String realtyGroup) {
		super(id, name, password, address, phone, email);
		this.realtyGroup = realtyGroup;
		managedListings = new ArrayList<Listing>();
	}
	public String getRealtyGroup() {
		return this.realtyGroup;
	}
	public void setRealtyGroup(String realtyGroup) {
		this.realtyGroup = realtyGroup;
	}
	public ArrayList<Listing> getManagedListings() {
		return this.managedListings;
	}
	public void setManagedListings(ArrayList<Listing> managedListings) {
		this.managedListings = managedListings;
	}
	public String toString() {
		return super.toString() + "\nRealtyGroup: " + realtyGroup;
	}
	
}
