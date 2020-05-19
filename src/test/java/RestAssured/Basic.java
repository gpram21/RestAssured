package RestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import static  io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;


public class Basic {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com/";

        String response = given().queryParam("key","qaclick123").header("Content-Type","application/json")
        .body(Files.payload.addplace()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
                .body("scope",equalTo("APP"))
        .header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

        System.out.println("Prabhu ----- Response" + response);
        JsonPath js = new JsonPath(response);
        String placeID =  js.getString("place_id");
        System.out.println("Prabhu ----- Response" + placeID);

        String newAdreess = "20 summer talk";

         given().queryParam("place_id",placeID.trim()).queryParam("key","qaclick123").header("Content-Type","application/json")
                .body("{\n" +
                        "\"place_id\":\"" + placeID.trim() +"\",\n" +
                        "\"address\":\"" +    newAdreess.trim()            +"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when().put("/maps/api/place/update/json")
                .then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));



        String res = given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeID.trim())
                .when().get("/maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();

        }


}
