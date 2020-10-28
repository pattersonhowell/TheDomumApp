import java.util.Scanner;


public class HousingDriver {
		private String[] welcomeMenuOptions = {"Log in", "Create Account","Browse as Guest"};
		private String[] mainMenuOptions = {"Browse All Listings","Enter Search Preferences","Search by Listing ID","Logout"};
		private Scanner kb;
		private Systems systems;
		private boolean loggedIn;
		
		HousingDriver(){
			kb = new Scanner(System.in);
			systems = new Systems();
			loggedIn = false;
		}
		
		public void run() {
			System.out.println("Welcome to Domum!");
		outer:
			while(true) {
			inner:
				while(true) {
					displayWelcomeMenu();
					
					int userCommand = getUserCommand(welcomeMenuOptions.length);
					
					if(userCommand == -1) {
						System.out.println("Not a valid command");
					}
					
					switch(userCommand) {
							case(0):
								
									logIn();
									if(logIn() == 0) 
										break inner;
									if(logIn() == 1)
										break;
							case(1):
									createAccount();
									break;
							case(2):
									break inner;
					}
				}
			
			displayMainMenu();
				
			int userCommand = getUserCommand(mainMenuOptions.length);
				
			if(userCommand == -1) {
				System.out.println("Not a valid command");
		}
			if(userCommand == mainMenuOptions.length -1) break;
				
			switch(userCommand) {
					case(0):
							listingManager.printListings();
							break;
					case(1):
							fullSearch();
							break;
					case(2):
							searchByID();
							break;
			}
			
		}
			
			System.out.println("Goodbye! Thanks for using Domum");
	}
		
		private void displayWelcomeMenu() {
			System.out.println("\n--Welcome Menu--");
			for(int i=0; i< welcomeMenuOptions.length; i++) {
				System.out.println((i+1) + ". " + welcomeMenuOptions[i]);
			}
			System.out.println("\n");
		}
		
		private int getUserCommand(int numCommands) {
			System.out.println("What would you like to do?: ");
			
			String input = kb.nextLine();
			int command = Integer.parseInt(input) - 1;
			
			if(command >= 0 && command <= numCommands -1) return command;
			
			return -1;
		}
		
		private int logIn() {
			
			while(true) {
				System.out.println("--Log in--\nEnter your first and last name separated by a space: ");
				String name = kb.nextLine();
				
				System.out.println("Please enter your password: ");
				String password = kb.next();
				kb.nextLine();
				
				
				boolean verified = systems.verifiedLogin(name, password);
				
				if(verified == true) {
					loggedIn = true;
					return 0;
				}
					
				else {
					System.out.println("Invalid login, returning to welcome page");
					return 1;
					}
				}
			}
		
		private void createAccount() {
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
		}
		
		private void displayMainMenu() {
			System.out.println("\n--Main Menu--");
			for(int i=0; i< mainMenuOptions.length; i++) {
				System.out.println((i+1) + ". " + mainMenuOptions[i]);
			}
			System.out.println("\n");
		}
		
		private void fullSearch() {
			//todo
		}
		
		private void searchByID() {
			System.out.println("Please enter the listing ID: ");
			int id = kb.nextInt();
			listingManager.findListing(id);
		}
		
		public static void main(String[] args) {
			HousingDriver domumInterface = new HousingDriver();
			domumInterface.run();
		}
}
