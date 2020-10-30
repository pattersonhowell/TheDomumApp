
public class Review {

	UserManager manager = UserManager.getInstance();
	private Systems systems;

	public int listID;
	public String authorID;
	public String date;
	public String reviewText;
	public int rating;

	public Review(int listID, int rating, String authorID, String date,String reviewText) {
		this.listID = listID;
		this.rating = rating;
		this.authorID = authorID;
		this.date = date;
		this.reviewText = reviewText;
	}

	public String toString() {
		return "Review by: " + authorID + " on " + date + ":\n" + "Rating: " + rating + "\n" + "Message: " + reviewText;
	}
}
