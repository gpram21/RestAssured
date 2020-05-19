package RestAssured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
//import org.junit.Test;
import static io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;

public class DynamicJson {

    @Test(dataProvider="BooksData")
    public void addBook(String ISDN, String Aisle){
        RestAssured.baseURI = "http://216.10.245.166/";
        String res = given().queryParam("").header("Content-Type","application/json")
                .body(Files.payload.Addbook(ISDN,Aisle))
        .when().post("Library/Addbook.php")
        .then().assertThat().statusCode(200)
        .extract().response().asString();
        JsonPath js = new JsonPath(res);
        String StrID  = js.get("ID");
        System.out.println(StrID);
        String StrDeleteRes = given().log().all().queryParam("").header("Content-Type","application/json").body(Files.payload.Deletebook(StrID))
        .when().post("Library/DeleteBook.php")
        .then().assertThat().statusCode(200).body("msg",equalTo("book is successfully deleted"))
               .extract().response().asString();
       // JsonPath js1 = new JsonPath(StrDeleteRes);
        //System.out.println(js1.get("msg").toString());
    }

    @DataProvider(name="BooksData")
    public Object[][] getData(){

        return new Object[][]{{"Prabhu1", "213213"}, {"Prabhu2", "213214"}, {"Prabhu3", "213214"}};

    }
}
