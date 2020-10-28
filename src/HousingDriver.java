import java.util.ArrayList;
import java.util.Scanner;

public class HousingDriver {
	
	private Systems systems = new Systems();
	public Scanner kb = new Scanner(System.in);
	private boolean welcome;
	private boolean login;
	private boolean home;
	
	public HousingDriver() {
		welcome = false;
		login = false;
		home = false;
	}
	
	public static void main(String[] args) {
		HousingDriver driver = new HousingDriver();
		driver.run();	
		
	}	
	public void run() {		
		while (!welcome) {
			welcomePage();
		}		
		while (!login) {
			loginPage();
		}
		
		while (!home) {
			homePage();
		}
	}
	
	private void welcomePage() {		
		System.out.println("Welcome to Domum! Enter the number respective to the menu option you would like to choose:\n(1) Log in\n(2) Create account\n(3) Browse as guest\n");
		int option = kb.nextInt();		
		switch(option) {
			case 1:
				kb.nextLine();
				welcome = true;
				break;
			case 2:
				createAccountPage();
				break;
			case 3:
				welcome = true;
				login = true;
				break;
			default:
				System.out.println("Invalid menu option, returning to welcome page\n");
		}
	}
	
	private void loginPage() {
		System.out.println("--Log in--\nEnter your first and last name separated by a space: ");
		String name = kb.nextLine();
		
		System.out.println("Please enter your password: ");
		String password = kb.next();
		kb.nextLine();
		
		
		boolean verified = systems.verifiedLogin(name, password);
		
		if(verified == true)
			homePage();
		else {
			System.out.println("Invalid login (1) Enter a different login, or (2) Return to welcome page");
			int option = kb.nextInt();
			
			switch(option) {
			case 1:
				kb.nextLine();
				break;
			case 2:
				welcomePage();
				break;
			default:
				System.out.println("Invalid menu option, returning to welcome page");
				welcomePage();
			}
		}
	}
	
	private void createAccountPage() {
		System.out.println("--Create account--\nPlease enter your first and last name: ");
		kb.nextLine();
		String name = kb.nextLine(); 		
		
		System.out.println("Please enter a password: ");
		String password = kb.next();
		kb.nextLine();
		
		System.out.println("Please enter your address (Ex: 123 Love Street, Apt #2, Columbia, SC, 12345): ");
		String address = kb.nextLine();
		
		System.out.println("Please enter your phone number (no special characters): ");
		String phone = kb.next();
		kb.nextLine();
		
		System.out.println("Please enter your email: ");
		String email = kb.next();
		kb.nextLine();			
		
		systems.signUp(name, password, address, phone, email);
		welcome = true;
	}

	private void homePage() {
		ListingManager listingManager= new ListingManager();
		double price;
		double distance;
		
		int bath;
		int bed;
		int yearBuilt;
		
		System.out.println("Welcome to the Domum home page!\nWould you like to (1) Browse all listings, (2) Enter search preferences, or (3) Search listings by ID?");
		int option = kb.nextInt();
		
		switch(option) {
			case 1:
				listingManager.printListings(listingManager.listings);
				break;
			case 2: 
				searchInput(listingManager);				
				break;
			case 3:
				System.out.println("Please enter the listing ID: ");
				int id = kb.nextInt();
				listingManager.findListing(id);
				break;
			default:
				System.out.println("Invalid menu option, returning to home page");				
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

	
}
