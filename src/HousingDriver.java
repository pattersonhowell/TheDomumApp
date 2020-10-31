import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;


public class HousingDriver {
		private String[] welcomeMenuOptions = {"Log in", "Create Account","Browse as Guest"};
		private String[] mainMenuOptions = {"Browse All Listings","Enter Search Preferences","Search by Listing ID", "Generate Application","Generate Lease", "Leave a Listing Review", "(AGENTS ONLY) Upload a Listing", "(AGENTS ONLY) Remove a Listing", "Exit"};
		private Scanner kb;
		private Systems systems;
		private boolean loggedIn;
		private String realID; //using since we don't have a currentUser setup
		private boolean isAgent;

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
			kb.nextLine(); // Causes kb to move on to next line after taking an int -BD
			int command = input - 1;

			if(command >= 0 && command <= numCommands -1) return command;

			return -1;
		}

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
				realID = studentID; //using since we don't have a currentUser setup
				systems.signUpStudent(name, password, address, phone, email, studentID);
				System.out.println("\nAccount created!");
				loggedIn = true; //creating account should automatically log in
			}

			if(choice == 2) {
				System.out.println("Please enter your agent ID");
				String agentID = kb.next();
				kb.nextLine();
				realID = agentID; //using since we don't have a currentUser setup
				System.out.println("Please enter your real estate group");
				String group = kb.nextLine();

				systems.signUpAgent(name, password, address, phone, email, group, agentID);
				System.out.println("\nAccount created!");
				loggedIn = true; //creating account should automatically log in
				isAgent = true;

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
						generateLease();
						break;
					case(5):
						//System.out.println("we can leave review here");
						//System.out.println(java.time.LocalDate.now());
						leaveListingReview();
						break;
					case(6):
						uploadListing();
						break;
					case(7):
						removeListing();
						break;
					case(8):
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
			System.out.println(systems.listingID(id).toString());
		}

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

		private void leaveListingReview() {
			if(loggedIn == false) {
				System.out.println("Sorry you must Log In before leaving a listing review");
			}
			else {
				//ArrayList<Review> blueHouseRev = new ArrayList<Review>();
				//Review testRev = new Review(17, 5, "32342","10/11/20","The best");
				//blueHouseRev.add(testRev);


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

				//systems.listingManager.findListing(listingID).reviews.add(test2Rev);
				systems.listingManager.addListingReview(test2Rev, listingID);
				System.out.println("adding review");
				systems.listingManager.findListing(listingID).getReviews();




			}
		}
		
		private void uploadListing() {
			if(loggedIn == false || isAgent != true) {
				System.out.println("Sorry you must Log In before uploading a listing");
			}
			
			else {
				System.out.println("Upload Listing\nPLEASE ENTER THE FOLLOWING INFORMATION: ");
				System.out.println("Enter Listing ID: ");
				
				int listingID = kb.nextInt();
				kb.nextLine();
			
				//System.out.println("Enter your ID: ");
				//String yourID = kb.nextLine();
			
			
				System.out.println("Enter Listing Address: ");
				String address = kb.nextLine();
				
			
				System.out.println("Enter Year Built: ");
				int yearBuilt = kb.nextInt();
				kb.nextLine();
			
			
				System.out.println("Enter Distance from Campus (in miles)");
				double distance = kb.nextDouble();
				kb.nextLine();
			
			
				System.out.println("Free Wifi? (true or false");
				boolean wifi = kb.nextBoolean();
				kb.nextLine();
			
			
				System.out.println("Washer and Dryer in Room? (true or false");
				boolean laundry = kb.nextBoolean();
				kb.nextLine();
			
			
				System.out.println("Pet Friendly? (true or false");
				boolean petFriendly = kb.nextBoolean();
				kb.nextLine();
			
			
				System.out.println("Has Pool? (true or false");
				boolean pool = kb.nextBoolean();
				kb.nextLine();
				
			
				System.out.println("Pre-furnished? (true or false");
				boolean furnished = kb.nextBoolean();
				kb.nextLine();
				
				
				
				System.out.println("How many Suite Types are there?");
				int suiteTypes = kb.nextInt();
				kb.nextLine();
				
				for(int i = 0; i < suiteTypes; i++) {
					
					System.out.println("Enter Listing Price: ");
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
					
					systems.listingManager.findListing(listingID).addSuite(addedSuite);
					
					Listing agentListing = new Listing(listingID, realID, price, address, numBedrooms, numBathrooms, systems.listingManager.findListing(listingID).getSuites(),
							numAvailibilities, yearBuilt, distance, wifi, laundry, petFriendly, pool, furnished);
					
					
					systems.listingManager.agentUploadListing(agentListing);
					
					System.out.println(systems.listingManager.findListing(listingID).toString());
					
				}
			
				//Listing agentListing = new Listing(listingID, realID, price, address, numBedrooms, numBathrooms, addSuite,
						//numAvailibilities, yearBuilt, distance, wifi, laundry, petFriendly, pool, furnished);
				
				
			
				
			
				//systems.listingManager.agentUploadListing(agentListing);
			
				//System.out.println(systems.listingManager.findListing(listingID).toString());
			
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
		
		
		/*in student menu, say option 0 is add a roommate
		 * switch(option)
		 * 		case(0):
		 * 				addRoommate();
		 * 				break;
		*/
		public void addRoommate() {
			System.out.println("Enter the username of your roommate:");
			String roommateName = kb.nextLine();
			boolean exists = systems.verifiedUser(roommateName);
			if(exists)
				System.out.println(roommateName+" is now set as your roommate!");
		}
}
