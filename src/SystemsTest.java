import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SystemsTest {
	private Systems systems;
	
	
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

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testVerifiedLoginTrue() {
		
		boolean login = systems.verifiedLogin("John Doe", "somepassword123");
		assertTrue(login);
	}
	
	@Test
	public void testVerifiedLoginFalse() {
		
		boolean login = systems.verifiedLogin("John Doe", "somewrongpassword123");
		assertFalse(login);
	}
	
	@Test
	public void testVerifiedLoginFalse2() {
		
		boolean login = systems.verifiedLogin("Johns Doe", "somepassword123");
		assertFalse(login);
	}
	
	
	@Test
	public void testVerifiedUsuerTrue() {
		
		boolean user = systems.verifiedUser("John Doe");
		assertTrue(user);
	}
	
	@Test
	public void testVerifiedUsuerFalse() {
		
		boolean user = systems.verifiedUser("Lebron James");
		assertFalse(user);
	}
	
	@Test
	public void testBrowseAnonymously() {
		
		ArrayList<Listing> browse = systems.browseAnonymously();
		assertNotNull(browse);
	}
	
	@Test
	public void testReturnUserWithName() {		
		User test = systems.returnUserWithName("Tom Burch");
		assertNotNull(test);
	}
	
	@Test
	public void testReturnUserWithNameNull() {
		
		User test = systems.returnUserWithName("Fake Person");
		assertNull(test);
	}
	
	@Test 
	public void testListingID() {
		
		Listing test = systems.listingID(12);
		assertNotNull(test);
	}
	
	@Test
	public void testListingIDNull() {
		
		Listing test = systems.listingID(788);
		assertNull(test);
	}
	
	@Test
	public void testListingIDNull2() {
		
		Listing test = systems.listingID(-34);
		assertNull(test);
	}
	
	
	
	@Test
	public void testReturnID() {
		
		String id = systems.returnID("Tom Burch", "reallybadpassword");
		assertEquals("390393", id);
	}
	
	@Test
	public void testReturnIDNull() {
		
		String id = systems.returnID("Fake Person", "idonthavepassword");
		assertNull(id);
	}
	
	@Test
	public void testReturnIDNull2() {
		
		String id = systems.returnID("Tom Burch", "idonthavepassword");
		assertNull(id);
	}
	
	@Test
	public void testReturnIDNull3() {
		
		String id = systems.returnID("Fake Person", "reallybadpassword");
		assertNull(id);
	}
	
	
	
	@Test
	public void testIsStudent() {
		
		boolean test = systems.isStudent("howellpatterson");
		assertTrue(test);
	}
	
	@Test
	public void testIsStudentFalse() {
		boolean test = systems.isStudent("smithProperty");
		assertFalse(test);
		
	}
	
	
	
	
	

	//@Test
	//public void test() {
		//fail("Not yet implemented");
	//}

}
