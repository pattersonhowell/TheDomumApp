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
		return "Listing [agentID=" + agentID + ", listingID=" + listingID + ", price=" + price + ", address=" + address
				+ ", numBathroom=" + numBathroom + ", numBedroom=" + numBedroom + ", reviews=" + reviews
				+ ", numberAvalible=" + numberAvalible + ", yearBuilt=" + yearBuilt + "]";
	} 

	public ArrayList<Review> getReview() {
		return this.reviews;
	}
	
	public void addReview(Review review) {
		reviews.add(review);
	}

	public int getListingID() {
		return listingID;
	}

	public void setListingID(int listingID) {
		this.listingID = listingID;
	}

	public String getAgentID() {
		return agentID;
	}

	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumBathroom() {
		return numBathroom;
	}

	public void setNumBathroom(int numBathroom) {
		this.numBathroom = numBathroom;
	}

	public int getNumBedroom() {
		return numBedroom;
	}

	public void setNumBedroom(int numBedroom) {
		this.numBedroom = numBedroom;
	}

	public int getNumberAvalible() {
		return numberAvalible;
	}

	public void setNumberAvalible(int numberAvalible) {
		this.numberAvalible = numberAvalible;
	}

	public int getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

}
