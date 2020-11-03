import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Class for Managing a Listing
 * @author pattersonhowell
 * Creates a Singleton 
 */
public class ListingManager {
	
	private static ArrayList<Listing> listings;
	ArrayList<Suite> returnSuites = new ArrayList<>();//specific suites for search
	ArrayList<Suite> searchSuites = new ArrayList<>();
	
	private static ListingManager listingManager;

	/**
	 * Initializing list of listings by loading listings from json file
	 */
	public ListingManager() {
		listings = ListingLoader.loadListings();
	}

	/**
	 * Getting Instance of a listing manager
	 * @return a listing manager
	 */
	public static ListingManager getInstance() {
		if(listingManager == null) listingManager = new ListingManager();
		return listingManager;
	}
	
	/**
	 * Getting listings
	 * @return listings
	 */
	public ArrayList<Listing> getListings() {
		return listings;
	}
	
	/**
	 * Adding a Listing and updating json
	 * @param listing
	 */
	public void addListing(Listing listing) {
		Listing listed = listing;
		listings.add(listed);
		writeListings();
	}
	
	/**
	 * Removing a listing and updating json
	 * @param listingID
	 */
	public void removeListing(int listingID) {//KH changed this method to take in listing ID rather than listing
		for(Listing list:listings) {
			if(list.getListingID()==listingID) {
				listings.remove(list);
			}
		}				
		writeListings();
	}
	
	/**
	 * Showing all listings
	 * @return all listings
	 */
	public ArrayList<Listing> showAllListings() {
		return listings;
	}
	
	/**
	 * Writing json file
	 */
	private void writeListings() {
		ListingWriter.writeListings();
	}
	
	/**
	 * Finding a listing by its ID
	 * @param listingId listing's ID
	 * @return the listing found
	 */
	public Listing findListing(int listingId) {
		for (Listing listing: listings) {
			if(listing.getListingID()==listingId) {
				
				return listing;
			}
		}
		System.out.println("Could not find Listing with that ID");
		return null;
	}
	
	/**
	 * Checking if Listing exists with a particular ID
	 * @param listingID particular ID
	 * @return true or false
	 */
	public boolean listingExists(int listingID) {
		for (Listing listing: listings) {
			if(listing.getListingID()==listingID) {
				return true;
			}
		}
		return false;
	}	
	
	/**
	 * Adding a Review to a listing by its ID
	 * @param review Review to add
	 * @param listingID ID to use to add
	 */
	public void addListingReview(Review review, int listingID) {
		findListing(listingID).reviews.add(review);
		writeListings();
	}
	
	/**
	 * Uploading Listing created by an agent and updating json
	 * @param listing Listing to upload
	 */
	public void agentUploadListing(Listing listing) {
		listings.add(listing);
		writeListings();
	}

