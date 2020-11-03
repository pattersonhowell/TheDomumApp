import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Base class for a Listing
 * @author pattersonhowell
 */
public class Listing {
	
	protected String name;
	public int listingID;
	public String agentID;
	protected double price; //covered by suites
	protected String address; 
	protected int numBathroom; //covered by suites
	protected int numBedroom;  //covered by suites
	protected ArrayList<Review> reviews; 
	protected ArrayList<Suite> suites;
	protected int numberAvalible; //covered by suites
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

	/**
	 * Creating a Listing
	 * @param name Name of complex
	 * @param listingID ID for complex
	 * @param agentID ID for agent
	 * @param address Location of complex
	 * @param reviews Reviews of Listing
	 * @param suites Suites in complex
	 * @param yearBuilt When complex was built
	 * @param distFromCampus How far complex is from campus
	 * @param freeWifi Wifi in complex
	 * @param laundry In room laundry
	 * @param petFriendly Pet rule
	 * @param pool Pool at complex
	 * @param gym Gym at complex
	 * @param furnished Furniture provided
	 */
	public Listing(String name, int listingID, String agentID, String address, ArrayList<Review> reviews, 
			ArrayList<Suite> suites, int yearBuilt, double distFromCampus,
			boolean freeWifi, boolean laundry, boolean petFriendly, boolean pool, boolean gym, boolean furnished) {
		
		this.name = name;
		this.listingID = listingID;
		this.agentID = agentID;
		this.address = address;
		this.reviews = reviews;
		this.presentSuites = new ArrayList<>();
		this.suites = suites;		
		this.yearBuilt = yearBuilt;
		this.distFromCampus = distFromCampus;
		this.freeWifi = freeWifi;
		this.laundry = laundry; 
		this.petFriendly = petFriendly; 
		this.pool = pool; 
		this.gym = gym;
		this.furnished = furnished; 
	}	

	/**
	 * Printing Reviews for a Listing
	 */
	public void printReviews() {
		for(Review r: reviews) {
			System.out.println("_______________________________________________________");
			System.out.println(r.toString());
		}
	}
	
	/**
	 * Adding a Review to a Listing
	 * @param review Review to add
	 */
	public void addReview(Review review) {
		reviews.add(review);
	}
	
	/**
	 * Adding suite to a Listing
	 * @param suite Suite to add
	 */
	public void addSuite(Suite suite) {
		suites.add(suite);
	}
	
	/**
	 * Printing Suites of a Listing
	 */
	public void printSuites() {
		for(Suite s: suites) {
			System.out.println(s.toString());
		}
	}
	
	/**
	 * Printing Suites that match a search preferences
	 */
	public void printPresentSuites() {
		for(Suite s: presentSuites) {
			System.out.println(s.toString());
		}
	}
	
	/*****************************************************
	 * Getting attributes
	 * @return what was retrieved
	 */
	/*****************************************************
	 * Setting attributes
	 */
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	/**
	 * Building a String of Suites to attach to a Listing's print out
	 */
	public void suiteBuilder() {
		for(int i = 0; i < suites.size(); i++) {
			suiteBuilder += suites.get(i).toString() +"\n\n";
		}
		
	}
	
	/**
	 * Printing a Listing and its suites to the screen
	 */
	@Override
	public String toString() {
		return name + "\n" + address +"\n"+ 
				distFromCampus+" Miles from campus" +"\n" +"Built in: "+yearBuilt+ "\n"
						+"Listing ID: "+listingID+ " AgentID: "+agentID +"\n" +"Free Wifi: "+freeWifi 
						+" --Laundry Included: "+laundry+"-- Pet Friendly: "+petFriendly+ "--Pool: "+pool+ "--Gym: "+gym+ "--Furnished: " +furnished
						+ "\n_________________________________________________________\n" 
						+ suiteBuilder;	
	}	
	
	//public String searchToString() {
		//return name + "\n" + address +"\n"+ 
				//distFromCampus+" Miles from campus" +"\n" +"Built in: "+yearBuilt+ "\n"
						//+"Listing ID: "+listingID+ " AgentID: "+agentID +"\n" +"Free Wifi: "+freeWifi 
						//+" --Laundry Included: "+laundry+"-- Pet Friendly: "+petFriendly+ "--Pool: "+pool+ "--Furnished: " +furnished
						//+ ListingManager.getInstance().searchSuites;	
	//}	
	
	/**
	 * Generating a lease for a User
	 * @param user Who it's for
	 */
	public void generateLease(User user) {
		try {	
			System.out.println("Priting Lease for "+user.getName()+" also see Txt File");
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
		    		 System.out.println(line +user.getName() +"\n");
		    	}		    	
		    	else if(line.contains("Address:")) {
		    		output.write(line+this.getAddress()+ "\n");
		    		System.out.println(line+this.getAddress()+ "\n");
		    	}		    	   		    		
		    	else if(line.contains(":$")) {
		    		output.write(line+this.getPrice()+"\n");
		    		System.out.println(line+this.getPrice()+"\n");
		    	}	
		    	else  if (line.contains("Tenant Signature:")){
			    	output.write(line+user.getName()+"\n");
			    	System.out.println(line+user.getName()+"\n");
		    	}
		    	else {		    	
		    		output.write(line+"\n");
		    		System.out.println(line+"\n");
		    	}		    	  		    		    	    	
		    }
		    output.close();//close IO devices
		    scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Generating an application for a User
	 * @param user Who it's for
	 */
	public void generateApplication(User user)  {	
		try {				
			System.out.println("Priting Appplication for "+user.getName()+" also see Txt File");
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
		    	System.out.println(line+this.getAddress()+ "\n");
		    }	
		    else if (line.contains("Price:")) {
		    	output.write(line+this.getPrice()+ "\n");
		    	System.out.println(line+this.getPrice()+ "\n");
		    }
		    else if (line.contains("Name:")) {
		    	output.write(line + user.getName()+ "\n");
		    	System.out.println(line + user.getName()+ "\n");
		    }
		    else if (line.contains("Phone:")) {
		    	output.write(line+ user.getPhone() + "\n");
		    	System.out.println(line+ user.getPhone() + "\n");
		    }		    	
		    else if (line.contains("Email:")) {
		    	output.write(line+user.getEmail()+ "\n");
		    	System.out.println(line+user.getEmail()+ "\n");
		    }		    	
		    else if (line.contains("Student ID:")) {
		    	output.write(line+ user.getId()+ "\n");
		    	System.out.println(line+user.getEmail()+ "\n");
		    }	   	
		    else {		    	
	    		output.write(line+"\n");
	    		System.out.println(line+"\n");
	    	}		
  		    		    	    	
		   }
		    output.close();//close IO devices
		    scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}