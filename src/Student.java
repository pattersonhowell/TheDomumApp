import java.util.ArrayList;

public class Student extends User {

	private ArrayList<Listing> favoriteListings;
	
	public Student() {
		super();
	}
	
	public String toString() {
		return super.toString();
	}
	
	public void leaveReview(Review review) {
		//leave a review
	}
	
	public void favoriteListing(Listing listing) {
		//favorite a listing
	}
	
}
