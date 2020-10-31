import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ListingWriter extends DataConstants {

	public static void writeListings() {
		JsonObject jBase = new JsonObject();
		JsonArray jArray = new JsonArray();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		ListingManager lm = ListingManager.getInstance();
		// Create objects
		ArrayList<Listing> listings = lm.getListings();
		for(Listing l:listings)
			jArray.add(getListingJSON(l));
		jBase.add("listings", jArray);
		// Create a file and write to it
		File f = new File(LISTING_FILE_LOCATION);
		try (FileWriter file = new FileWriter(f)) {
			file.write(gson.toJson(jBase));
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static JsonObject getListingJSON(Listing listing) {
		JsonObject listingDetails = new JsonObject();
		listingDetails.addProperty("listingID", listing.getListingID());
		listingDetails.addProperty("agentID", listing.getAgentID());
		listingDetails.addProperty("price", listing.getPrice());
		listingDetails.addProperty("address", listing.getAddress());
		listingDetails.addProperty("numBathroom", listing.getNumBathroom());
		listingDetails.addProperty("numBedroom", listing.getNumBedroom());
		listingDetails.addProperty("distFromCampus", listing.getDistFromCampus());
		JsonArray jReviewArray = new JsonArray();
		for (Review r:listing.reviews) {
			JsonObject jReview = new JsonObject();
			jReview.addProperty("listID", r.listID);
			jReview.addProperty("authorID", r.authorID);
			jReview.addProperty("date", r.date);
			jReview.addProperty("reviewText", r.reviewText);
			jReview.addProperty("rating", r.rating);
			jReviewArray.add(jReview);
		}
		listingDetails.add("reviews", jReviewArray);
		
		JsonArray jSuiteArray = new JsonArray();
		for (Suite s: listing.suites) {
			JsonObject jSuite = new JsonObject();
			jSuite.addProperty("listID", s.listID);
			jSuite.addProperty("numBedrooms", s.numBedrooms);
			jSuite.addProperty("numBathrooms", s.numBathrooms);
			jSuite.addProperty("availableUnits", s.numAvailable);
			jSuite.addProperty("price", s.price);
			
		}
		listingDetails.add("suites", jSuiteArray);
		
		listingDetails.addProperty("numberAvailable", listing.getNumberAvalible());
		listingDetails.addProperty("yearBuilt", listing.getYearBuilt());
		listingDetails.addProperty("freeWifi", listing.isFreeWifi());
		listingDetails.addProperty("laundry", listing.isLaundry());
		listingDetails.addProperty("petFriendly", listing.isPetFriendly());
		listingDetails.addProperty("pool", listing.isPool());
		listingDetails.addProperty("furnished", listing.isFurnished());
		return listingDetails;
	}
}
