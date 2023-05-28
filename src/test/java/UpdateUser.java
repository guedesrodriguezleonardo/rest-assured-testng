import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class UpdateUser {

    @Test
    public void updateUser() {
        baseURI = "https://petstore.swagger.io/v2";

        // Update User
        given()
            .pathParam("username", "testuser1")
            .contentType(ContentType.JSON)
            .body("{\n" +
                    "  \"id\": 1,\n" +
                    "  \"username\": \"testuser1\",\n" +
                    "  \"firstName\": \"newname\",\n" +
                    "  \"lastName\": \"newlastname\",\n" +
                    "  \"email\": \"newemail@example.com\",\n" +
                    "  \"password\": \"NewPassword123\",\n" +
                    "  \"phone\": \"987654321\",\n" +
                    "  \"userStatus\": 1\n" +
                    "}")
        .when()
            .put("/user/{username}")
        .then()
            .statusCode(200);
        
        // Verify User Update
        given()
            .pathParam("username", "testuser1")
        .when()
            .get("/user/{username}")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("username", equalTo("testuser1"))
            .body("firstName", equalTo("newname"))
            .body("lastName", equalTo("newlastname"));
    }
}
