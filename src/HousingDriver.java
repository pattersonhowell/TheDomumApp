import java.util.ArrayList;
import java.util.Scanner;


public class HousingDriver {
		private String[] welcomeMenuOptions = {"Log in", "Create Account","Browse as Guest"};		
		private String [] agentMenu = { "Upload a Listing", "Remove a Listing", "View your listings ","Exit"};
		private String [] studentMenu = {"Browse All Listings","Enter Search Preferences","Search by Listing ID", "Generate Application","Generate Lease", "Leave a Listing Review","Browse Reviews By ID", "Add a roomate","Exit"};
		private Scanner kb;
		private Systems systems;
		private boolean loggedIn;
		private String realID = null; //using for verification 
		private boolean isAgent;
		private ArrayList<Suite> suiteList;
		private ArrayList<Review> reviews;

		HousingDriver() {
			kb = new Scanner(System.in);
			systems = new Systems();
			loggedIn = false;
		}	
		public static void main(String[] args) {
			HousingDriver domumInterface = new HousingDriver();
			domumInterface.run();			
		}
		/**
		 * Method that launches app 
		 */
		public void run() {
			System.out.println("Welcome to Domum!");
			welcomeMenu();	
			branchMenu();
		}			
		/**
		 * Method prompting the user, to sign up, login, or quit 
		 */
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
						studentMenu();				
						return;
				}
			}
		}
		/**
		 * This method automatically branches the program depending on if a student or agent is using it 
		 */
		private void branchMenu() {
			if(realID==null) {
				System.out.println("Please Sign Up or log in");
				return;
			}			
			if(systems.isStudent(realID)) {
				studentMenu();
			}
			else {
				agentMenu();
			}		
		}
		/**
		 * This method prompts user for credentials then checks to see if They are a verified user 
		 */
		private void logIn() {
			System.out.println("--Log in--\nEnter your first and last name: ");
			String name = kb.nextLine();

			System.out.println("Please enter your password: ");
			String password = kb.nextLine();

			boolean verified = systems.verifiedLogin(name, password);
			if(verified) {
				loggedIn = true;
				realID = systems.returnID(name, password);
			}
		}
		/**
		 * This method prompts user for credentials then creates the respective account 
		 */
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
				kb.nextLine();
				realID = studentID; //(verification)
				systems.signUpStudent(name, password, address, phone, email, studentID);
				System.out.println("\nAccount created!");
				loggedIn = true; //creating account should automatically log in
			}

			if(choice == 2) {
				System.out.println("Please enter your agent ID");
				String agentID = kb.next();
				kb.nextLine();
				realID = agentID; //(verification)
				System.out.println("Please enter your real estate group");
				String group = kb.nextLine();

				systems.signUpAgent(name, password, address, phone, email, group, agentID);
				System.out.println("\nAccount created!");
				loggedIn = true; //creating account should automatically log in
				isAgent = true;
			}
		}
		/**
		 * Method that is repeatedly used to take in user input 
		 * @param numCommands
		 * @return
		 */
		private int getUserCommand(int numCommands) {
			System.out.println("What would you like to do?: ");

			int input = kb.nextInt();
			kb.nextLine(); // Causes kb to move on to next line after taking an int -BD
			int command = input - 1;

			if(command >= 0 && command <= numCommands -1) return command;

			return -1;
		}
		/**
		 * Agent menu allowing the agent to Upload a Listing, Remove a Listing, or Exit
		 */
		private void agentMenu() {
			while(true) {
				System.out.println("Agent Menu");
				for(int i=0; i< agentMenu.length; i++) {
					System.out.println((i+1) + ". " + agentMenu[i]);
					}		
				int userCommand = getUserCommand(welcomeMenuOptions.length);
				
				switch(userCommand) {

				case(0):
					uploadListing();
					break;					
				case(1):
					removeListing();
					break;
				case(2):
					//implement later
					break;
				case (3):
					System.out.println("Thank you for using domum: Goodbye");
					System.exit(0);
					return;
				}	
			}							
		}		
		/**
		 * Student menu allowing students to Browse All Listings,
		 * Enter Search Preferences,Search by Listing ID, Generate Application,
		 * Generate Lease, Leave a Listing Review,Browse Reviews By ID, Add a roomate,Exit};
		 */
		private void studentMenu() {
			while(true) {
				System.out.println("Student Menu");
				for(int i=0; i< studentMenu.length; i++) {
					System.out.println((i+1) + ". " + studentMenu[i]);
					}		
				int userCommand = getUserCommand(studentMenu.length);				
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
				case (3):
					generateApp();
					break;
					
				case(4):
					generateLease();				
					break;
				case(5):
					leaveListingReview();
					break;
				case(6):
					browseReviewsByID();
					break;
				case(7):
					addRoommate();
					break;				
				case (8):
					System.out.println("Thank you for using Domum: Goodbye!");
					System.exit(0);										
				}

			}
		}	
		/**
		 * Method prompts user for input to return the corosponding listings 
		 */
		private void searchInput() {
			System.out.println("Listing Search: ");
			System.out.println("What is your maximum price ?");
			Double price = kb.nextDouble();

			System.out.println("What is your number of Bedrooms ?");
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
			
			System.out.println("Do you want to search for Units that have a gym ? (Enter true or false)");
			boolean gym = kb.nextBoolean();

			System.out.println("Do you want to search for Units that are furnished ? (Enter true or false)");
			boolean furnished = kb.nextBoolean();

			systems.comprehensiveSearch(price,bed,bath,distance,wifi,laundry,petFriendly,pool, gym, furnished);
		}
		/**
		 * Method prompts returns the listing with the corrosponding Listing ID
		 */
		private void searchByID() {
			System.out.println("Please enter the listing ID: ");
			int id = kb.nextInt();
			
			systems.listingManager.findListing(id).suiteBuilder();
			System.out.println(systems.listingID(id));
		}
		/**
		 * Method generates an application if the user is logged in, prompts the user for a listing ID
		 */
		private void generateApp() {
			//systems.printUserData();
			if(loggedIn==false) {
				System.out.println("Sorry you must Log In before generating this application");
			}
			else {
				System.out.println("What is the listingID of the property you wish to generate an application for?");
				int listingID = kb.nextInt();
				//System.out.println("What is Your studentID");//maybe pass in an instance of user later, but use this for now -KH
				//String studentID = kb.next(); DONT NEED THIS
				systems.generateApp(listingID,realID);
			}
		}
		/**
		 * Method generates an lease if the user is logged in, prompts the user for a listing ID
		 */
		private void generateLease() {
			if(loggedIn==false) {
				System.out.println("Sorry you must Log In before generating this application");
			}
			else {
				System.out.println("What is the listingID of the property you wish to generate an application for?");
				int listingID = kb.nextInt();
				systems.generateLease(listingID, realID);
			}
		}
		/**
		 * Method allows a user to leave a review on a listing 
		 */
		private void leaveListingReview() {
			if(loggedIn == false) {
				System.out.println("Sorry you must Log In before leaving a listing review");
			}
			else {
	
				System.out.println("What is the listingID of the property you wish to leave a review for?");
				int listingID = kb.nextInt();
				kb.nextLine();

				System.out.println("Enter a Rating (0-10)");
				int listRating = kb.nextInt();
				kb.nextLine();

				System.out.println("Type your Review Message here: ");
				String reviewMessage = kb.nextLine();

				String date = java.time.LocalDate.now().toString();

				Review test2Rev = new Review(listingID, listRating, realID, date, reviewMessage);

				System.out.println("adding review");
				systems.listingManager.addListingReview(test2Rev, listingID);
				
				systems.listingManager.findListing(listingID).printReviews();
				
			}
		}
		/**
		 * Method allows user to enter a listing ID and see the reviews 
		 */
		private void browseReviewsByID() {
			
			System.out.println("Please enter the listing ID: ");
			int id = kb.nextInt();
			
			systems.listingManager.findListing(id).printReviews();
		}
		/**
		 * Method is used for an agent to upload a listing 
		 */		
		private void uploadListing() {
			suiteList = new ArrayList<Suite>();
			reviews = new ArrayList<Review>();
			
			
			if(loggedIn == false ) { 
				System.out.println("Sorry you must Log In before uploading a listing");
			}
			
			else {
				System.out.println("Upload Listing\nPLEASE ENTER THE FOLLOWING INFORMATION: ");
				
				System.out.println("___________________________________________________________");
				
				System.out.println("Enter Name of Complex: ");
				String name = kb.nextLine();
				
				System.out.println("Enter Listing ID: ");
				
				int listingID = kb.nextInt();
				kb.nextLine();
			

				System.out.println("Enter Listing Address: ");
				String address = kb.nextLine();
				
			
				System.out.println("Enter Year Built: ");
				int yearBuilt = kb.nextInt();
				kb.nextLine();
			
			
				System.out.println("Enter Distance from Campus (in miles)");
				double distance = kb.nextDouble();
				kb.nextLine();
			
			
				System.out.println("Free Wifi? (true or false)");
				boolean wifi = kb.nextBoolean();
				kb.nextLine();
						
				System.out.println("Washer and Dryer in Room? (true or false)");
				boolean laundry = kb.nextBoolean();
				kb.nextLine();
						
				System.out.println("Pet Friendly? (true or false)");
				boolean petFriendly = kb.nextBoolean();
				kb.nextLine();			
			
				System.out.println("Has Pool? (true or false)");
				boolean pool = kb.nextBoolean();
				kb.nextLine();
				
				System.out.println("Has Gym? (true or false)");
				boolean gym = kb.nextBoolean();
				kb.nextLine();
				
				System.out.println("Pre-furnished? (true or false)");
				boolean furnished = kb.nextBoolean();
				kb.nextLine();
				
				
				
				System.out.println("How many Suite Types are there?");
				int suiteTypes = kb.nextInt();
				kb.nextLine();
				
				for(int i = 0; i < suiteTypes; i++) {
					
					System.out.println("Enter Listing Suite " + (i+1) + " Price: ");
					double price = kb.nextDouble();
					kb.nextLine();
					
					System.out.println("Enter the Number of Bedrooms: ");
					int numBedrooms = kb.nextInt();
					kb.nextLine();
				
				
					System.out.println("Enter the Number of Bathrooms: ");
					int numBathrooms = kb.nextInt();
					kb.nextLine();
				
				
					System.out.println("Enter number of availabilities: ");
					int numAvailibilities = kb.nextInt();
					kb.nextLine();
					
					Suite addedSuite = new Suite(listingID, numBedrooms, numBathrooms, numAvailibilities, price);
					
					suiteList.add(addedSuite);
					
					
				}			
				Listing agentListing = new Listing(name, listingID, realID, address, reviews, suiteList,
						 yearBuilt, distance, wifi, laundry, petFriendly, pool, gym, furnished);
	
				systems.listingManager.agentUploadListing(agentListing);
				
				systems.listingManager.findListing(listingID).suiteBuilder();
				
				System.out.println("____________________________________________________");
				System.out.println("ADDED NEW COMPLEX AND SUITES WERE ADDED");
				System.out.println("____________________________________________________");
		
				System.out.println(systems.listingManager.findListing(listingID).toString());
			
			}			
		}		
		/**
		 * Method allows an agnet to remove a listing if they are loggedin and a listing ID is given
		 */
		public void removeListing() {
			if(loggedIn == false || isAgent != true) {
				System.out.println("Sorry you must Log In before removing a listing");
			}
			else {
				System.out.println("Enter the listingID to remove the listing");
				int listingID = kb.nextInt();
				systems.removeListing(listingID);
			}
		}				
		/**
		 * Method checks to see if a certain user is in the system and capable of being a student's roomate
		 */
		public void addRoommate() {
			if(loggedIn) {
				System.out.println("Enter the username of your roommate:");
				String roommateName = kb.nextLine();
				boolean exists = systems.verifiedUser(roommateName);
				if(exists)
					System.out.println(roommateName+" is now set as your roommate!");
			} 
			else {
				System.out.println("Please Log In first");
			}
			
		}
}
