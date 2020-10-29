
import java.util.ArrayList;

public class Systems {

	
	private ListingManager listingManager;
	//private UserManager userManager;
	UserManager manager = UserManager.getInstance();	
	public boolean verifiedLogin(String name, String password) {	
		for(User x: manager.users) {
			if(x.getName().equalsIgnoreCase(name) && x.getPassword().equalsIgnoreCase(password)) {
				return true;
			}			
		}
		return false;		
	}	
	
	public void signUpStudent(String name, String password, String address, String phone, String email, String studentID) {
		Student newStudent = new Student(studentID,name,password,address,phone,email);	
		manager.addUser(newStudent);
	}
	public void signUpAgent(String name, String password, String address, String phone, String email, String group,String agentID) {
		
		Agent newAgent = new Agent(agentID,name,password,address,phone,email,group);		
		manager.addUser(newAgent);
	}
	
	
	
	public ArrayList<Listing> browseAnonymously(){
		ArrayList<Listing> ret = new ArrayList<>();
		return ret;
	}
	
	public void deleteAccount(String name, String password) {
		int index = manager.users.indexOf(name);
		manager.users.remove(index);
	}	
	
	public void printUserData() {//Only here for debug
		System.out.println("We have "+manager.users.size()+" users");		
		for(int i = 0; i < manager.users.size(); i++) {
			for(User x: manager.users) {
				System.out.println(x.getName()+ " "+x.getPassword());
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
