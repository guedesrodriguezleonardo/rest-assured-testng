import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PlaceOrder {

    @Test
    public void placeOrder() {
        baseURI = "https://petstore.swagger.io/v2";

        given()
            .contentType("application/json")
            .body("{\n" +
                    "  \"id\": 78,\n" +
                    "  \"petId\": 30,\n" +
                    "  \"quantity\": 1,\n" +
                    "  \"shipDate\": \"2023-05-04T23:57:02.633Z\",\n" +
                    "  \"status\": \"placed\",\n" +
                    "  \"complete\": true\n" +
                    "}")
        .when()
            .post("/store/order")
        .then()
            .statusCode(200)
            .body("status", equalTo("placed"));
    }
}
