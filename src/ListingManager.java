import java.util.ArrayList;

public class ListingManager {
	public static ArrayList<Listing> listings = new ArrayList<>(); //= ListingLoader.loadListings();
	
	public static ListingManager listingManager;
	
	public ListingManager() {
		ArrayList<Review> blueHouseRev = new ArrayList<Review>();
		Review myRev = new Review(5,"32342","10/11/20","The best");				
		blueHouseRev.add(myRev);
		//Listingid, agent id, price,address,#bed,#bath,Review<>(),numAval,yearbuilt,distance,wifi,laundry,pet,pool,furnished
		Listing blueHouse = new Listing(001,"72892%String",50.5,"672 School Drive",5,3,blueHouseRev,1,1960,4,true,false,true,false,true);
		listings.add(blueHouse);
			
		ArrayList<Review> redHouseRev = new ArrayList<Review>();
		Review myRev1 = new Review(5,"authorID","03/1/21","The best");				
		redHouseRev.add(myRev1);
		Listing redHouse = new Listing(001,"12323",1100,"555 Timber Lane",1,1,redHouseRev,1,2020,15.3,false,true,false,false,true);
		listings.add(redHouse);		
				
		ArrayList<Review> greenHouseRev = new ArrayList<Review>();
		Review myrev2 = new Review(5,"1738","6/10/20","Amazing Customer Service");				
		greenHouseRev.add(myrev2);
		Listing greenhouse = new Listing(001,"12323",1100,"1330 Glenhardie Rd",5,5,greenHouseRev,1,2020,15.3,true,false,true,false,true);
		listings.add(greenhouse);		
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
	public void printListings() {		
		for (Listing listing: listings) {
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
	
	
	public void comprehensiveSearch(Double price, int bed, int bath, double distance, boolean wifi, boolean laundry, boolean petFriendly, boolean pool, boolean furnished) 
	{
		ArrayList<Listing> searchResults = new ArrayList<>();
		searchResults.addAll(priceSearch(price));
		searchResults.addAll(numBedSearch(bed));
		searchResults.addAll(numBathSearch(bath));
		searchResults.addAll(distFromCampusSearch(distance));
		searchResults.addAll(hasFreeWifiSearch(wifi));
		searchResults.addAll(laundrySearch(laundry));
		searchResults.addAll(petFriendlySearch(petFriendly));
		searchResults.addAll(hasPoolSearch(pool));
		searchResults.addAll(isFurnishedSearch(furnished));
		
		//printing search results 
		for (Listing listing: searchResults) {
			System.out.println("_____________________________________________________________________");
			System.out.println(listing.toString());
		}		
		System.out.println("_____________________________________________________________________");
		
	}
	

	
}			

