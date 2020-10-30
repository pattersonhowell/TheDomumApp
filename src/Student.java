import java.util.ArrayList;

public class Student extends User {

	private ArrayList<Integer> favoriteListings;
	
	public Student(String id, String name, String password, String address, String phone, String email)  {
		super(id, name, password, address, phone, email);
		favoriteListings = new ArrayList<>();
	}
	
	public String toString() {
		return super.toString();
	}


	public void setFavoriteListings(ArrayList<Integer> favoriteListings) {
		this.favoriteListings = favoriteListings;
	}
	
	public ArrayList<Integer> getFavoriteListings() {
		return favoriteListings;
	}	
	
	public void leaveReview(Review review) {		
		int listID = 0;
		int rating = 0;
		String author = "";
		String date = "";
		String reviewText = "";		
		Review rev = new Review(listID, rating, author, date, reviewText);
	}
	
	

	public void favoriteListing(Integer listing) {
		 favoriteListings.add(listing);
	}
	
}
