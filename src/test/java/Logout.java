import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Logout {

    @Test
    public void userLogout() {
        baseURI = "https://petstore.swagger.io/v2";

        given()
        .when()
            .get("/user/logout")
        .then()
            .statusCode(200)
            .body("message", equalTo("ok"));
    }
}
