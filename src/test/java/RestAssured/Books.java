package RestAssured;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;

public class Books {
    public static void main(String[] args) {
        String response = RestAssured.baseURI = "http://216.10.245.166";
        given().queryParam("")
                .header("Content-Type","application/json")
                .body(Files.payload.addplace())
        .when().post("Library/Addbook.php")
        .then().assertThat().statusCode(200).body("Msg", equalTo("successfully added")).toString();
        System.out.println(response);
        //given().queryParam("").header("","").body("")..when().post().then().assertThat().toString();
    }
}
