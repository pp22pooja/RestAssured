package FavQs;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class listQuots {


   private static final String API_KEY = "1420652901e991b9999ed79de899a189";
  //private static final String BaseURL = "https://example.com/api/quotes/";

  @Test(priority= 1)
    public void fuunyQuotes() {
        given()
           .header("Authorization", "Token " + API_KEY)
            .contentType("application/json")
            .when()
            .get("https://favqs.com/api/quotes/?filter=funny")
            .then()
            .statusCode(200)// Assuming 200 status code for successful login
            .log().body(); //  Logs for the quotes containing "funny"(PASS)
          
    }
    @Test(priority= 2)
    public void markTwainQuotes() {
        given()
           .header("Authorization", "Token " + API_KEY)
            .contentType("application/json")
            .when()
            .get("https://favqs.com/api/quotes/?filter=Mark+Twain&type=author")
            .then()
            .statusCode(200)// Assuming 200 status code for successful login
            .body("page", equalTo(1))
            .log().body();//  Logs for the quotes of Mark Twain (PASS)
           
    }
    @Test(priority= 3)
    public void hiddenQuotes() {
        given()
           .header("Authorization", "Token " + API_KEY)
            .contentType("application/json")
            .when()
            .get("https://favqs.com/api/quotes/?filter=little+book&private=1")
            .then()
            .statusCode(200)// Assuming 200 status code for successful login
            .body("page", equalTo(1))
            .log().body(); // need the user session for this(Fail)
          
    }

}