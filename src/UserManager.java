import java.util.ArrayList;

public class UserManager {
	private static ArrayList<User> users;
	
	private static UserManager userManager;
	
	public UserManager() {
		ArrayList<Review> revList = new ArrayList<Review>();
		users = UserLoader.loadUsers();
	}	
	public static UserManager getInstance() {
		if(userManager == null) userManager = new UserManager();
		return userManager;
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public void addUser(User user) {
		users.add(user);
		writeUsers();
	}
	public void writeUsers() {
		UserWriter.writeUser();
	}
	public void removeUser(User user) {
		users.remove(user);
		writeUsers();
	}
	public boolean userTaken(User user) {
		boolean found = users.contains(user);
		return found;
	}
	public void print() {
		System.out.println("Printing Users");
		for(User x:users) {
			System.out.println(x.toString());
			System.out.println("_________________________________________");
		}		
	}
}
