package FavQs;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

  public class favQuotes {

   @Test
   public void testLogin() {
   // Set base URI of your API
   RestAssured.baseURI = "https://favqs.com/api/session";

   String token = login("pooja.pingale22.pp@gmail.com", "8bbcbfad26f173", "1420652901e991b9999ed79de899a189");

   // Ensure token is obtained
   assertNotNull(token, "Login failed.");
   System.out.println("Token: " + token);
    }

     // Method to perform login and obtain token
     public static String login(String username, String password, String authenticationKey) {
     Response response = RestAssured.given()
     .contentType(ContentType.JSON)
     .header("Authorization", "Bearer " + authenticationKey) 
     .body("{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }")
     .post("/login");

      if (response.getStatusCode() == 200) {
          return response.jsonPath().getString("token");
       } else {
          return null;        }
      }
    }