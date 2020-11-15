import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * Testing class for Systems
 * @author pattersonhowell
 *
 */
public class SystemsTest {
	private Systems systems;
	private ListingManager listingManager = ListingManager.getInstance();
	private UserManager userManager = UserManager.getInstance();
	
	public SystemsTest() {
		systems = new Systems();
		
	}
	
		//assertEquals(val1,val2)
		//assertFalse(val)
		//assertTrue(val)
		//assertSame(val1,val2)
		//assertNotSame(val1,val2)
		//assertNull(val)
		//assertNotNull(val)
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Adding listings and users to test in each method
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		//setting up listings
		listingManager.getListings().clear();
		ArrayList<Review> nullRev = new ArrayList<Review>();//so we can add object and avoid null pointer
		ArrayList<Suite> suite = new ArrayList<Suite>();//so we can add object and avoid null pointer
		suite.add(new Suite(02,3,2,5,600));//new suite ID=02, 3 beds, 2 baths, 5 aval, 600per month
		listingManager.addListing(new Listing("Blue House",01,"00406","672 School Drive",nullRev,suite,1960,4,true,false,true,false,true,true));
		listingManager.addListing(new Listing("Green House",02,"00501","555 Pine Rd ",nullRev,suite,2011,2,true,true,true,true,true,true));	
		ListingWriter.writeListings();	
		

		//setting up users
		userManager.getUsers().clear();
		ArrayList<Review> junky = new ArrayList<Review>();
		ArrayList<Listing> nullFav = new ArrayList<Listing>();
		junky.add(new Review(1, 3, "smithJohn", "11/13/2020", "very junky person")); 
		userManager.addUser(new Student("111", "John Smith", "johnspassword", "23 River Creek", "123456789", "johnsemail.com"));
		userManager.addUser(new Agent("222", "Sam Brown", "samspassword", "14 Wall St", "987654321", "samsemail.com", "StudentEstates"));
		UserWriter.writeUser();
		
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	/**
	 * testing if a user logged in with the correct credentials
	 */
	@Test
	public void testVerifiedLoginTrue() {
		
		boolean login = systems.verifiedLogin("John Smith", "johnspassword");
		assertTrue(login);
	}
	
	/**
	 * testing if a user logged in with incorrect credentials
	 */
	@Test
	public void testVerifiedLoginFalse() {
		
		boolean login = systems.verifiedLogin("John Smith", "johnswrongpassword");
		assertFalse(login);
	}
	
	/**
	 * testing if a user logged in with incorrect credentials
	 */
	@Test
	public void testVerifiedLoginFalse2() {
		
		boolean login = systems.verifiedLogin("Johns Smith", "johnspassword");
		assertFalse(login);
	}
	
	/**
	 * testing if a given person is a user in the system
	 */
	@Test
	public void testVerifiedUsuerTrue() {
		
		boolean user = systems.verifiedUser("John Smith");
		assertTrue(user);
	}
	
	/**
	 * testing if a given person is not a user in the system
	 */
	@Test
	public void testVerifiedUsuerFalse() {
		
		boolean user = systems.verifiedUser("Lebron James");
		assertFalse(user);
	}
	
	/**
	 * testing if signing up as a student adds the user to the system
	 */
	@Test
	public void testSignUpStudent() {
		
		int prevSize = userManager.getUsers().size();
		systems.signUpStudent("Pat Howell", "patspassword", "2 Lake Park", "8038030803", "patsemail.com", "howellPat");
		assertEquals(prevSize + 1, userManager.getUsers().size());
	}
	
	/**
	 * testing if signing up as an agent adds the user to the system
	 */
	@Test
	public void testSignUpAgent() {
		
		int prevSize = userManager.getUsers().size();
		systems.signUpAgent("Kevin Jones", "kevinspassword", "2 River Park", "8648030843", "kevinsemail.com", "jonesKevin", "StudiousProperties");
		assertEquals(prevSize + 1, userManager.getUsers().size());
	}
	
