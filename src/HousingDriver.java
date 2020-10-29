import java.util.Scanner;


public class HousingDriver {
		private String[] welcomeMenuOptions = {"Log in", "Create Account","Browse as Guest"};
		private String[] mainMenuOptions = {"Browse All Listings","Enter Search Preferences","Search by Listing ID", "Generate Application","Exit"};
		private Scanner kb;
		private Systems systems;
		private boolean loggedIn;
		
		HousingDriver() {
			kb = new Scanner(System.in);
			systems = new Systems();
			loggedIn = false;
		}
		
		public static void main(String[] args) {
			HousingDriver domumInterface = new HousingDriver();
			domumInterface.run();
		}
		
		public void run() {
			System.out.println("Welcome to Domum!");
			welcomeMenu();
			mainMenu();
		}
		
		private int getUserCommand(int numCommands) {
			System.out.println("What would you like to do?: ");
			
			int input = kb.nextInt();
			int command = input - 1;
			
			if(command >= 0 && command <= numCommands -1) return command;
			
			return -1;
		}
		
		private void logIn() {
			
			System.out.println("--Log in--\nEnter your first and last name: ");
			String name = kb.next();
			kb.nextLine();
			
			System.out.println("Please enter your password: ");
			String password = kb.next();
			
			boolean verified = systems.verifiedLogin(name, password);
				
			if(verified) {
				loggedIn = true;
			}
		}
		
		private void createAccount() {
			System.out.println("Would you like to register as a (1) student or (2) agent?");
			int choice = kb.nextInt();
			
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
		
			if(choice == 1) {
				System.out.println("Please enter your student ID");
				String studentID = kb.next();
				systems.signUpStudent(name, password, address, phone, email, studentID);
				System.out.println("\nAccount created!");
			}
			
			if(choice == 2) {
				System.out.println("Please enter your agent ID");
				String agentID = kb.next();
				
				System.out.println("Please enter your real estate group");
				String group = kb.nextLine();
				
				
				systems.signUpAgent(name, password, address, phone, email, group, agentID);
				System.out.println("\nAccount created!");
			}
		}
		
		private void mainMenu() {
			
			while(true) {
				
				System.out.println("\n--Main Menu--");
				for(int i=0; i< mainMenuOptions.length; i++) {
					System.out.println((i+1) + ". " + mainMenuOptions[i]);
				}
				System.out.println("\n");
				
				int userCommand = getUserCommand(mainMenuOptions.length);
				
				if(userCommand == -1) {
					System.out.println("Not a valid command");
				}
				
				switch(userCommand) {
					case(0):
						systems.printListings();
						break;
					case(1):
						searchInput();
						break;
					case(2):
						searchByID();
						break;
					case(3):
						generateApp();
						break;
					case(4):
						System.out.println("Goodbye! Thanks for using Domum");
						System.exit(0);
				}			
			}
		}
		
		private void searchInput() {
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
			
			systems.comprehensiveSearch(price,bed,bath,distance,wifi,laundry,petFriendly,pool,furnished);		
		}	
		
		private void searchByID() {
			System.out.println("Please enter the listing ID: ");
			int id = kb.nextInt();
			systems.listingID(id);
		}
		
		private void generateApp() {
			systems.printUserData();
			if(loggedIn==false) {
				System.out.println("Sorry you must Log In before generating this application");			
			}
			else {
				System.out.println("What is the listingID of the property you wish to generate an application for?");
				int listingID = kb.nextInt();
				System.out.println("What is Your studentID");//maybe pass in an instance of user later, but use this for now -KH
				String studentID = kb.next();	
			}
		}
		
		private void welcomeMenu() {
			while(true) {
				System.out.println("\n--Welcome Menu--");
				for(int i=0; i< welcomeMenuOptions.length; i++) {
				System.out.println((i+1) + ". " + welcomeMenuOptions[i]);
				}
				System.out.println("\n");

				int userCommand = getUserCommand(welcomeMenuOptions.length);

				if(userCommand == -1) {
					System.out.println("Not a valid command");
				}

				switch(userCommand) {
					case(0):
						logIn();
						if(loggedIn)
							return;
						else
							System.out.println("Invalid login, returning to welcome page");
							break;
					case(1):
						createAccount();
						return;
					case(2):
						return;
				}
			}
		}
}
