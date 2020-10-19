
public class Review {
	public String author; 
	public String date;
	public String reviewText;
	public int rating; 
	
	public Review(int rating, String author, String date,String reviewText) {
		this.rating = rating; 
		this.author = author;
		this.date = date;
		this.reviewText = reviewText; 
	}
}
