import java.util.Scanner;

public class HousingDriver {
	private Systems systems = new Systems();
	public UserManager userManager = new UserManager();
	public Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {
		run();
	}
	
	public void run() {
		
		System.out.println("Welcome to Domum! Enter the number respective to the menu option you would like to choose:\n1. Log in\n2. Create account\n3. Browse as guest\n");
		int option = kb.nextInt();
		
		switch(option) {
			case 1:
				loginPage();
				break;
			case 2:
				createAccountPage();
				break;
			case 3:
				//continue browse as guest
				break;
			default:
				System.out.println("Invalid menu option, returning to welcome page\n");
				run();
		}
		
		
	}
	
	private void loginPage() {
		System.out.println("Log in:\nEnter your username: ");
		String username = kb.next();
		//create temp user
		boolean taken = userManager.userTaken(user);
		
		if(taken == true) {
			System.out.println("Username: " + username + "\nPlease enter your password: ");
			String password = kb.next();
			boolean verified = systems.verifiedLogin(username, password);
			
			if(verified ==true)
				homePage();
			else {
				System.out.println("Invalid password for user: " + user);
				loginPage();
			}
		}
		else {
			System.out.println("That username isn't associated with an account\n1. Enter a different username\n2. Create new account");
			int option = kb.nextInt();
			
			switch(option) {
				case 1: 
					loginPage();
				case 2: 
					createAccountPage();
				default:
					System.out.println("Invalid choice, returning to login page\n");
					loginPage();
			}
		}
	}
	
	private void createAccountPage() {
		System.out.println("Create account:\nPlease enter your name: ");
		String name = kb.next();
		System.out.println("Please enter a password: ");
		String password = kb.next();
		System.out.println("Please enter your address (Ex: 123 Love Street, Apt #2, Columbia, SC, 12345): ");
		String address = kb.next();
		System.out.println("Please enter your phone number (no special characters): ");
		String phone = kb.next();
		System.out.println("Please enter your email: ");
		String email = kb.next();
		
		systems.signUp(name, password, address, phone, email);
	}

}
