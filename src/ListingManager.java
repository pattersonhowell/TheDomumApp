import java.util.ArrayList;

public class ListingManager {
	public static ArrayList<Listing> listings = new ArrayList<>();

	public static ListingManager listingManager;

	public ListingManager() {
		// TODO Remove hardcode
		listings = ListingLoader.loadListings();
//		ArrayList<Review> blueHouseRev = new ArrayList<Review>();
//		Review myRev = new Review(5,"authorID","10/10/20","The best");
//		blueHouseRev.add(myRev);
//		Listing blueHouse = new Listing(001,"72892%String",500.50,"672 School Drive",5,3,blueHouseRev,1,1960,4.0);
//		listings.add(blueHouse);
//
//		ArrayList<Review> redHouseRev = new ArrayList<Review>();
//		Review myRev1 = new Review(5,"authorID","10/10/20","The best");
//		redHouseRev.add(myRev1);
//		Listing redHouse = new Listing(001,"12323",1100,"555 Timber Lane",1,1,redHouseRev,1,2020,15.3);
//		listings.add(redHouse);

	}

	public static ListingManager getInstance() {
		if(listingManager == null) listingManager = new ListingManager();
		return listingManager;
	}

	public void addListing(Listing listing) {
		Listing listed = listing;
		listings.add(listed);
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
	public ArrayList<Listing> laundrySearch() {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for(Listing listing: listings) {
			if(listing.isLaundry()==true) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	public ArrayList<Listing> petFriendlySearch() {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for(Listing listing: listings) {
			if(listing.isPetFriendly()==true) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	public ArrayList<Listing> hasPoolSearch() {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for(Listing listing: listings) {
			if(listing.isPool()==true) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	public ArrayList<Listing> hasFreeWifiSearch() {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for(Listing listing: listings) {
			if(listing.isFreeWifi()==true) {
				mathchingListings.add(listing);
			}
		}
		return mathchingListings;
	}
	public ArrayList<Listing> isFurnishedSearch() {
		ArrayList<Listing> mathchingListings = new ArrayList<Listing>();
		for(Listing listing: listings) {
			if(listing.isFurnished()==true) {
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
	public void editAgentID(Listing listing, String ID) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setAgentID(ID);
			}
		}
	}
	public void editPrice(Listing listing, double price) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setPrice(price);
			}
		}
	}
	public void editAddress(Listing listing, String address) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setAddress(address);
			}
		}
	}
	public void editNumberBed(Listing listing, int numBed) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setNumBedroom(numBed);
			}
		}
	}
	public void editNumberBath(Listing listing, int numBath) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setNumBathroom(numBath);
			}
		}
	}
	public void editYearBuilt(Listing listing, int yearBuilt) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setYearBuilt(yearBuilt);
			}
		}
	}
	public void editDistanceFromCampus(Listing listing, double distance) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setDistFromCampus(distance);
			}
		}
	}
	public void editNumAvalible(Listing listing, int numAvalible) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setNumberAvalible(numAvalible);
			}
		}
	}

	public void editFreeWifiStatus(Listing listing,boolean value) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setFreeWifi(value);
			}
		}
	}
	public void editLaundryStatus(Listing listing,boolean value) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setLaundry(value);
			}
		}
	}
	public void editPetFriendlyStatus(Listing listing,boolean value) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setPetFriendly(value);
			}
		}
	}
	public void editPoolStatus(Listing listing,boolean value) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setPool(value);
			}
		}
	}
	public void editFurnishedStatus(Listing listing,boolean value) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setFurnished(value);
			}
		}
	}




































}
