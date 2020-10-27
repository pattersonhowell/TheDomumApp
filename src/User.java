import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
	
	
	private int id;
	private String name;
	private String password;
	private String address;
	private String phone;
	private String email;
	public ArrayList<Review> reviews;
	
	public User(int id, String name, String password, String address, String phone, String email)  {// ArrayList<Review> reviews) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.email = email;
		//this.reviews = reviews;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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
	
	public void generateLease() {		
		try {	
			File fileRead  = new File("/DomumApp/src/LeasingAgreement.txt");
			File fileWrite  = new File("/DomumApp/src/LeasingAgreement"+"test");
			Scanner scan = new Scanner(fileRead);		
			if (!fileWrite.exists()) {//create new file for lease to be shown 
				fileWrite.createNewFile();
			  }	
			FileWriter file = new FileWriter(fileWrite);
		    BufferedWriter output = new BufferedWriter(file);		      
		    String line ="";
		    while(scan.hasNextLine()) {
		    	line = scan.nextLine();
		    	
		    	
		    	
		    	if(line.contains("Agent:")) {
		    		
		    	}
		    	if(line.contains("Agent:")) {
		    		
		    	}		    	
		    	if(line.contains("Agent:")) {
		    		
		    	}
		    	if(line.contains("Agent:")) {
		    		
		    	}		    		
		    	if(line.contains("Agent:")) {
		    		
		    	}		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	output.write(line+"\n");
		    	  		    		    	    	
		    }
		    output.close();//close IO devices
		    scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	public void generateApplication()  {
		try {	
			File fileRead  = new File("/DomumApp/src/Application.txt");
			File fileWrite  = new File("/DomumApp/src/Application"+"test");
			Scanner scan = new Scanner(fileRead);		
			if (!fileWrite.exists()) {//create new file for lease to be shown 
				fileWrite.createNewFile();
			  }	
			FileWriter file = new FileWriter(fileWrite);
		    BufferedWriter output = new BufferedWriter(file);		      
		    String line ="";
		    while(scan.hasNextLine()) {
		    	line = scan.nextLine();
		    	
		    	//Fill in blanks with IF line.contains 
		    	output.write(line+"\n");
		    	  		    		    	    	
		    }
		    output.close();//close IO devices
		    scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
}
	
