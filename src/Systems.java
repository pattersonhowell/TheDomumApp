import java.util.ArrayList;
/**
 * 
 * the Systems class serves as a hub for various functions needed in the driver
 *
 */
public class Systems {	
	
	ListingManager listingManager = ListingManager.getInstance();
	
	UserManager manager = UserManager.getInstance();
	/**
	 * checks if a username and password match any combination stored in our database
	 * @param name: String of user's name
	 * @param password: String of user's password
	 * @return: true if login matches, false if not
	 */
	public boolean verifiedLogin(String name, String password) {	
		for(User x: manager.getUsers()) {
			if(x.getName().equalsIgnoreCase(name) && x.getPassword().equalsIgnoreCase(password)) {
				return true;
			}					
		}
		return false;		
	}		
	/**
	 * checks only if the username matches one in the database
	 * @return true if match found
	 */
	public boolean verifiedUser(String name) {
		for(User x: manager.getUsers()) {
			if(x.getName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}
	/**
	 * creates a new student with the proper details and adds them to the list of students
	 *
	 */
	public void signUpStudent(String name, String password, String address, String phone, String email, String studentID) {
		Student newStudent = new Student(studentID,name,password,address,phone,email);	
		manager.addUser(newStudent);
	}
	/**
	 * creates a new agent with the proper details and adds them to the list of agents
	 */
	public void signUpAgent(String name, String password, String address, String phone, String email, String group,String agentID) {
		Agent newAgent = new Agent(agentID, name, password, address, phone, email, group);
		manager.addUser(newAgent);
	}			
	/**
	 * simply returns an array list of listings for the user to browse
	 * 
	 */
	public ArrayList<Listing> browseAnonymously(){
		ArrayList<Listing> ret = new ArrayList<>();
		return ret;
	}	
	
	/**
	 * removes an existing account from the database
	 */
	public void deleteAccount(String name, String password) {
		ArrayList<User> users = manager.getUsers();
		int index = users.indexOf(name);
		users.remove(index);
	}		
	/**
	 * takes a name and returns the corresponding user
	 * 
	 */
	public User returnUserWithName(String name) {
		for(User x: manager.getUsers()) {
			if(x.getName().equalsIgnoreCase(name)) {
				return x;
			}
		}
		return null;
	}			
	
	/**
	 * prints all listings
	 */
	public void printListings() {
		listingManager.printListings(listingManager.getListings());
	}
	/**
	 * takes in all user inputs for all listing attributes and returns listings that fit those parameters
	 */
	public void comprehensiveSearch(double price,int bed,int bath,double distance,boolean wifi,boolean laundry,boolean petFriendly,boolean pool,boolean gym,boolean furnished) {
		listingManager.comprehensiveSearch(price,bed,bath,distance,wifi,laundry,petFriendly,pool,gym,furnished);
	}	
	/**
	 * takes in an id and returns the corresponding listing
	 * 
	 */
	public Listing listingID(int id) {
		return listingManager.findListing(id);
	}
	/**
	 * takes in a listing and student id, then generates a lease for them
	 * 
	 */
	public void generateLease(int listingID, String studentID) {		
		for(User x: manager.getUsers()) {
			if(x.getId().equals(studentID))	{//serching for the user 
				listingManager.findListing(listingID).generateLease(x);
			}
		}			
		System.out.println("Please See Txt File");
	}		
	/**
	 * returns the user id for a specific username and password
	 * 
	 */
	public String returnID(String userName, String password) {
		for(User x: manager.getUsers()) {
			if(x.getName().equalsIgnoreCase(userName) && x.getPassword().equals(password) ) {
				return x.getId();
			}
		}
		return null;			
	}	
	/**
	 * takes listing and student ids to generate an application for them
	 * 
	 */
	public void generateApp(int listingID,String studentID) {
		for(User x: manager.getUsers()) {
			if(x.getId().equals(studentID))	{//serching for the user 
				listingManager.findListing(listingID).generateApplication(x);
			}
		}
	}
	/**
	 * removes a listing from the arraylist
	 *
	 */
	public void removeListing(int listingID) {
		if(listingManager.listingExists(listingID)) {//check if listing exists 
			listingManager.removeListing(listingID);
			System.out.println("Listing was Removed");
		}	
		else {
			System.out.println("Listing not found");
		}
	}	
	/**
	 * returns true if an id corresponds to an existing student
	 * 
	 */
	public boolean isStudent(String id) {		
		for(User x: manager.getUsers()) {
			if(x.getId().equals(id)) {
				if(x instanceof Student) {
					return true;
				}				
			}
		}
		return false;
	}	
	
	
	
}
