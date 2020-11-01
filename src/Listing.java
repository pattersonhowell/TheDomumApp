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
	protected ArrayList<Suite> suites;
	protected int numberAvalible; 
	protected int yearBuilt;
	protected double distFromCampus; 
	protected boolean freeWifi;
	protected boolean laundry; 
	protected boolean petFriendly;
	protected boolean pool;
	protected boolean gym;
	protected boolean furnished; 
	protected String suiteBuilder = "";
	
	protected ArrayList<Suite> presentSuites;

	public Listing(int listingID, String agentID, String address, 
			ArrayList<Suite> suites, int yearBuilt, double distFromCampus,
			boolean freeWifi, boolean laundry, boolean petFriendly, boolean pool, boolean gym, boolean furnished) {
		this.listingID = listingID;
		this.agentID = agentID;
		//this.price = price;
		this.address = address;
		//this.numBathroom = numBathroom;
		//this.numBedroom = numBedroom;
		this.reviews = new ArrayList<>();
		this.presentSuites = new ArrayList<>();
		//this.suites = new ArrayList<>();
		this.suites = suites;
		//this.numberAvalible = numberAvalible;		
		this.yearBuilt = yearBuilt;
		this.distFromCampus = distFromCampus;
		this.freeWifi = freeWifi;
		this.laundry = laundry; 
		this.petFriendly = petFriendly; 
		this.pool = pool; 
		this.gym = gym;
		this.furnished = furnished; 
	}	

	public void printReviews() {
		for(Review r: reviews) {
			System.out.println(r.toString());
		}
	}
	
	
	
	public void addReview(Review review) {
		reviews.add(review);
	}
	
	public void addSuite(Suite suite) {
		suites.add(suite);
	}
	
	
	public void printSuites() {
		for(Suite s: suites) {
			System.out.println(s.toString());
		}
	}
	
	public void printPresentSuites() {
		for(Suite s: presentSuites) {
			System.out.println(s.toString());
		}
	}
	
	public ArrayList<Suite> getSuites() {
		return suites;
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
	public boolean isFreeWifi() {
		return freeWifi;
	}

	public void setFreeWifi(boolean freeWifi) {
		this.freeWifi = freeWifi;
	}

	public boolean isLaundry() {
		return laundry;
	}

	public void setLaundry(boolean laundry) {
		this.laundry = laundry;
	}

	public boolean isPetFriendly() {
		return petFriendly;
	}

	public void setPetFriendly(boolean petFriendly) {
		this.petFriendly = petFriendly;
	}

	public boolean isPool() {
		return pool;
	}
	
	public boolean isGym() {
		return gym;
	}

	public void setPool(boolean pool) {
		this.pool = pool;
	}
	
	public void setGym(boolean gym) {
		this.gym = gym;
	}

	public boolean isFurnished() {
		return furnished;
	}

	public void setFurnished(boolean furnished) {
		this.furnished = furnished;
	}	
	public void suiteBuilder() {
		for(int i = 0; i < suites.size(); i++) {
			suiteBuilder += suites.get(i).toString() +"\n\n";
		}
		
	}
	

	@Override
	public String toString() {
		return address +"\n"+ 
				distFromCampus+" Miles from campus" +"\n" +"Built in: "+yearBuilt+ "\n"
						+"Listing ID: "+listingID+ " AgentID: "+agentID +"\n" +"Free Wifi: "+freeWifi 
						+" --Laundry Included: "+laundry+"-- Pet Friendly: "+petFriendly+ "--Pool: "+pool+ "--Gym: "+gym+ "--Furnished: " +furnished
						+ suiteBuilder;	
	}	
	
	public String searchToString() {
		return address +"\n"+ 
				distFromCampus+" Miles from campus" +"\n" +"Built in: "+yearBuilt+ "\n"
						+"Listing ID: "+listingID+ " AgentID: "+agentID +"\n" +"Free Wifi: "+freeWifi 
						+" --Laundry Included: "+laundry+"-- Pet Friendly: "+petFriendly+ "--Pool: "+pool+ "--Furnished: " +furnished
						+ ListingManager.getInstance().searchSuites;	
	}	
	

	public void generateLease(User user) {
		try {	
			File fileRead  = new File("./TextFiles/LeasingAgreement.txt");
			File fileWrite  = new File("./TextFiles/LeasingAgreement_"+user.getName());
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
		    		 output.write(line +user.getName() +"\n");
		    	}		    	
		    	else if(line.contains("Address:")) {
		    		output.write(line+this.getAddress()+ "\n");
		    	}		    	   		    		
		    	else if(line.contains(":$")) {
		    		output.write(line+this.getPrice()+"\n");
		    	}	
		    	else  if (line.contains("Tenant Signature:")){
			    	output.write(line+user.getName()+"\n");
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
	public void generateApplication(User user)  {	
		try {				
			File fileRead  = new File("./TextFiles/Application.txt");			
			File fileWrite  = new File("./TextFiles/Application_"+user.getName());						
					
			Scanner scan = new Scanner(fileRead);		
			if (!fileWrite.exists()) {//create new file for lease to be shown 
				fileWrite.createNewFile();
			  }	
			FileWriter file = new FileWriter(fileWrite);
		    BufferedWriter output = new BufferedWriter(file);		      
		    String line ="";
		    while(scan.hasNextLine()) {
		    	line = scan.nextLine();
		    	
		    if(line.contains("Address:")) {
		    	output.write(line+this.getAddress()+ "\n");
		    }	
		    else if (line.contains("Price:")) {
		    	output.write(line+this.getPrice()+ "\n");
		    }
		    else if (line.contains("Name:")) {
		    	output.write(line + user.getName()+ "\n");
		    }
		    else if (line.contains("Phone:")) {
		    	output.write(line+ user.getPhone() + "\n");
		    }		    	
		    else if (line.contains("Email:")) {
		    	output.write(line+user.getEmail()+ "\n");
		    }		    	
		    else if (line.contains("Student ID:")) {
		    	output.write(line+ user.getId()+ "\n");
		    }	   	
  		    		    	    	
		   }
		    output.close();//close IO devices
		    scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}