import java.util.ArrayList;

public class ListingManager {
	private ArrayList<Listing> listings = ListingLoader.loadListings();
	
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
	public void enterNumAvalible(Listing listing, int numAvalible) {
		for(Listing x:listings) {
			if(x==listing) {
				x.setNumberAvalible(numAvalible);
			}
		}			
	}
}			

