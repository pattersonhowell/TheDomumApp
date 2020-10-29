import java.util.ArrayList;
import java.io.FileReader;
import com.google.gson.*;

public class UserLoader extends DataConstants{

	public ArrayList<User> loadUsers() {
		ArrayList<User> users = new ArrayList<>();
		try {
			// Parse file, remove array
			JsonObject jParserOut = (JsonObject)JsonParser.parseReader(new FileReader(LISTING_FILE_LOCATION));
			JsonArray jsonArray = jParserOut.getAsJsonArray("users");
			for (int i = 0; i < jsonArray.size(); i++) {
				JsonObject userJSON = (JsonObject)jsonArray.get(i);
				User user;
				int id = userJSON.get("id").getAsInt();
				String name = userJSON.get("name").getAsString();
				String password = userJSON.get("password").getAsString();
				String address = userJSON.get("address").getAsString();
				String phone = userJSON.get("phone").getAsString();
				String email = userJSON.get("email").getAsString();

				ArrayList<Review> reviews = new ArrayList<>();
				JsonArray reviewsJSON = userJSON.getAsJsonArray("reviews");
				for (JsonElement reviewElement:reviewsJSON) {
					JsonObject reviewJSON = (JsonObject)reviewElement;
					int authorID = reviewJSON.get("authorID").getAsInt();
					String date = reviewJSON.get("date").getAsString();
					String reviewText = reviewJSON.get("reviewText").getAsString();
					int rating = reviewJSON.get("rating").getAsInt();
					Review r = new Review(rating, authorID, date, reviewText);
					reviews.add(r);
				}

				if (userJSON.has("favoriteListingIDs")) { // User is a Student
					JsonArray faveListJSON = userJSON.get("favoriteListingIDs").getAsJsonArray();
					ArrayList<Integer> faveList = new ArrayList<>();
					for (JsonElement je:faveListJSON)
						faveList.add(je.getAsInt());
					user = new Student(id, name, password, address, phone, email, reviews);
					// TODO Add faveList
				} else { // User is an Agent
					String realtyGroup = userJSON.get("realtyGroup").getAsString();
					JsonArray managedListJSON = userJSON.get("managedListingIDs").getAsJsonArray();
					ArrayList<Integer> managedList = new ArrayList<>();
					for (JsonElement je:managedListJSON)
						managedList.add(je.getAsInt());
					user = new Agent(id, name, password, address, phone, email, reviews, realtyGroup);
					// TODO Add managedList
				}
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
