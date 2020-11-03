/**
 * Base class for a Suite in a Listing (Complex)
 * @author pattersonhowell
 */
public class Suite {

	public int listID;
	public int numBedrooms;
	public int numBathrooms;
	public int numAvailable;
	public double price;

	/**
	 * Creating a Suite
	 * @param listID ID of complex
	 * @param numBedrooms bedrooms in suite
	 * @param numBathrooms bathrooms in suite
	 * @param numAvailable availibility of suite
	 * @param price Suite price
	 */
	public Suite(int listID, int numBedrooms, int numBathrooms, int numAvailable, double price) {
		this.listID = listID;
		this.numBedrooms = numBedrooms;
		this.numBathrooms = numBathrooms;
		this.numAvailable = numAvailable;
		this.price = price;
	}

	/**
	 * Displaying information about a Suite
	 */
	public String toString() {
		return "\nListID: " + listID + "\nPrice: " + price + "$\nBedrooms: " + numBedrooms + "\nBathrooms: " + numBathrooms + "\nAvailable Units: " + numAvailable;
	}
	
	
	/*************************************
	 * Basic getters for Suite attributes
	 * @return what was retrieved
	 */
	public int getlistID() {
		return listID;
	}
	
	public int getNumBedrooms() {
		return numBedrooms;
	}
	
	public int getNumBathrooms() {
		return numBathrooms;
	}
	
	public int getNumAvailable() {
		return numAvailable;
	}
	
	public double getPrice() {
		return price;
	}
	
	

	
	
}
