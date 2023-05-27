import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class GetPetByStatus {

    @Test
    public void verifyAvailablePetsReturned() {
        baseURI = "https://petstore.swagger.io/v2";

        given()
            .param("status", "available")
        .when()
            .get("/pet/findByStatus")
        .then()
            .statusCode(200)
            .header("Content-Type", equalTo("application/json"))
            .body("status", everyItem(equalTo("available")));
    }
}