	/*********************************************************************
	 * SEARCH METHODS FOR INDIVIDUAL ATTRIBUTES
	 * @param WHAT USER IS SEARCHING BY
	 * @return LISTINGS THAT MATCH THE INDIVIDUAL SEARCH
	 * *******************************************************************
	 */
	public ArrayList<Listing> priceSearch(double price) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for (Listing listing: listings) {
			for(Suite suite: listing.suites) {
				
				if(suite.getPrice() <= price) {
					mathchingListings.add(listing);
					returnSuites.add(suite);
					
				}
			}
		}
		return mathchingListings;
	}
	//distance to campus
	public ArrayList<Listing> distFromCampusSearch(double distance) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for (Listing listing: listings) {
			if(listing.getDistFromCampus() <= distance) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	
	//number of bathrooms
	public ArrayList<Listing> numBathSearch(int numBath) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for (Listing listing: listings) {
			
			for(Suite suite: listing.suites) {
				
				if(suite.getNumBathrooms() >= numBath) {
					mathchingListings.add(listing);
					returnSuites.add(suite);
					
				}
			}
		}
		return mathchingListings;
	}
	
	//number of bedrooms
	public ArrayList<Listing> numBedSearch(int numBed) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for (Listing listing: listings) {
			
			for(Suite suite: listing.suites) {
				
				if(suite.getNumBedrooms() == numBed) {
					mathchingListings.add(listing);
					returnSuites.add(suite);
					
				}
			}
		}
		return mathchingListings;
	}
	
	//year complex was built
	public ArrayList<Listing> yearBuiltSearch(int yearBuilt) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for (Listing listing: listings) {
			if(listing.getYearBuilt() >= yearBuilt) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	
	//washer and dryer in room
	public ArrayList<Listing> laundrySearch(boolean value) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for(Listing listing: listings) {
			if(listing.isLaundry()==value) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	
	//pet friendly
	public ArrayList<Listing> petFriendlySearch(boolean value) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for(Listing listing: listings) {
			if(listing.isPetFriendly()==value) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	
	//pool
	public ArrayList<Listing> hasPoolSearch(boolean value) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for(Listing listing: listings) {
			if(listing.isPool()==value) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	
	//gym
	public ArrayList<Listing> hasGymSearch(boolean value) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for(Listing listing: listings) {
			if(listing.isGym()==value) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	
	//wifi
	public ArrayList<Listing> hasFreeWifiSearch(boolean value) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for(Listing listing: listings) {
			if(listing.isFreeWifi()==value) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	
	//pre-furnished
	public ArrayList<Listing> isFurnishedSearch(boolean value) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for(Listing listing: listings) {
			if(listing.isFurnished()==value) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	
	/**
	 * Printing a given list of Listings
	 * @param listOfListings given list
	 */
	public void printListings(ArrayList<Listing> listOfListings) {
		for (Listing listing: listOfListings) {
			System.out.println("_____________________________________________________________________");
			System.out.println("_____________________________________________________________________");
			
			System.out.println(listing.toString());
			listing.printSuites();
		}
		System.out.println("_____________________________________________________________________");
	}
	
	/**
	 * Printing a given list of Listings and a given list of Suites
	 * @param listOfListings given list of Listings
	 * @param listOfSuites given list of Suites
	 */
	public void printListings(ArrayList<Listing> listOfListings, ArrayList<Suite> listOfSuites) {
		for (Listing listing: listOfListings) {
			System.out.println("_____________________________________________________________________");
			
			System.out.println("_____________________________________________________________________");
				
			System.out.println(listing.toString()); 
			listing.printPresentSuites();
		}
		
		System.out.println("_____________________________________________________________________");

	}
	
	/*************************************************************************************************
	 * EDIT METHODS
	 * @param A LISTING
	 * @param WHAT TO EDIT
	 */
	//id
	public void editAgentID(Listing listing, String ID) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setAgentID(ID);
			}
		}
		writeListings();
	}
	
	//price
	public void editPrice(Listing listing, double price) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setPrice(price);
			}
		}
		writeListings();
	}
	
	//address
	public void editAddress(Listing listing, String address) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setAddress(address);
			}
		}
		writeListings();
	}
	
	//number of bedrooms
	public void editNumberBed(Listing listing, int numBed) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setNumBedroom(numBed);
			}
		}
		writeListings();
	}
	
	//number of bathrooms
	public void editNumberBath(Listing listing, int numBath) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setNumBathroom(numBath);
			}
		}
		writeListings();
	}
	
	//year built 
	public void editYearBuilt(Listing listing, int yearBuilt) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setYearBuilt(yearBuilt);
			}
		}
		writeListings();
	}
	
	//distance from campus
	public void editDistanceFromCampus(Listing listing, double distance) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setDistFromCampus(distance);
			}
		}
		writeListings();
	}
	
	//availibility
	public void editNumAvalible(Listing listing, int numAvalible) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setNumberAvalible(numAvalible);
			}
		}
		writeListings();
	}
	
	//wifi
	public void editFreeWifiStatus(Listing listing,boolean value) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setFreeWifi(value);
			}
		}
		writeListings();
	}
	
	//washer and dryer
	public void editLaundryStatus(Listing listing,boolean value) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setLaundry(value);
			}
		}
		writeListings();
	}
	
	//pet friendly
	public void editPetFriendlyStatus(Listing listing,boolean value) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setPetFriendly(value);
			}
		}
		writeListings();
	}
	
	//pool
	public void editPoolStatus(Listing listing,boolean value) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setPool(value);
			}
		}
		writeListings();
	}
	
	//pre-furnished
	public void editFurnishedStatus(Listing listing,boolean value) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setFurnished(value);
			}
		}
		writeListings();
	}
	
	/**
	 * This method generates all of the listings that fit a certain criteria
	 * @param price Cost of Suite in Listing
	 * @param bed Beds in Suite in Listing
	 * @param bath Baths in Suite in Listing
	 * @param distance Distance from campus
	 * @param wifi Wifi
	 * @param laundry Washer and Dryer in room
	 * @param petFriendly pet rule
	 * @param pool Pool
	 * @param gym Gym
	 * @param furnished pre-furnished
	 */
	public void comprehensiveSearch(Double price, int bed, int bath, double distance, boolean wifi, boolean laundry, boolean petFriendly, boolean pool, boolean gym, boolean furnished) {
		
		ArrayList<Listing> searchResults = new ArrayList<>();
		ArrayList<Suite> searchSuites = new ArrayList<>();
		
		searchResults = (priceSearch(price));//	starting off arrayList with all matching price results
		
		searchResults = checkDups(numBedSearch(bed),searchResults);//comparing the results so far with the new results and moving on the listings that are in common to next round
		
		searchResults = checkDups(numBathSearch(bath),searchResults);

		searchResults = checkDups(distFromCampusSearch(distance),searchResults);
		
		if(wifi == true) {
		searchResults = checkDups(hasFreeWifiSearch(wifi),searchResults);
		}
		if(laundry == true) {
		searchResults = checkDups(laundrySearch(laundry),searchResults);
		}
		if(petFriendly == true) {
		searchResults = checkDups(petFriendlySearch(petFriendly),searchResults);
		}
		if(pool == true) {
		searchResults = checkDups(hasPoolSearch(pool),searchResults);
		}
		if(gym == true) {
		searchResults = checkDups(hasGymSearch(gym),searchResults);
		}
		if(furnished == true) {
		searchResults = checkDups(isFurnishedSearch(furnished),searchResults);
		}
		for(Listing list: searchResults) {
			for(int i = 0; i < list.suites.size(); i++) {
				
				if(list.suites.get(i).getPrice() <= price  && 
						list.suites.get(i).getNumBedrooms() == bed  &&
								list.suites.get(i).getNumBathrooms() >= bath) { 
					
					searchSuites.add(list.suites.get(i));
					//System.out.println("a top Suite made it to the end"); //for debug
					list.presentSuites.add(list.suites.get(i));
	
				}	
			}
		}
		
		//printing search results
		this.printListings(searchResults, searchSuites);
	}
	
	/**
	 * This method takes in the results of the search result and
	 * Compares it to the list to return the listings that are in common
	 * @param currentList List to compare to
	 * @param searchResults results of search
	 * @return Listings in common
	 */
	private ArrayList<Listing> checkDups(ArrayList<Listing> currentList, ArrayList<Listing> searchResults) {
		
		ArrayList<Listing> returnList = new ArrayList<>();
		for(Listing list:searchResults) {
			
			if(currentList.contains(list) ) {
				returnList.add(list);
				
			}
		}
		
		Set<Listing> hashSet = new LinkedHashSet(returnList);
        ArrayList<Listing> removedDuplicates = new ArrayList(hashSet);
		
		return removedDuplicates;
	}
	
	/**
	 * Verifying an ID for a Listing
	 * @param listingID ID to verify
	 * @return true or false
	 */
	public boolean verifyID(int listingID) {
		for(Listing list:listings) {
			if(list.getListingID()==listingID) {
				return true;
			}
		}
		return false;
	}



}
