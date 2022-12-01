package API_tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRequestTest {

    @Test
    public void getRequestTest() {
        given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .queryParam("page", 2)
                .get("https://reqres.in/api/users")
                .then().log().all()
                .and()
                .statusCode(200);
    }
}
