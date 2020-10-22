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

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
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
