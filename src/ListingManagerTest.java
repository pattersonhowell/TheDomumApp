import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ListingManagerTest {
	
	 static ListingManager listingManager = ListingManager.getInstance();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
		//addding a listing to be removed 
		ArrayList<Review> greenHouseRev = new ArrayList<Review>();		
		ArrayList<Suite> GreenHouseSuite = new ArrayList<Suite>();
		Listing greenHouse = new Listing("Green House",233,"72892","672 School Drive",greenHouseRev,GreenHouseSuite,1960,4,true,false,true,false,true,true);
		listingManager.addListing(greenHouse);				
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		listingManager.removeListing(5555);//remove the house that we added in the test 
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddListing() {
		ArrayList<Review> blueHouseRev = new ArrayList<Review>();		
		ArrayList<Suite> blueHouseSuite = new ArrayList<Suite>();
		Listing blueHouse = new Listing("Blue House",5555,"72892","672 School Drive",blueHouseRev,blueHouseSuite,1960,4,true,false,true,false,true,true);
		int previousSize =listingManager.getListings().size();
		listingManager.addListing(blueHouse);	
		assertEquals(previousSize+1,listingManager.getListings().size()); 		
	}
	@Test
	public void testRemoveListing() {		
			int previousSize = listingManager.getListings().size();
			listingManager.removeListing(233);		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
