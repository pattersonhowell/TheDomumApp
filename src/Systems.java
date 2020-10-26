
import java.util.ArrayList;

public class Systems {

	//private ArrayList<User> users;
	private ListingManager listingManager;
	//private UserManager userManager;
	UserManager manager = UserManager.getInstance();
	
	public boolean verifiedLogin(String name, String password) {
		boolean exists = false;
		int index;
		String reqPassword;
		
		for(int i = 0; i < manager.users.size(); i++) {
			if (manager.users.get(i).getName().contains(name)) {
				System.out.println("found it");
				//index = i;

				reqPassword = manager.users.get(i).getPassword();
				
				if (password.equals(reqPassword))
					exists = true;

			}
		}
	
		return exists;
	}
	
	public void signUp(String name, String password, String address, String phone, String email) {
		
		UserManager manager = UserManager.getInstance();
		
		int id = 0; //users.size()+1;

		ArrayList<Review> reviews = new ArrayList<Review>();

		
		//User newUser = new User(id, name, password, address, phone, email);//reviews);
		manager.addUser(id, name, password, address, phone, email);
		System.out.println(manager.users.size());
		System.out.println(manager.users.get(0).getName());
		
	}
	
	public ArrayList<Listing> browseAnonymously(){
		ArrayList<Listing> ret = new ArrayList<>();
		return ret;
	}
	
	public void deleteAccount(String name, String password) {
		int index = manager.users.indexOf(name);
		manager.users.remove(index);
	}
}
