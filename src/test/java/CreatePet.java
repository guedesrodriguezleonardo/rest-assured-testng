import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreatePet {

    @Test
    public void createPet() {
        baseURI = "https://petstore.swagger.io/v2";

        Map<String, Object> pet = new HashMap<>();
        pet.put("id", 30);
        
        Map<String, Object> category = new HashMap<>();
        category.put("id", 2);
        category.put("name", "Cat");
        pet.put("category", category);
        
        pet.put("name", "Lemon");
        
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Cat.png/766px-Cat.png");
        pet.put("photoUrls", photoUrls);
        
        List<Map<String, Object>> tags = new ArrayList<>();
        Map<String, Object> tag = new HashMap<>();
        tag.put("id", 9);
        tag.put("name", "cute");
        tags.add(tag);
        pet.put("tags", tags);
        
        pet.put("status", "available");

        given()
            .contentType(ContentType.JSON)
            .body(pet)
        .when()
            .post("/pet")
        .then()
            .statusCode(200);
    }
}