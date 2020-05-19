package RestAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.Test;


public class DataFromFile {
    @Test
    public void filemode() throws IOException {
        RestAssured.baseURI = "http://216.10.245.166";
        String filemode_rs = given().queryParam("").header("Content-Type","application/json")
                .body(generateJsonFromFile("C:\\Tools\\Account\\Telia\\Cucumber\\Addbook.json"))
        .when().post("Library/Addbook.php")
        .then().assertThat().statusCode(200).extract().asString();

    }

    public static String generateJsonFromFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
