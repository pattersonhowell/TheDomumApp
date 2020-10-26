import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.*;
//import org.json.simple.JSONArray;

public class ListingLoader {

	private static final String FILE_LOCATION = "database/listing.json";
	// TODO Still needs to interface with ListingManager
	public static ArrayList<Listing> loadListings() {
		Gson gson = new Gson();
		ArrayList<Listing> listings = new ArrayList<>();

		try {
			// Parses the given file using JsonParser and casts it as a JsonArray
			JsonArray jsonArray= (JsonArray)JsonParser.parseReader(new FileReader(FILE_LOCATION));
			for (int i = 0; i < jsonArray.size(); i++) {
				JsonObject listingJSON = (JsonObject)jsonArray.get(i);
				// Gets each field and transforms them into their respective type
				int listingID = listingJSON.get("listingID").getAsInt();
				String agentID = listingJSON.get("agentID").getAsString();
				double price = listingJSON.get("price").getAsDouble();
				String address = listingJSON.get("address").getAsString();
				int numBathroom = listingJSON.get("numBathroom").getAsInt();
				int numBedroom = listingJSON.get("numBedroom").getAsInt();
				int distFromCampus = listingJSON.get("distFromCampus").getAsInt();
				int numAvailable = listingJSON.get("numberAvailable").getAsInt();
				int yearBuilt = listingJSON.get("yearBuilt").getAsInt();

				// "reviews" is an object, so we need a special case
				ArrayList<Review> reviews = new ArrayList<>();
				JsonArray reviewsJSON = listingJSON.getAsJsonArray("reviews");
				for (int j = 0; j < reviewsJSON.size(); j++) {
					JsonObject reviewJSON = (JsonObject)reviewsJSON.get(j);
					String authorID = reviewJSON.get("authorID").getAsString();
					String date = reviewJSON.get("date").getAsString();
					String reviewText = reviewJSON.get("reviewText").getAsString();
					int rating = reviewJSON.get("rating").getAsInt();
					Review r = new Review(rating, authorID, date, reviewText);
					reviews.add(r);
				}

				// Finally, add all these together
				Listing l = new Listing(listingID, agentID, price, address, numBathroom, numBedroom,
						reviews, numAvailable, yearBuilt, distFromCampus);
				listings.add(l);
			}
			return listings;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
