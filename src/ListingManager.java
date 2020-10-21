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
		System.out.println("Press 1 to edit agent \nPress 2 to edit price");
		//TBD
		
		
		
		
		
		
	}
	
}

