import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserWriter {
    private static final String FILE_LOCATION = "database/users.json";
    public static void writeUser() {
        JsonArray jArray = new JsonArray();
        UserManager um =  UserManager.getInstance(); // Calling the singleton
        // Create Objects
        ArrayList<User> users = um.users;
        for(User u:users)
            jArray.add(getUserJSON(u));
        // Create file and write to it
        File f = new File(FILE_LOCATION);
        try (FileWriter file = new FileWriter(f)) {
            file.write(jArray.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static JsonObject getUserJSON(User user) {
        JsonObject userDetails = new JsonObject();
//        Gson gson = new Gson();
        userDetails.addProperty("id", user.getId());
        userDetails.addProperty("name", user.getName());
        userDetails.addProperty("password", user.getPassword());
        userDetails.addProperty("address", user.getAddress());
        userDetails.addProperty("phone", user.getPhone());
        userDetails.addProperty("email", user.getEmail());
        JsonArray jReviewArray = new JsonArray();
        for(Review r:user.getReviews()) {
            JsonObject jReview = new JsonObject();
            jReview.addProperty("authorID", r.authorID);
            jReview.addProperty("date", r.date);
            jReview.addProperty("reviewText", r.reviewText);
            jReview.addProperty("rating", r.rating);
            jReviewArray.add(jReview);
        }
        // Agent vs Student
        if (user instanceof Student) {
            JsonArray jListingArray = new JsonArray();
            for(int i:((Student) user).getFavoriteListings())
                jListingArray.add(i);
            userDetails.add("favoriteListingIDs", jListingArray);
        } else if (user instanceof Agent) {

        } else
            return null; // User that's not an Agent or Student, for whatever reason
        return userDetails;
    }
}
