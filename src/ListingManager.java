import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ListingManager {
	Scanner kb = Scanner(System.in);
	private ArrayList<Listing> listings;	
	
	public void addListing(Listing listing) {
		listings.add(listing);
	}
	private Scanner Scanner(InputStream in) {
		// TODO Auto-generated method stub
		return null;
	}
	public void removeListing(Listing listing) {
		listings.remove(listing);
	}
	public ArrayList<Listing> showAllListings() {
		return listings; 
	}
	public Listing findListing(int listingId) {			
		for (Listing listing: listings) {
			if(listing.getListingID()==listingId) {
				return listing;
			}
		}
		System.out.println("Could not find Listing with that ID");
		return null;		
	}
	
	public ArrayList<Listing> priceSearch(double price) {	
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for (Listing listing: listings) {
			if(listing.getPrice() <= price) {
				mathchingListings.add(listing);
			}
		}		
		return mathchingListings; 
	}
	
	public ArrayList<Listing> distFromCampusSearch(double distance) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for (Listing listing: listings) {
			if(listing.getDistFromCampus() <= distance) {
				mathchingListings.add(listing);
			}
		}		
		return mathchingListings; 
	}
	
	public ArrayList<Listing> numBathSearch(int numBath) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for (Listing listing: listings) {
			if(listing.getNumBathroom() <= numBath) {
				mathchingListings.add(listing);
			}
		}		
		return mathchingListings; 
	}
	public ArrayList<Listing> numBedSearch(int numBed) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for (Listing listing: listings) {
			if(listing.getNumBedroom() <= numBed) {
				mathchingListings.add(listing);
			}
		}		
		return mathchingListings; 
	}
	public ArrayList<Listing> yearBuiltSearch(int yearBuilt) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for (Listing listing: listings) {
			if(listing.getYearBuilt() <= yearBuilt) {
				mathchingListings.add(listing);
			}
		}		
		
		
		return mathchingListings; 
	}
	public void printListings() {
		System.out.println("Printing Listings");
		for (Listing listing: listings) {
			System.out.println(listing.toString());
		}		
	}
	public void editListing(Listing listing) { //should this take in a Listing ID instead? 
		System.out.println("Displaying the current Listing:");
		listing.toString();
		System.out.println("What would you like to edit");
		System.out.println(""
				+ "Press 1 to edit agent ID "
				+ "\nPress 2 to edit price"
				+ "\nPress 3 to edit address"
				+ "\nPress 4 to edit the number of bedrooms "
				+ "\nPress 5 to edit the number of bathrooms"
				+ "\nPress 6 to edit the year built "
				+ "\nPress 7 to edit the distance from campus"
				+ "\nPress 8 to edit the number avalible");
		int choice = kb.nextInt();		
		switch(choice) {
		case 1:		
			System.out.println("Please enter the modified agent ID");
			String agent = kb.nextLine();
			listing.setAgentID(agent);
			break; 			
		case 2: 	
			System.out.println("Please enter the modified price");
			double price = kb.nextDouble();
			listing.setPrice(price);
			break;		
			
		case 3:		
			System.out.println("Please enter the modified address");
			String address = kb.nextLine();
			listing.setAddress(address);
			break;
						
		case 4:		
			System.out.println("Please enter the modified number of bedrooms");
			int numBed = kb.nextInt();
			listing.setNumBedroom(numBed);
			break;
		
		case 5:
			System.out.println("Please enter the modified number of bathrooms");
			int numbath = kb.nextInt();
			listing.setNumBathroom(numbath);
			break;
		case 6:
			System.out.println("Please enter the modified number of year built");
			int yearBuilt = kb.nextInt();
			listing.setYearBuilt(yearBuilt);
			break;
		case 7: 
			System.out.println("Please enter the modified distance from campus");
			double distance = kb.nextDouble();
			listing.setDistFromCampus(distance);
			break;
		case 8:
			System.out.println("Please enter the modified number avalible");
			int numAvalible = kb.nextInt();
			listing.setNumberAvalible(numAvalible);
			break;
	
		}			
	}	
}

