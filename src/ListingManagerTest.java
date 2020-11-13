import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Class that tests functionality of ListingManager
 * @author Kevin Hagan *
 */
public class ListingManagerTest {	
	  private ListingManager listingManager = ListingManager.getInstance();	  
	@Before 
	public void setup() throws Exception {		
		listingManager.getListings().clear();
		ArrayList<Review> nullRev = new ArrayList<Review>();//so we can add object and avoid null pointer
		ArrayList<Suite> nullSuite = new ArrayList<Suite>();//so we can add object and avoid null pointer
		listingManager.addListing(new Listing("Blue House",01,"00406","672 School Drive",nullRev,nullSuite,1960,4,true,false,true,false,true,true));
		listingManager.addListing(new Listing("Green House",02,"00501","555 Pine Rd ",nullRev,nullSuite,2011,2,true,false,true,false,true,true));
		ListingWriter.writeListings();		
	}

	@After
	public void tearDownAfterClass() throws Exception {
		listingManager.getListings().clear();
		ListingWriter.writeListings();//per video on Junit Library system 					
	}	
	
	@Test		
	public void testSize() {		
		assertEquals(2,listingManager.getListings().size());		
	}	
	
	@Test
	public void testAddListing() {				
		ArrayList<Review> redHouseRev = new ArrayList<Review>();		
		ArrayList<Suite> redHouseSuite = new ArrayList<Suite>();
		Listing redHouse = new Listing("Red House",123,"1232","3 Acorn Lane",redHouseRev,redHouseSuite,2003,5,true,false,true,false,true,true);
		int previousSize =listingManager.getListings().size();
		listingManager.addListing(redHouse);	
		assertEquals(previousSize+1,listingManager.getListings().size()); 
	}
	
	@Test
	public void testRemoveListing() {						
			
	int previousSize = listingManager.getListings().size();	
	listingManager.removeListing(01);//removing blue house which is added in the setUp
	assertEquals(previousSize-1,listingManager.getListings().size());
	}
	
	@Test
	public void testListingExists() {	
	assertEquals(true,listingManager.listingExists(02));//listing id for green house 			
	}
//	
//	public void testComprehensiveSearch() {
//		
//		//this will pass in a numch of variables and see if comprehensive search works idk 
//		
//		
//		
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
