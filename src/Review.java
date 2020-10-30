
public class Review {
	
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
		return "Review by: " + "on " + date + ":\n" + reviewText;
	}
}



