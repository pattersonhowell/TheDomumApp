import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Listing {
	public int listingID;
	public String agentID;
	protected double price;
	protected String address; 
	protected int numBathroom; 
	protected int numBedroom;
	protected ArrayList<Review> reviews; 
	protected int numberAvalible; 
	protected int yearBuilt;
	protected double distFromCampus; 

	public Listing(int listingID, String agentID, double price, String address, int numBathroom, int numBedroom,
			ArrayList<Review> reviews, int numberAvalible, int yearBuilt, double distFromCampus) {
		this.listingID = listingID;
		this.agentID = agentID;
		this.price = price;
		this.address = address;
		this.numBathroom = numBathroom;
		this.numBedroom = numBedroom;
		this.reviews = reviews;
		this.numberAvalible = numberAvalible;
		this.yearBuilt = yearBuilt;
		this.distFromCampus = distFromCampus;
	}

	public ArrayList<Review> getReview() {
		return this.reviews;
	}
	
	public void addReview(Review review) {
		reviews.add(review);
	}

	public int getListingID() {
		return listingID;
	}

	public void setListingID(int listingID) {
		this.listingID = listingID;
	}

	public String getAgentID() {
		return agentID;
	}

	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumBathroom() {
		return numBathroom;
	}

	public void setNumBathroom(int numBathroom) {
		this.numBathroom = numBathroom;
	}

	public int getNumBedroom() {
		return numBedroom;
	}

	public void setNumBedroom(int numBedroom) {
		this.numBedroom = numBedroom;
	}

	public int getNumberAvalible() {
		return numberAvalible;
	}

	public void setNumberAvalible(int numberAvalible) {
		this.numberAvalible = numberAvalible;
	}

	public int getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	
	public double getDistFromCampus() {
		return distFromCampus;
	}

	public void setDistFromCampus(double distFromCampus) {
		this.distFromCampus = distFromCampus;
	}

	//temporary toString
	public String toString() {
		return "Listing [listingID=" + listingID + ", agentID=" + agentID + ", price=" + price + ", address=" + address
				+ ", numBathroom=" + numBathroom + ", numBedroom=" + numBedroom + ", reviews=" + reviews
				+ ", numberAvalible=" + numberAvalible + ", yearBuilt=" + yearBuilt + ", distFromCampus="
				+ distFromCampus + "]";
	}
	
	

	public void generateLease() {	//This needs some way of getting userData and listing Data	
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
		    	
		    	if(line.contains("Tenant:")) {
		    		 output.write(line+this.getName()+"\n");
		    	}		    	
		    	else if(line.contains("Address:")) {
		    		output.write(line+this.getAddress()+"\n");
		    	}		    	   		    		
		    	else if(line.contains("Tenant Signature:")) {
		    		output.write(line+this.getName()+"\n");
		    	}	
		    	else {
			    	output.write(line+"\n");

		    	}      		 
		    	
		    	  		    		    	    	
		    }
		    output.close();//close IO devices
		    scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	public void generateApplication()  {//This needs some way of getting userData and listing Data	
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
