import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class GetPetById {

    @Test
    public void findPetById() {
        baseURI = "https://petstore.swagger.io/v2";

        given()
            .pathParam("petId", 30)
        .when()
            .get("/pet/{petId}")
        .then()
            .statusCode(200)
            .body("id", equalTo(30))
            .body("category.id", equalTo(2))
            .body("category.name", equalTo("Cat"))
            .body("name", equalTo("Lemon"))
            .body("status", equalTo("available"))
            .header("Content-Type", equalTo("application/json"));
    }
}
