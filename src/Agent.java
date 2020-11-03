import java.util.ArrayList;

/**
 * Base class for an agent user
 * @author pattersonhowell
 *
 */
public class Agent extends User {

	private String realtyGroup;
	private ArrayList<Integer> managedListings;
	
	/**
	 * Creating an Agent
	 * @param id Their ID
	 * @param name Their name
	 * @param password Their password
	 * @param address Their address
	 * @param phone Their phone number
	 * @param email Their email
	 * @param realtyGroup Their associated realtyGroup
	 */
	public Agent(String id, String name, String password, String address, String phone, String email ,String realtyGroup) {
		super(id, name, password, address, phone, email);
		this.realtyGroup = realtyGroup;
		managedListings = new ArrayList<Integer>();
	}
	
	/************************************************************
	 * BASIC GETTERS AND SETTERS
	 * @return WHAT WAS RETRIEVED
	 */
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
	
	/**
	 * Displaying Agent's information
	 */
	public String toString() {
		return super.toString() + "\nRealtyGroup: " + realtyGroup;
	}
	
}
