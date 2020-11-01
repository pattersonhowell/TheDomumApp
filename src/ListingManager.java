import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;



public class ListingManager {
	private static ArrayList<Listing> listings;
	
	ArrayList<Suite> returnSuites = new ArrayList<>();//specific suites for search
	ArrayList<Suite> searchSuites = new ArrayList<>();
	int duplicate = 0;
	
	private static ListingManager listingManager;

	public ListingManager() {
		listings = ListingLoader.loadListings();
	}

	public static ListingManager getInstance() {
		if(listingManager == null) listingManager = new ListingManager();
		return listingManager;
	}
	public ArrayList<Listing> getListings() {
		return listings;
	}
	public void addListing(Listing listing) {
		Listing listed = listing;
		listings.add(listed);
		writeListings();
	}
	public void removeListing(int listingID) {//KH changed this method to take in listing ID rather than listing
		for(Listing list:listings) {
			if(list.getListingID()==listingID) {
				listings.remove(list);
			}
		}				
		writeListings();
	}
	public ArrayList<Listing> showAllListings() {
		return listings;
	}
	private void writeListings() {
		ListingWriter.writeListings();
	}
	public Listing findListing(int listingId) {
		for (Listing listing: listings) {
			if(listing.getListingID()==listingId) {
				//System.out.println("We found listing for ID: " + listingId);
				//System.out.println(listing.toString());
				return listing;
			}
		}
		System.out.println("Could not find Listing with that ID");
		return null;
	}
	public boolean listingExists(int listingID) {
		for (Listing listing: listings) {
			if(listing.getListingID()==listingID) {
				return true;
			}
		}
		return false;
	}	
	public void addListingReview(Review review, int listingID) {
		findListing(listingID).reviews.add(review);
		writeListings();
	}
	
	public void agentUploadListing(Listing listing) {
		listings.add(listing);
		writeListings();
	}



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
			
