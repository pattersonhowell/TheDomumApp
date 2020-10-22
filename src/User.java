import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
	
	
	private String id;
	private String name;
	private String password;
	private String address;
	private String phone;
	private String email;
	public ArrayList<Review> reviews;
	
	public User(String id, String name, String password, String address, String phone, String email, ArrayList<Review> reviews) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.reviews = reviews;
	}
	
	public String toString() {
		return "ID: " + id + "\nName: " + name + "\nPassword: " + password + "\nAddress: " 
				+ address + "\nPhone: " + phone + "\nEmail: " + email;
	}
	
	public void generateUserAgreement() throws FileNotFoundException {
		
		Scanner fileIn = new Scanner(new File("LeasingAgreement.txt"));
		
		while(fileIn.hasNextLine()) {
			
			String userAgreement = fileIn.nextLine();
			System.out.println(userAgreement);
			
		}
		fileIn.close();
	}
	
	public void generateApplication() throws FileNotFoundException {
		
		Scanner fileIn = new Scanner(new File("Application.txt"));
		
		while(fileIn.hasNextLine()) {
			
			String application = fileIn.nextLine();
			System.out.println(application);
		}
		fileIn.close();
	}
	
}
