import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ListingManagerTest {
	private ListingManager listingManager; 
	
	public ListingManagerTest() {
		listingManager = new ListingManager();  
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddListing(){
		ArrayList<Review> blueHouseRev = new ArrayList<Review>();		
		ArrayList<Suite> blueHouseSuite = new ArrayList<Suite>();
		Listing blueHouse = new Listing("Blue House",001,"72892","672 School Drive",blueHouseRev,blueHouseSuite,1960,4,true,false,true,false,true,true);
		listingManager.addListing(blueHouse);	
		assertEquals(listingManager.getListings().size()+1,listingManager.getListings().size()); 		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
