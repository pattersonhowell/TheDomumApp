import java.util.ArrayList;

/**
 * Class to manage users 
 * @author pattersonhowell
 * Creates a singleton
 */
public class UserManager {
	
	private static ArrayList<User> users;
	
	private static UserManager userManager;
	
	/**
	 * loading in users from json
	 */
	public UserManager() {
		ArrayList<Review> revList = new ArrayList<Review>();
		users = UserLoader.loadUsers();
	}	
	
	/**
	 * Getting an instance of a user manager
	 * @return a user manager
	 */
	public static UserManager getInstance() {
		if(userManager == null) userManager = new UserManager();
		return userManager;
	}
	
	/**
	 * Getting list of users
	 * @return list of users
	 */
	public ArrayList<User> getUsers() {
		return users;
	}
	
	/**
	 * Adding a user to list of users and updating json file
	 * @param user Who to add
	 */
	public void addUser(User user) {
		users.add(user);
		writeUsers();
	}
	
	/**
	 * Writing new users on json file
	 */
	public void writeUsers() {
		UserWriter.writeUser();
	}
	
	/**
	 * Removing a user and updating json file
	 * @param user Whot to remove
	 */
	public void removeUser(User user) {
		users.remove(user);
		writeUsers();
	}
	
	/**
	 * Verifying if user already exists
	 * @param user Who to verify
	 * @return true or false
	 */
	public boolean userTaken(User user) {
		boolean found = users.contains(user);
		return found;
	}
	
	/**
	 * Printing list of users 
	 */
	public void print() {
		System.out.println("Printing Users");
		for(User x:users) {
			System.out.println(x.toString());
			System.out.println("_________________________________________");
		}		
	}
}
