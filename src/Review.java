
public class Review {
	
	public String authorID;
	public String date;
	public String reviewText;
	public int rating; 
	
	public Review(int rating, String authorID, String date,String reviewText) {
		this.rating = rating; 
		this.authorID = authorID;
		this.date = date;
		this.reviewText = reviewText; 
	}
}



