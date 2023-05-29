import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Login {

    @Test
    public void validUserLogin() {
        baseURI = "https://petstore.swagger.io/v2";

        given()
            .param("username", "testuser1")
            .param("password", "Password123")
        .when()
            .get("/user/login")
        .then()
            .statusCode(200)
            .body("code", equalTo(200))
            .body("type", equalTo("unknown"))
            .body("message", containsString("logged in user session:"));
    }
}
