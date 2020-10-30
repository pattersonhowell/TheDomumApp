import java.util.ArrayList;
import java.util.Scanner;

public class HousingDriver {
	
	private Systems systems = new Systems();
	public static Scanner kb = new Scanner(System.in);
	private User currentUser = null;
	private ListingManager listingManager= new ListingManager();
	
	public static void main(String[] args) {
	HousingDriver hd = new HousingDriver();
	hd.run();		
	}	
	
	private void run() {
		welcomePage();		
	}
		
	private void welcomePage() {		
		System.out.println("Welcome to Domum! Enter the number respective to the menu option you would like to choose:"
				+ "\n(1) Log in\n(2) Create account\n(3) Browse as guest\n"
				+ "(4) Quit Application");
		int option = kb.nextInt();		
		switch(option) {
			case 1:
				loginPage();
				break;
			case 2:
				createAccountPage();
				break;
			case 3:		
				homePage();
				break;
			case 4: 
				System.out.println("Thank You for using Domum");
				System.exit(0);
			case 5: // TODO Debug, remove once done
				System.out.println("Entering debug");
			default:
				System.out.println("Invalid menu option, returning to welcome page\n");
		}
	}
	
	private void loginPage() {
		kb = new Scanner(System.in);//java glitch 
		
		System.out.println("--Log in--\nEnter your first and last name separated by a space: ");
		String name = kb.nextLine();		
		 
		System.out.println("Please enter your password: ");
		String password = kb.nextLine();		
		
		if(systems.verifiedLogin(name, password)) {//if PW combo works 
			currentUser = systems.returnUserWithName(name);
		}
		else {
			System.out.println("Invalid login (1) Enter a different login, or (2) Return to welcome page");
			int option = kb.nextInt();			
			switch(option) {
			case 1:
				loginPage();
				break;
			case 2:
				welcomePage();
				break;
			default:
				System.out.println("Invalid menu option, returning to welcome page");
				welcomePage();
			}
		}
		homePage();
	}
	
	private void createAccountPage() {	
		kb = new Scanner(System.in);//java glitch
		System.out.println("Please enter your first and last name: ");
		kb.nextLine();
		String name = kb.nextLine(); 		
		
		System.out.println("Please enter a password: ");
		String password = kb.nextLine();		
		
		System.out.println("Please enter your address (Ex: 123 Love Street, Apt #2, Columbia, SC, 12345): ");
		String address = kb.nextLine();
		
		System.out.println("Please enter your phone number (no special characters): ");
		String phone = kb.nextLine();	
			
		
		System.out.println("Please enter your email: ");
		String email = kb.nextLine();				
		
		System.out.println("Are you a Student or an Agent");//branch depending on ans 
		String acctType = kb.nextLine();
		
		if(acctType.equalsIgnoreCase("Student")) {
			System.out.println("Enter Your Student ID");
			String studentID = kb.nextLine();					
			systems.signUpStudent(name, password, address, phone, email,studentID);					
		}
		else if (acctType.equalsIgnoreCase("Agent")){
			System.out.println("What Property Group are you with");
			String group = kb.nextLine();	
			System.out.println("Enter Your Agent ID");
			String agentID = kb.nextLine();
			systems.signUpAgent(name, password, address, phone, email,group,agentID);
		}		
		currentUser = systems.returnUserWithName(name);
	}

	private void homePage() {
		System.out.println("Welcome to the Domum home page!\nWould you like to \n(1) Browse all listings \n"
				+ "(2) Enter search preferences \n(3) Search listings by ID?"
				+"\n(4) Generate Application for a property"
				+ "\n(5) Return to the Welcome Page");			
		int option = kb.nextInt();		
		switch(option) {
			case 1:
				listingManager.printListings(listingManager.getListings());
				homePage();
				break;
			case 2: 
				searchInput(listingManager);	
				homePage();
				break;
			case 3:
				searchByID(listingManager);
				homePage();
				break;
			case 4: 
				generateApp();
				break;
			case 5:
				welcomePage();
			case 6:
				System.out.println("Entering debug"); // TODO Remove debug
				System.out.println("Adding new User to the manager");
//				Agent a = new Agent("39", "John Cena", "password", "1273 Rf St", "(864) 334-3949", "email@email.com", "Some Group LLC");
				systems.signUpAgent("John Cena", "password", "1273 Rf St", "(864) 334-3949", "email@email.com", "Some Group LLC", "39");
				System.out.println("Adding a new Listing");
				System.out.println("Printing the existing users");
				systems.printUserData();
				System.out.println("Printing ");
				break;
			default:
				System.out.println("Invalid menu option, returning to home page");		
				homePage();
		}
	}
	
	private void searchInput(ListingManager listingManager) {
		System.out.println("Listing Search:");
		System.out.println("What is your maximum price ?");
		Double price = kb.nextDouble();
		System.out.println("What is your minimum number of Bedrooms ?");
		int bed = kb.nextInt();
		System.out.println("What is the minimum number of Bathrooms ?");
		int bath = kb.nextInt();
		System.out.println("What is your maximum distance from campus ? (In Miles)");
		double distance = kb.nextDouble();
		System.out.println("Do you want to search for Units with Free Wifi ? (Enter true or false)");
		boolean wifi = kb.nextBoolean();
		System.out.println("Do you want to search for Units with a Washer and Dryer ? (Enter true or false)");
		boolean laundry = kb.nextBoolean();
		System.out.println("Do you want to search for Units that are pet friendly ? (Enter true or false)");
		boolean petFriendly = kb.nextBoolean();
		System.out.println("Do you want to search for Units that have a pool ? (Enter true or false)");
		boolean pool = kb.nextBoolean();
		System.out.println("Do you want to search for Units that are furnished ? (Enter true or false)");
		boolean furnished = kb.nextBoolean();					
		listingManager.comprehensiveSearch(price,bed,bath,distance,wifi,laundry,petFriendly,pool,furnished);		
	}	
		
	private void searchByID(ListingManager listingManager) {
		System.out.println("Please enter the listing ID: ");
		int id = kb.nextInt();
		listingManager.findListing(id);
	}	
	private void generateApp() {
		kb = new Scanner(System.in);//java glitch
		systems.printUserData();
		if(currentUser==null) {
			System.out.println("Sorry you must Log In before generating this application");			
		}
		else {
			System.out.println("What is the listingID of the property you wish to generate an application for?");
			int listingID = kb.nextInt();		
			
			if(listingManager.verifyID(listingID)) {
				listingManager.findListing(listingID).generateApplication(currentUser);			
			}
			System.out.println("Listing Generated, Please see TXT file");						
		}
	}	
}