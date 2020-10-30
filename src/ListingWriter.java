import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ListingWriter extends DataConstants {

	// TODO Still needs to interface with ListingManager
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
		System.out.println(gson.toJson(jBase));
		/*File f = new File(LISTING_FILE_LOCATION);
		try (FileWriter file = new FileWriter(f)) {
			file.write(jBase.toString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();*//*
		}*/
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
			jReview.addProperty("authorID", r.authorID);
			jReview.addProperty("date", r.date);
			jReview.addProperty("reviewText", r.reviewText);
			jReview.addProperty("rating", r.rating);
			jReviewArray.add(jReview);
		}
		listingDetails.add("reviews", jReviewArray);
		listingDetails.addProperty("numberAvailable", listing.getNumberAvalible());
		listingDetails.addProperty("yearBuilt", listing.getYearBuilt());
		return listingDetails;
	}
}
