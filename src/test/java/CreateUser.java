import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateUser {

    @Test
    public void createUser() {
        baseURI = "https://petstore.swagger.io/v2";

        List<Map<String, Object>> users = new ArrayList<>();
        Map<String, Object> user = new HashMap<>();
        user.put("id", 13);
        user.put("username", "testuser1");
        user.put("firstName", "Test");
        user.put("lastName", "User");
        user.put("email", "testuser1@email.com");
        user.put("password", "Password123");
        user.put("phone", "123456789");
        user.put("userStatus", 0);
        users.add(user);

        given()
            .contentType(ContentType.JSON)
            .body(users)
        .when()
            .post("/user/createWithList")
        .then()
            .statusCode(200);
    }
}
