import java.util.ArrayList;

public class UserManager {
	public ArrayList<User> users = new ArrayList<User>();
	
	public static UserManager userManager;
	
	public UserManager() {//hardcoded these users in for now 1 student and 1 agent 
		ArrayList<Review> revList = new ArrayList<Review>();		
		Student todd = new Student("23423","Todd","pass","505 Shoe Lane","6021112324","ToddSMith@gmail.com");
		users.add(todd);				
	
		Agent mike = new Agent("123","Agent Mike", "234%%#f", "address","3433234234", "ToddSMith@gmail.com","realityGroup");
		users.add(mike);		
	}	
	public static UserManager getInstance() {
		if(userManager == null) userManager = new UserManager();
		return userManager;
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
	


	
	
	public void print() {
		System.out.println("Printing Users");
		for(User x:users) {
			System.out.println(x.toString());
			System.out.println("_________________________________________");
		}		
	}
}
