import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserWriter extends DataConstants {
    public static void writeUser() {
        JsonObject jBase = new JsonObject();
        JsonArray jArray = new JsonArray();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        UserManager um =  UserManager.getInstance(); // Calling the singleton
        // Create Objects
        ArrayList<User> users = um.getUsers();
        for(User u:users)
            jArray.add(getUserJSON(u));
        jBase.add("users", jArray);
        // Create file and write to it
        System.out.println(gson.toJson(jBase));
        File f = new File(USERS_FILE_LOCATION);
        try (FileWriter file = new FileWriter(f)) {
            file.write(gson.toJson(jBase));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static JsonObject getUserJSON(User user) {
        JsonObject userDetails = new JsonObject();
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
