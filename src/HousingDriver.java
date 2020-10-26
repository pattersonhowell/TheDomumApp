import java.util.Scanner;

public class HousingDriver {
	private Systems systems = new Systems();
	public Scanner kb = new Scanner(System.in);
	
	public HousingDriver() {};
	
	public static void main(String[] args) {
		HousingDriver driver = new HousingDriver();
		driver.run();
	}
	
	public void run() {
		
		
		System.out.println("Welcome to Domum! Enter the number respective to the menu option you would like to choose:\n(1) Log in\n(2) Create account\n(3) Browse as guest\n");
		int option = kb.nextInt();
		
		switch(option) {
			case 1:
				kb.nextLine();
				loginPage();
				break;
			case 2:
				createAccountPage();
				break;
			case 3:
				homePage();
				break;
			default:
				System.out.println("Invalid menu option, returning to welcome page\n");
				run();
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
				loginPage();
				break;
			case 2:
				run();
				break;
			default:
				System.out.println("Invalid menu option, returning to welcome page");
				run();
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
		loginPage();
	}

	private void homePage() {
		ListingManager listingManager = new ListingManager();
		System.out.println("Welcome to the Domum home page!\nWould you like to (1) Browse all listings, (2) Enter search preferences, or (3) Search listings by ID?");
		int option = kb.nextInt();
		
		switch(option) {
			case 1:
				listingManager.showAllListings();
				break;
			case 2: 
				//start search survey
				break;
			case 3:
				System.out.println("Please enter the listing ID: ");
				int id = kb.nextInt();
				listingManager.findListing(id);
				break;
			default:
				System.out.println("Invalid menu option, returning to home page");
				homePage();
		}
	}
}
