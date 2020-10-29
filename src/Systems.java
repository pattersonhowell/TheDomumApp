
import java.util.ArrayList;

public class Systems {

	
	private ListingManager listingManager;
	//private UserManager userManager;
	UserManager manager = UserManager.getInstance();
	
	public boolean verifiedLogin(String name, String password) {
		boolean exists = false;
		int index;
		String reqPassword;		
		for(int i = 0; i < manager.users.size(); i++) {
			if (manager.users.get(i).getName().equals(name)) {
				//System.out.println("found it");				
			reqPassword = manager.users.get(i).getPassword();			
			if (password.equalsIgnoreCase(reqPassword))
				exists = true;
				reqPassword = manager.users.get(i).getPassword();				
				if (password.equalsIgnoreCase(reqPassword))//REMOVE IGNNORE CASE ON FINAL VERSION-- USED TO MAKE TESTING EASIER
					exists = true;
			}
		}	
		return exists;
	}
	
	public void signUp(String name, String password, String address, String phone, String email) {				
		int id = 0; //users.size()+1;
		manager.addUser(id, name, password, address, phone, email);
		System.out.println(manager.users.size());
		System.out.println(manager.users);		
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
