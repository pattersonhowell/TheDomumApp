import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * testing class for user manager
 * @author Thomas
 */
public class UserManagerTest {
	private UserManager userManager = UserManager.getInstance();
	
	/**
	 * adds users ArrayList and some test users after clearing any existing data
	 */
	@Before
	public void setup() throws Exception {
		userManager.getUsers().clear();
		ArrayList<User> users = new ArrayList<User>();
		User dom = new User("01", "Dom", "domum", "123 domum st", "12345678910", "domumtest@gmail");
		userManager.addUser(dom);
		userManager.addUser(new User("02", "Mum", "mumod", "123 mumod st", "01987654321", "mumodtest@gmail"));
		UserWriter.writeUser();
	}
	
	/**
	 * clears users array list
	 */
	@After
	public void tearDown() {
		UserManager.getInstance().getUsers().clear();
		UserWriter.writeUser();
	}
	
	/**
	 * tests if a user is being added by getting the users ArrayList size before and after a user is added
	 */
	@Test
	public void testAddUser() {
		User jackie = new User("03", "Jackie", "jackie123", "52 Sesame Street", "5923908476", "jackie@aol");
		int originalSize = userManager.getUsers().size();
		userManager.addUser(jackie);
		assertEquals(originalSize+1, userManager.getUsers().size());
	}
	
	/**
	 * tests if a user is being removed by getting the users ArrayList size before and after a user is removed
	 */
	@Test
	public void testRemoveUser() {
		int originalSize = userManager.getUsers().size();
		User dom = new User("01", "Dom", "domum", "123 domum st", "12345678910", "domumtest@gmail");
		userManager.removeUser(dom);
		assertEquals(originalSize-1, userManager.getUsers().size());
	}
	
	/**
	 * tests if a taken user name returns true
	 */
	@Test
	public void testUserTakenTrue() {
		User thomas = new User("04", "Thomas", "thomas123", "61 Bride Way", "8694038175", "toams@hotmail");
		ArrayList<User> users = new ArrayList<User>();
		boolean originalTaken = users.contains(thomas);
		users.add(thomas);
		assertTrue(userManager.userTaken(thomas));
	}
	
	/**
	 * tests if a non existing user returns false
	 */
	@Test
	public void testUserTakenFalse() {
		User zach = new User("05", "Zach", "zach123", "0152 Ball St", "9658721096", "zach@hotmail");
		assertFalse(userManager.userTaken(zach));
	}
}
