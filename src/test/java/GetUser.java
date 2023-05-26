import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class GetUser {

    @Test
    public void getUserByUsername() {
        baseURI = "https://petstore.swagger.io/v2";

        given()
            .pathParam("username", "testuser1")
        .when()
            .get("/user/{username}")
        .then()
            .statusCode(200)
            .body("username", equalTo("testuser1"));
    }
}
