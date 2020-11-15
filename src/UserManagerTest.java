import static org.junit.Assert.*;

import org.junit.BeforeClass;

/**
 * testing class for user manager
 * 
 * @author Thomas
 */
public class UserManagerTest {
	private UserManager userManager = UserManager.getInstance();
	
	/**
	 * 
	 */
	@Before
	public void setup() throws Exception {
		userManager.getUsers().clear();
		userManager.addUser(new User("01", "Dom", "domum", "123 domum st", "12345678910", "domumtest@gmail"));
		userManager.addUser(new User("02", "Mum", "mumod", "123 mumod st", "01987654321", "mumodtest@gmail"));
		UserWriter.writeUser();
	}
	
	/**
	 * 
	 */
	@After
	public void tearDown() {
		UserManager.getInstance().getUsers().clear();
		UserWriter.writeUser();
	}
	
	@Test
	public void testAddUser() {
		User jackie = new User("03", "Jackie", "jackie123", "52 Sesame Street", "5923908476", "jackie@aol");
	}
}
