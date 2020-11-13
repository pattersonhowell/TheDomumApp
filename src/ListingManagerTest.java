import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ListingManagerTest {
	
	  private ListingManager listingManager = ListingManager.getInstance();
	  private ArrayList<Listing> listingList = listingManager.getListings();
	
	@BeforeEach
	public void setup() throws Exception {		
			
		
		
		
	}

	@AfterEach
	public void tearDownAfterClass() throws Exception {
		
		
		
		
		
		
		
		
		
		
	}

	

	@Test
	public void testAddListing() {
		ArrayList<Review> blueHouseRev = new ArrayList<Review>();		
		ArrayList<Suite> blueHouseSuite = new ArrayList<Suite>();
		Listing blueHouse = new Listing("Blue House",5555,"72892","672 School Drive",blueHouseRev,blueHouseSuite,1960,4,true,false,true,false,true,true);
		int previousSize =listingManager.getListings().size();
		listingManager.addListing(blueHouse);	
		assertEquals(previousSize+1,listingManager.getListings().size()); 
		listingManager.removeListing(5555);//remove the house that we added in the test 

	}
	@Test
	public void testRemoveListing() {	
					
		//addding a listing to be removed 
				ArrayList<Review> greenHouseRev = new ArrayList<Review>();		
				ArrayList<Suite> GreenHouseSuite = new ArrayList<Suite>();
				Listing greenHouse = new Listing("Green House",233,"72892","672 School Drive",greenHouseRev,GreenHouseSuite,1960,4,true,false,true,false,true,true);
				listingManager.addListing(greenHouse);	
		
		
		
//		
//			int previousSize = listingManager.getListings().size();
//			listingManager.removeListing(233);
//			assertEquals(previousSize-1,listingManager.getListings().size());
	}
	
	public void testListingExists() {
			ArrayList<Listing> listings = listingManager.getListings();
		
			int listingID = 5555;
		
			//this method will search for a listing with a listing id and see if it returns the same things as the method 
			
		
		
		
		
	}
	
	public void testComprehensiveSearch() {
		
		//this will pass in a numch of variables and see if comprehensive search works idk 
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
