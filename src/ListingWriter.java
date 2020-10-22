import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ListingWriter {
	private static final String FILE_LOCATION = "database/listing.json";

	// TODO Still needs to interface with ListingManager
	public void writeListings(ArrayList<Listing> listings) {
		JsonArray jArray = new JsonArray();
		// Create objects
		for(Listing l:listings)
			jArray.add(getListingJSON(l));
		// Create a file and write to it
		File f = new File(FILE_LOCATION);
		try (FileWriter file = new FileWriter(f)) {
			file.write(jArray.toString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private JsonObject getListingJSON(Listing listing) {
		JsonObject listingDetails = new JsonObject();
		listingDetails.addProperty("listingID", listing.listingID);
		listingDetails.addProperty("agentID", listing.agentID);
		listingDetails.addProperty("price", listing.price);
		listingDetails.addProperty("address", listing.address);
		listingDetails.addProperty("numBathroom", listing.numBathroom);
		listingDetails.addProperty("numBedroom", listing.numBedroom);
		listingDetails.addProperty("distFromCampus", listing.distFromCampus);
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
		listingDetails.addProperty("numberAvailable", listing.numberAvalible);
		listingDetails.addProperty("yearBuilt", listing.yearBuilt);
		return listingDetails;
	}
}
