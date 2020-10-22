import java.util.ArrayList;

public class Systems {

	private ArrayList<User> users;
	private ListingManager listingManager;
	private UserManager userManager;
	
	public boolean verifiedLogin(String name, String password) {
		boolean exists = false;
		int index;
		String reqPassword;
		
		if (users.contains(name)) {
			index = users.indexOf(name);
			reqPassword = users.get(index).getPassword();
			
			if (password.equals(reqPassword))
				exists = true;
		}
		return exists;
	}
	
	public void signUp(String name, String password, String address, String phone, String email) {
		int id = users.size()+1;
		ArrayList<Review> reviews = new ArrayList<Review>();
		
		User newUser = new User(id, name, password, address, phone, email, reviews);
	}
	
	public ArrayList<Listing> browseAnonymously(){
		ArrayList<Listing> ret = new ArrayList<>();
		return ret;
	}
	
	public void deleteAccount(String name, String password) {
		int index = users.indexOf(name);
		users.remove(index);
	}
}
