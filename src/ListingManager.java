import java.util.ArrayList;

public class ListingManager {
	private static ArrayList<Listing> listings;

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
	public void removeListing(Listing listing) {
		listings.remove(listing);
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

	public void addListingReview(Review review, int listingID) {
		findListing(listingID).reviews.add(review);
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
			if(listing.getNumBathroom() >= numBath) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	public ArrayList<Listing> numBedSearch(int numBed) {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for (Listing listing: listings) {
			if(listing.getNumBedroom() >= numBed) {
				mathchingListings.add(listing);
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
		searchResults = (priceSearch(price));//	starting off arrayList with all matching price results
		searchResults = checkDups(numBedSearch(bed),searchResults);//comparing the results so far with the new results and moving on the listings that are in common to next round
		searchResults = checkDups(numBathSearch(bath),searchResults);
		searchResults = checkDups(distFromCampusSearch(distance),searchResults);
		searchResults = checkDups(hasFreeWifiSearch(wifi),searchResults);
		searchResults = checkDups(laundrySearch(laundry),searchResults);
		searchResults = checkDups(petFriendlySearch(petFriendly),searchResults);
		searchResults = checkDups(hasPoolSearch(pool),searchResults);
		searchResults = checkDups(isFurnishedSearch(furnished),searchResults);

		//printing search results
		this.printListings(searchResults);

	}
	/**
	 * This method takes in the results of the search result and
	 * Compares it to the list to return the listings that are in common
	 * @param currentList
	 * @param searchResults
	 * @return
	 */
	private ArrayList<Listing> checkDups(ArrayList<Listing> currentList, ArrayList<Listing> searchResults) {
		ArrayList<Listing> returnList = new ArrayList<>();
		for(Listing list:searchResults) {
			if(currentList.contains(list)) {
				returnList.add(list);
			}
		}
		return returnList;
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
