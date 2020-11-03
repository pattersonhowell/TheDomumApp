import java.util.ArrayList;

/**
 * Base class of a student user
 * @author pattersonhowell
 *
 */
public class Student extends User {

	private ArrayList<Integer> favoriteListings;
	
	/**
	 * Creating a Student
	 * @param id Their ID
	 * @param name Their name 
	 * @param password Their password
	 * @param address Their address
	 * @param phone Their phone number
	 * @param email Their email
	 */
	public Student(String id, String name, String password, String address, String phone, String email)  {
		super(id, name, password, address, phone, email);
		favoriteListings = new ArrayList<>();
	}
	
	/**
	 * Displaying their information
	 */
	public String toString() {
		return super.toString();
	}
	
	/**
	 * Setting their favorite listings
	 * @param favoriteListings list to set
	 */
	public void setFavoriteListings(ArrayList<Integer> favoriteListings) {
		this.favoriteListings = favoriteListings;
	}
	
	/**
	 * Getting their favorite listings
	 * @return their favorite listings
	 */
	public ArrayList<Integer> getFavoriteListings() {
		return favoriteListings;
	}	
	
	/**
	 * Favoriting a listing 
	 * @param listing Listing to favorite
	 */
	public void favoriteListing(Integer listing) {
		 favoriteListings.add(listing);
	}
	
}
