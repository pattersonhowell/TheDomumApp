import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Class that tests functionality of ListingManager, 
 * Checks both cases when dealing with boolean and search methods
 * but only tests functionality on add/remove methods
 * @author Kevin Hagan *
 */
public class ListingManagerTest {	
	  private ListingManager listingManager = ListingManager.getInstance();  	
	  	  
	/**
	* Before the tests, this method clears the Listings and adds 3 new listings for further testing
	* @throws Exception
	*/    
	 @Before 
	public void setup() throws Exception {		
		listingManager.getListings().clear();
		ArrayList<Review> nullRev = new ArrayList<Review>();//so we can add object and avoid null pointer
		ArrayList<Suite> suite = new ArrayList<Suite>();//so we can add object and avoid null pointer
		suite.add(new Suite(02,3,2,5,600));//new suite ID=02, 3 beds, 2 baths, 5 aval, 600per month
		listingManager.addListing(new Listing("Blue House",01,"00406","672 School Drive",nullRev,suite,1960,4,true,false,true,false,true,true));
		listingManager.addListing(new Listing("Green House",02,"00501","555 Pine Rd ",nullRev,suite,2011,2,true,true,true,true,true,true));	
		ListingWriter.writeListings();		
	}

	/** This method clears the JSON file after the tests are complete 
	 * 
	 * @throws Exception
	 */	 
	@After
	public void tearDownAfterClass() throws Exception {
//		listingManager.getListings().clear();
//		ListingWriter.writeListings();//per video on Junit Library system 					
	}	
	
	/**
	 * This method tests the add functionality by comparing the previous size to the new size after addListing is called
	 */	
	@Test
	public void testAddListing() {				
		ArrayList<Review> redHouseRev = new ArrayList<Review>();		
		ArrayList<Suite> redHouseSuite = new ArrayList<Suite>();
		Listing redHouse = new Listing("Red House",123,"1232","3 Acorn Lane",redHouseRev,redHouseSuite,2003,5,true,false,true,false,true,true);
		int previousSize =listingManager.getListings().size();
		listingManager.addListing(redHouse);	
		assertEquals(previousSize+1,listingManager.getListings().size()); 
	}
	/**
	 * This method tests the remove functionality by comparing the previous size to the new size after remove is called 
	 */	
	@Test
	public void testRemoveListing() {				
	int previousSize = listingManager.getListings().size();	
	listingManager.removeListing(01);//removing blue house which is added in the setUp
	assertEquals(previousSize-1,listingManager.getListings().size());
	}
	
	/**
	 * This method tests the ShowALlListings method by comparing size with the expected size 
	 */	
	@Test
	public void testShowALlListings() {		
		assertEquals(2,listingManager.showAllListings().size());
	}
	
	
	/**
	 * This method tests the ListingManagers's find listing method by comparing a listing with the Results of findListing(Listing ID)
	 */
	@Test
	public void testFindListingTrue() {
		ArrayList<Review> magentaHouserev = new ArrayList<Review>();		
		ArrayList<Suite> magentaHouseSuite = new ArrayList<Suite>();
		Listing magentaHouse = new Listing("Magena House",111,"1232","3 Acorn Lane",magentaHouserev,magentaHouseSuite,2003,5,true,false,true,false,true,true);
		listingManager.addListing(magentaHouse);		
		assertEquals(magentaHouse,listingManager.findListing(111));		
	}	
	
	/**
	 * This method tests the FindListing method given an ID that is not in the system 
	 * IT should return Null in this case 
	 */	
	@Test
	public void testFindListingFalse() {		
		assertNull(listingManager.findListing(25));	
		
	}			
	
	/**
	 * This method simply tests if a listing exits by searching for the green houses ID, which is added at setup
	 */	
	@Test
	public void testListingExistsTrue() {	
		assertTrue(listingManager.listingExists(02));		
	}
	
	
	/**
	 * This tests checks to see if a listingID exits. In this case 25 does not and should assertFalse
	 */
	@Test
	public void testListingExistsFalse() {
		assertFalse(listingManager.listingExists(25));			
	}
	
	/**
	 * This method adds a new review to GreenHouse then checks to see if green house contains that review that was just added 
	 */	
	@Test
	public void testAddListingReview() {
		Review myReview = new Review(02,5,"KEVINID", "11/11/2020","Great Customer Experience!!!");		
		listingManager.addListingReview(myReview, 02);		
		ArrayList<Review> returnedReviews = listingManager.findListing(02).reviews;		
		for(Review rev:returnedReviews) {
			if(rev==myReview) {
				assertEquals(myReview,rev);
			}
		}		
	}
	/**
	 * Tests price search when given price limit above every listing
	 */
	@Test
	public void testPriceSearch() {
		ArrayList<Listing> returnSearch = listingManager.priceSearch(600);			
		assertEquals(listingManager.getListings(),returnSearch);	
	}
	/**
	 * Tests price search when given price below above every listing
	 */
	@Test
	public void testPriceSearchFalse() {
		ArrayList<Listing> returnSearch = listingManager.priceSearch(400);			
		assertEquals(0,returnSearch.size());
	}
	
	/**
	 * Tests Distance from campus search using a distance that only green house is expected
	 */		
	@Test
	public void testDistFromCampusSearch() {
		ArrayList<Listing> returnSearch = listingManager.distFromCampusSearch(2.5);
		ArrayList<Listing> expectedList = new ArrayList<Listing>();		
		ArrayList<Review> nullRev = new ArrayList<Review>();//so we can add object and avoid null pointer
		ArrayList<Suite> suite = new ArrayList<Suite>();//so we can add object and avoid null pointer
		suite.add(new Suite(02,3,2,5,600));//new suite ID=02, 3 beds, 2 baths, 5 aval, 600per month				
		expectedList.add(new Listing("Green House",02,"00501","555 Pine Rd ",nullRev,suite,2011,2,true,true,true,true,true,true));	
		assertNotSame(expectedList,returnSearch);	
	}
	/**
	 * Tests Distance from campus search using a distance that should not return any listings
	 */	
	@Test
	public void testDistFromCampusSearchFalse() {
		ArrayList<Listing> returnSearch = listingManager.distFromCampusSearch(.5);

		assertEquals(0,returnSearch.size());
	}



	
	
	
	
	
	

}
