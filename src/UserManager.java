import java.util.ArrayList;

public class UserManager {

	public ArrayList<User> users;
	
	public UserManager() {
		ArrayList<User> users = new ArrayList<User>();
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void removeUser(User user) {
		users.remove(user);
	}
	
	public boolean userTaken(User user) {
		boolean found = users.contains(user);
		return found;
	}
}
