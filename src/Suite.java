
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
		return "Name: (fill in soon) \nListID: " + listID + "\nPrice: " + price + "\nBedrooms: " + numBedrooms + "\nBathrooms: " + numBathrooms + "\nAvailable Units: " + numAvailable;
	}
	
}
