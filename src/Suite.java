
public class Suite {

	public int listID;
	public int numBedrooms;
	public int numBathrooms;
	public int numAvailable;
	public double price;

	public Suite(int listID, int numBedrooms, int numBathrooms, int numAvailable, double price) {
		this.listID = listID;
		this.numBedrooms = numBedrooms;
		this.numBathrooms = numBathrooms;
		this.numAvailable = numAvailable;
		this.price = price;
	}

	public String toString() {
		return "\nListID: " + listID + "\nPrice: " + price + "$\nBedrooms: " + numBedrooms + "\nBathrooms: " + numBathrooms + "\nAvailable Units: " + numAvailable;
	}
	
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
