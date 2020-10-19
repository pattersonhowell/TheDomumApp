import java.util.ArrayList;

public class ListingManager {
	private ArrayList<Listing> listings; 
	
	public void addListing(Listing listing) {
		listings.add(listing);
	}
	public void removeListing(Listing listing) {
		listings.remove(listing);
	}
	public ArrayList<Listing> showAllListings() {
		return null;
	}
	public Listing findListing(int listingId) {
		return null;//TODO search listings by Listing ID 
	}
	
	public ArrayList<Listing> priceSearch(double price) {
		return null;//TODO Implement search method 
	}
	
	public ArrayList<Listing> distFromCampusSearch(double distance) {
		return null;//TODO Implement search method 
	}
	
	public ArrayList<Listing> numBathSearch(int numBath) {
		return null;//TODO Implement search method 
	}
	public ArrayList<Listing> numBedSearch(int numBed) {
		return null;//TODO Implement search method 
	}
	public ArrayList<Listing> yearBuiltSearch(int yearBuilt) {
		return null;//TODO Implement search method 
	}
	public void printListings() {
		//print all listings 
	}
	public void editListing(Listing listing) {
		
	}
	
	
	
	
}

