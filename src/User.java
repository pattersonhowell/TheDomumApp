import java.util.ArrayList;

public class User {

	private String id;
	private String name;
	private String password;
	private String address;
	private String phone;
	private String email;
	public ArrayList<Review> reviews;
	
	public String toString() {
		return "ID: " + id + "\nName: " + name + "\nPassword: " + password + "\nAddress: " 
				+ address + "\nPhone: " + phone + "\nEmail: " + email;
	}
	
}