			for(Suite suite: listing.suites) {
				
				if(suite.getNumBathrooms() >= numBath) {
					mathchingListings.add(listing);
					returnSuites.add(suite);
					
				}
			}
		}
		return mathchingListings;
	}
	public ArrayList<Listing> numBedSearch(int numBed) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for (Listing listing: listings) {
			
			for(Suite suite: listing.suites) {
				
				if(suite.getNumBedrooms() >= numBed) {
					mathchingListings.add(listing);
					returnSuites.add(suite);
					
				}
			}
		}
		return mathchingListings;
	}
	public ArrayList<Listing> yearBuiltSearch(int yearBuilt) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for (Listing listing: listings) {
			if(listing.getYearBuilt() >= yearBuilt) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	public ArrayList<Listing> laundrySearch(boolean value) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for(Listing listing: listings) {
			if(listing.isLaundry()==value) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	public ArrayList<Listing> petFriendlySearch(boolean value) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for(Listing listing: listings) {
			if(listing.isPetFriendly()==value) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	public ArrayList<Listing> hasPoolSearch(boolean value) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for(Listing listing: listings) {
			if(listing.isPool()==value) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	public ArrayList<Listing> hasFreeWifiSearch(boolean value) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for(Listing listing: listings) {
			if(listing.isFreeWifi()==value) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	public ArrayList<Listing> isFurnishedSearch(boolean value) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for(Listing listing: listings) {
			if(listing.isFurnished()==value) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	
	public void printListings(ArrayList<Listing> listOfListings) {
		for (Listing listing: listOfListings) {
			System.out.println("_____________________________________________________________________");
			System.out.println(listing.toString());
		}
		System.out.println("_____________________________________________________________________");
	}
	
	
	
	public void printListings(ArrayList<Listing> listOfListings, ArrayList<Suite> listOfSuites) {
		for (Listing listing: listOfListings) {
			System.out.println("_____________________________________________________________________");
			for(Suite suite: listOfSuites) {
				System.out.println("_____________________________________________________________________");
				System.out.println(listing.toString() + suite.toString());
			}
			//System.out.println(listing.toString() + listing.suites.toString());
		}
		System.out.println("_____________________________________________________________________");

	}
	public void editAgentID(Listing listing, String ID) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setAgentID(ID);
			}
		}
		writeListings();
	}
	public void editPrice(Listing listing, double price) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setPrice(price);
			}
		}
		writeListings();
	}
	public void editAddress(Listing listing, String address) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setAddress(address);
			}
		}
		writeListings();
	}
	public void editNumberBed(Listing listing, int numBed) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setNumBedroom(numBed);
			}
		}
		writeListings();
	}
	public void editNumberBath(Listing listing, int numBath) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setNumBathroom(numBath);
			}
		}
		writeListings();
	}
	public void editYearBuilt(Listing listing, int yearBuilt) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setYearBuilt(yearBuilt);
			}
		}
		writeListings();
	}
	public void editDistanceFromCampus(Listing listing, double distance) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setDistFromCampus(distance);
			}
		}
		writeListings();
	}
	public void editNumAvalible(Listing listing, int numAvalible) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setNumberAvalible(numAvalible);
			}
		}
		writeListings();
	}

	public void editFreeWifiStatus(Listing listing,boolean value) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setFreeWifi(value);
			}
		}
		writeListings();
	}
	public void editLaundryStatus(Listing listing,boolean value) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setLaundry(value);
			}
		}
		writeListings();
	}
	public void editPetFriendlyStatus(Listing listing,boolean value) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setPetFriendly(value);
			}
		}
		writeListings();
	}
	public void editPoolStatus(Listing listing,boolean value) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setPool(value);
			}
		}
		writeListings();
	}
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
	 * @param price
	 * @param bed
	 * @param bath
	 * @param distance
	 * @param wifi
	 * @param laundry
	 * @param petFriendly
	 * @param pool
	 * @param furnished
	 */

	public void comprehensiveSearch(Double price, int bed, int bath, double distance, boolean wifi, boolean laundry, boolean petFriendly, boolean pool, boolean furnished) {
		ArrayList<Listing> searchResults = new ArrayList<>();
		ArrayList<Suite> searchSuites = new ArrayList<>();
		
		searchResults = (priceSearch(price));//	starting off arrayList with all matching price results
		searchResults = checkDups(numBedSearch(bed),searchResults);//comparing the results so far with the new results and moving on the listings that are in common to next round
		searchResults = checkDups(numBathSearch(bath),searchResults);
		searchResults = checkDups(distFromCampusSearch(distance),searchResults);
		searchResults = checkDups(hasFreeWifiSearch(wifi),searchResults);
		searchResults = checkDups(laundrySearch(laundry),searchResults);
		searchResults = checkDups(petFriendlySearch(petFriendly),searchResults);
		searchResults = checkDups(hasPoolSearch(pool),searchResults);
		searchResults = checkDups(isFurnishedSearch(furnished),searchResults);
		
		for(Listing list: searchResults) {
			for(int i = 0; i < list.suites.size(); i++) {
				if(list.suites.get(i).getPrice() <= price && 
						(list.suites.get(i).getNumBedrooms() >= bed &&
								(list.suites.get(i).getNumBathrooms() >= bath))) {
					searchSuites.add(list.suites.get(i));
					System.out.println("a top Suite made it to the end");
				}
						
			}
		}
		//Set<Listing> hashSet = new LinkedHashSet(searchResults);
        //ArrayList<Listing> removedDuplicates = new ArrayList(hashSet);
		
		
		//printing search results
		this.printListings(searchResults, searchSuites);

	}
	
	
	
	
	/**
	 * This method takes in the results of the search result and
	 * Compares it to the list to return the listings that are in common
	 * @param currentList
	 * @param searchResults
	 * @return
	 */
	private ArrayList<Listing> checkDups(ArrayList<Listing> currentList, ArrayList<Listing> searchResults) {
		//int duplicate = 0;
		
		ArrayList<Listing> returnList = new ArrayList<>();
		for(Listing list:searchResults) {
			
			if(currentList.contains(list) ) {
				returnList.add(list);
				//returnSuite.add(suite);
			}
			for(int i = 0; i < returnList.size(); i++) {
				if(list.listingID == returnList.get(i).listingID) {
					duplicate = duplicate + 1;
				}
			}
		
		}
		
		Set<Listing> hashSet = new LinkedHashSet(returnList);
        ArrayList<Listing> removedDuplicates = new ArrayList(hashSet);
		
		return removedDuplicates;
	}
	public boolean verifyID(int listingID) {
		for(Listing list:listings) {
			if(list.getListingID()==listingID) {
				return true;
			}
		}
		return false;
	}



}