	/**
	 * testing browsing anonymously 
	 */
	@Test
	public void testBrowseAnonymously() {
		
		ArrayList<Listing> browse = systems.browseAnonymously();
		assertNotNull(browse);
	}
	
	/**
	 * testing if an account can be deleted from system
	 */
	@Test
	public void testDeleteAccount() {
		
		int prevSize = userManager.getUsers().size();
		systems.deleteAccount("Kevin Jones", "kevinspassword");
		assertEquals(prevSize - 1, userManager.getUsers().size());
		
	}
	
	/**
	 * testing if a user can be found by their name
	 */
	@Test
	public void testReturnUserWithName() {		
		User test = systems.returnUserWithName("Sam Brown");
		assertNotNull(test);
	}
	
	/**
	 * testing if a user cannot be found by their name
	 */
	@Test
	public void testReturnUserWithNameNull() {
		
		User test = systems.returnUserWithName("Fake Person");
		assertNull(test);
	}
	
	/**
	 * testing print call
	 */
	@Test
	public void testPrintListings() {
		systems.printListings();
		assertNotNull(systems.listingManager.getListings());
	}
	
	/**
	 * testing a specific search call
	 */
	@Test
	public void testComprehensiveSearch() {
		systems.comprehensiveSearch(1000, 2, 2, 100, true, true, false, true, false, true);
		//double void call, testing the call
	}
	
	/**
	 * testing if a listing can be found by its id
	 */
	@Test 
	public void testListingID() {
		
		Listing test = systems.listingID(2);
		assertNotNull(test);
	}
	
	/**
	 * testing if a listing cannot be found by an id
	 */
	@Test
	public void testListingIDNull() {
		
		Listing test = systems.listingID(788);
		assertNull(test);
	}
	
	/**
	 * testing if a listing cannot be found by an id
	 */
	@Test
	public void testListingIDNull2() {
		
		Listing test = systems.listingID(-34);
		assertNull(test);
	}
	
	/**
	 * testing if a user's id can be found using their name and password
	 */
	@Test
	public void testReturnID() {
		
		String id = systems.returnID("Sam Brown", "samspassword");
		assertEquals("222", id);
	}
	
	/**
	 * testing if a user's id cannot be found using incorrect name and  incorrect password
	 */
	@Test
	public void testReturnIDNull() {
		
		String id = systems.returnID("Fake Person", "idonthavepassword");
		assertNull(id);
	}
	
	/**
	 * testing if a user's id cannot be found using their name and incorrect password
	 */
	@Test
	public void testReturnIDNull2() {
		
		String id = systems.returnID("Sam Brown", "idonthavepassword");
		assertNull(id);
	}
	
	/**
	 * testing if a user's id cannot be found using incorrect name and correct password
	 */
	@Test
	public void testReturnIDNull3() {
		
		String id = systems.returnID("Fake Person", "samspassword");
		assertNull(id);
	}
	
	/**
	 * testing if a listing can be removed from system
	 */
	@Test
	public void testRemoveListing() {
		
		int prevSize = listingManager.getListings().size();
		systems.removeListing(1);
		assertEquals(prevSize - 1, listingManager.getListings().size());
		
	}
	
	/**
	 * testing if a listing that DNE cannot be removed from system
	 */
	@Test
	public void testRemoveListingDNE() {
		
		int prevSize = listingManager.getListings().size();
		systems.removeListing(23);
		assertEquals(prevSize, listingManager.getListings().size());
	}
	
	/**
	 * testing if a certain user is a student
	 */
	@Test
	public void testIsStudent() {
		
		boolean test = systems.isStudent("111");
		assertTrue(test);
	}
	
	/**
	 * testing if a certain user is not a student
	 */
	@Test
	public void testIsStudentFalse() {
		boolean test = systems.isStudent("333");
		assertFalse(test);
		
	}
	
	

}
