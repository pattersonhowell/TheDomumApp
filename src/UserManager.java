import java.util.ArrayList;

public class UserManager {
	private static int i = 0;

	
	public ArrayList<User> users;
	
	public static UserManager userManager;
	
	public UserManager() {
		users = new ArrayList<User>();
	}
	
	public static UserManager getInstance() {
		if(userManager == null) userManager = new UserManager();
		return userManager;
	}
	
	public int addUser(int id, String name, String password, String address, String phone, String email) {
		User user = new User(i+1, name, password, address, phone, email);
		users.add(user);
		i++;
		return i-1;
	}
	
	public void removeUser(User user) {
		users.remove(user);
	}
	
	public boolean userTaken(User user) {
		boolean found = users.contains(user);
		return found;
	}
}
