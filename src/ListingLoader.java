import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.*;
//import com.google.gson.stream.JsonReader;

public class ListingLoader extends DataConstants{

	public static ArrayList<Listing> loadListings() {
//		Gson gson = new Gson();
		ArrayList<Listing> listings = new ArrayList<>();

		try {
			// Takes the parsed file and takes the array out of the object
			JsonObject jParserOut = (JsonObject)JsonParser.parseReader(new FileReader(LISTING_FILE_LOCATION));
			JsonArray jsonArray = jParserOut.getAsJsonArray("listings");
			for (int i = 0; i < jsonArray.size(); i++) {
				JsonObject listingJSON = (JsonObject)jsonArray.get(i);
				// Gets each field and transforms them into their respective type
				int listingID = listingJSON.get("listingID").getAsInt();
				String agentID = listingJSON.get("agentID").getAsString();
				//double price = listingJSON.get("price").getAsDouble();
				String address = listingJSON.get("address").getAsString();
				//int numBathroom = listingJSON.get("numBathroom").getAsInt();
				//int numBedroom = listingJSON.get("numBedroom").getAsInt();
				//int numAvailable = listingJSON.get("numberAvailable").getAsInt();
				int yearBuilt = listingJSON.get("yearBuilt").getAsInt();
				double distFromCampus = listingJSON.get("distFromCampus").getAsDouble();
				boolean freeWifi = listingJSON.get("freeWifi").getAsBoolean();
				boolean laundry = listingJSON.get("laundry").getAsBoolean();
				boolean petFriendly = listingJSON.get("petFriendly").getAsBoolean();
				boolean pool = listingJSON.get("pool").getAsBoolean();
				boolean gym = listingJSON.get("gym").getAsBoolean();
				boolean furnished = listingJSON.get("furnished").getAsBoolean();

				// "reviews" is an object, so we need a special case
				ArrayList<Review> reviews = new ArrayList<>();
				JsonArray reviewsJSON = listingJSON.getAsJsonArray("reviews");
				for (int j = 0; j < reviewsJSON.size(); j++) {
					JsonObject reviewJSON = (JsonObject)reviewsJSON.get(j);
					int listID = reviewJSON.get("listID").getAsInt();
					String authorID = reviewJSON.get("authorID").getAsString();
					String date = reviewJSON.get("date").getAsString();
					String reviewText = reviewJSON.get("reviewText").getAsString();
					int rating = reviewJSON.get("rating").getAsInt();
					Review r = new Review(listID, rating, authorID, date, reviewText);
					reviews.add(r);
				}
				
				// "suites" is an object, so we also need a special case
				ArrayList<Suite> suites = new ArrayList<>();
				JsonArray suitesJSON = listingJSON.getAsJsonArray("suites");
				for (int j = 0; j < suitesJSON.size(); j++) {
					JsonObject suiteJSON = (JsonObject)suitesJSON.get(j);
					int listID = suiteJSON.get("listID").getAsInt();
					int numBedrooms = suiteJSON.get("numBedrooms").getAsInt();
					int numBathrooms = suiteJSON.get("numBathrooms").getAsInt();
					int numberAvailable = suiteJSON.get("numAvailable").getAsInt();
					double prices = suiteJSON.get("price").getAsDouble();
					
					Suite s = new Suite(listID, numBedrooms, numBathrooms, numberAvailable, prices);
					suites.add(s);
					
				}

				// Finally, add all these together
				Listing l = new Listing(listingID, agentID, address,
						/*reviews,*/ suites, yearBuilt, distFromCampus, freeWifi, laundry,
						petFriendly, pool, gym, furnished);
				listings.add(l);
			}
			return listings;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
