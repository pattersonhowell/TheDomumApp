/**
 * Base class for a Review of a listing (complex)
 * @author pattersonhowell
 *
 */
public class Review {
	
	public int listID;
	public String authorID;
	public String date;
	public String reviewText;
	public int rating;

	/**
	 * Creating a Review
	 * @param listID ID of complex
	 * @param rating Rating number of complex
	 * @param authorID ID of user writing the review
	 * @param date When user wrote review
	 * @param reviewText Actual Message of the review
	 */
	public Review(int listID, int rating, String authorID, String date,String reviewText) {
		this.listID = listID;
		this.rating = rating;
		this.authorID = authorID;
		this.date = date;
		this.reviewText = reviewText;
	}

	/**
	 * Displaying a review
	 */
	public String toString() {
		return "Review by: " + authorID + " on " + date + ":\n" + "Rating: " + rating + "\n" + "Message: " + reviewText;
	}
}
