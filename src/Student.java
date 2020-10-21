import java.util.ArrayList;

public class Student extends User {

	private ArrayList<Integer> favoriteListings;
	
	public Student() {
		super();
	}
	
	public String toString() {
		return super.toString();
	}
	
	public void leaveReview(Review review) {
		
		int rating = 0;
		String author = "";
		String date = "";
		String reviewText = "";
		
		
		Review rev = new Review(rating, author, date, reviewText);
	}
	
	public void favoriteListing(Integer listing) {
		 favoriteListings.add(listing);
	}
	
}
