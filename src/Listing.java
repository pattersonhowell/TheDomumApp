import java.util.ArrayList;

public class Listing {
	public int listingID;
	public String agentID;
	protected double price;
	protected String address; 
	protected int numBathroom; 
	protected int numBedroom;
	protected ArrayList<Review> reviews; 
	protected int numberAvalible; 
	protected int yearBuilt;

	public Listing(int listingID, String agentID, double price, String address, int numBathroom, int numBedroom,
			ArrayList<Review> reviews, int numberAvalible, int yearBuilt) {
		this.listingID = listingID;
		this.agentID = agentID;
		this.price = price;
		this.address = address;
		this.numBathroom = numBathroom;
		this.numBedroom = numBedroom;
		this.reviews = reviews;
		this.numberAvalible = numberAvalible;
		this.yearBuilt = yearBuilt;
	}

	public String toString() {
		return "Listing [agent=" + agent + ", listingID=" + listingID + ", price=" + price + ", address=" + address
				+ ", numBathroom=" + numBathroom + ", numBedroom=" + numBedroom + ", reviews=" + reviews
				+ ", numberAvalible=" + numberAvalible + ", yearBuilt=" + yearBuilt + "]";
	} 

	public ArrayList<Review> getReview() {
		return this.reviews;
	}
	
	public void addReview(Review review) {
		reviews.add(review);
	}

}