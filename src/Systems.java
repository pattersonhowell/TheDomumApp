import java.util.ArrayList;

public class Systems {

	private ArrayList<String> users;
	private ListingManager listingManager;
	private UserManager userManager;
	
	public boolean verifiedLogin(String name, String password) {
		return true;
	}
	
	public void signUp(String name, String password, String address, String phone, String email) {
		
	}
	
	public ArrayList<Listing> browseAnonymously(){
		ArrayList<Listing> ret = new ArrayList<>();
		return ret;
	}
	
	public void deleteAccount(String name, String password) {
		
	}
}
