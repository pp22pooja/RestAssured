package FavQs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginAPITest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://favqs.com/login";
    }

    @Test
    public void testLogin() {
        // Request body with login credentials
        String requestBody = "{ \"user\": { \"login\": \"pooja.pingale22.pp@gmail.com\", \"password\": \"8bbcbfad26f173\" } }";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
               .post("https://favqs.com/api/session");

        assertEquals(response.getStatusCode(), 200, "Login request failed");

    }
}

