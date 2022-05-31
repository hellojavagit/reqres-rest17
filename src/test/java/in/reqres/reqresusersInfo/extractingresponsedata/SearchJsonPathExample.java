package in.reqres.reqresusersInfo.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
        response = given()
                .queryParam("page",2)
                .when()
                .get("/users")
                .then().statusCode(200);
    }
    //1.page = 2
    @Test
    public void test001() {
        int page = response.extract().path("page");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of page is : " + page);
        System.out.println("------------------End of Test---------------------------");
    }
    //2.per_page = 6
    @Test
    public void test002() {
        int perPage = response.extract().path("per_page");

        System.out.println("\n------------------StartingTest---------------------------");
        System.out.println("per_page value is  : " + perPage);
        System.out.println("------------------End of Test---------------------------");

    }

    // 3).data[1].id = 8
    @Test
    public void test003() {
      int value = response.extract().path("data[1].id");

        System.out.println("\n------------------StartingTest---------------------------");
        System.out.println("Verifying  the value at id 3: " + value);
        System.out.println("------------------End of Test---------------------------");
    }

    // 4) data[3].first_name = Byron
    @Test
    public void test004() {
       String fName = response.extract().path("data[3].first_name");
        System.out.println("\n-----------------StartingTest---------------------------");
        System.out.println("Verifying the name at record 4 : "+ fName);
        System.out.println("------------------End of Test---------------------------");

    }

    // 5)list of data = 6
    @Test
    public void test005() {
        List<String> data = response.extract().path("data");

        System.out.println("\n-----------------StartingTest---------------------------");
        System.out.println("The size of the data is : " + data.size());
        System.out.println("------------------End of Test---------------------------");
    }

    // 6) sdata[5].avatar="https://reqres.in/img/faces/11-im
    //age.jpg"
    public void test006() {

    String avatar = response.extract().path("data[5].avatar");
        System.out.println("\n------------------StartingTest---------------------------");
        System.out.println("TVerifying avatar : " + avatar);
        System.out.println("------------------End of Test---------------------------");
    }

    // 7)  support.url =
    //"https://reqres.in/#support-heading"
    @Test
    public void test007() {
      String supportUrl = response.extract().path("support.url");

        System.out.println("\n------------------StartingTest---------------------------");
        System.out.println("Support URL message is :" + supportUrl);
        System.out.println("------------------End of Test---------------------------");
    }

    // 8) support.txt = "To keep ReqRes free, contributions
    //towards server costs are appreciated!
    @Test
    public void test008() {
     String supportText = response.extract().path("support.text");

        System.out.println("\n------------------StartingTest---------------------------");
        System.out.println("Verifying support message : " + supportText);
        System.out.println("------------------End of Test---------------------------");
    }


}
