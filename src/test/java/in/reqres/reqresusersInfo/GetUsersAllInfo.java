package in.reqres.reqresusersInfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetUsersAllInfo extends TestBase {
    @Test
    public void getUsersDetails() {
        Response response = given()
                .queryParam("page", 2)
                .when()
                .get("/users");
       response.then().statusCode(200);
        System.out.println("StatusCode is Success" );
        response.prettyPrint();
        System.out.println("Verifying Some Of Details Of Users List");

        int page = response.then().extract().path("page");
        System.out.println( "Test 1 : Verifying page : " + page);

        int per_page = response.then().extract().path("per_page");
        System.out.println("\nTest 2 : Verifying per_page : " + per_page);

        int verifyId = response.then().extract().path("data[1].id");
        System.out.println("\nTest 3 : Verifying if id is  8 at record 2  :"+verifyId);

        String firstName = response.then().extract().path("data[3].first_name");
        System.out.println("\nTest 4 :Verifying the FirstName of record 3 : " + firstName);

        List<Integer> listOfData= response.then().extract().path("data");
        System.out.println("\nTest 5 : Size of List data : " + listOfData.size());

        String avatar = response.then().extract().path("data[5].avatar");
        System.out.println("\nTest 6 : avatar at record 6 is : " + avatar);

        String supportUrl = response.then().extract().path("support.url");
        System.out.println("\nTest 7 : Verify support Url mesaage : " + supportUrl);

        String supportText = response.then().extract().path("support.text");
        System.out.println("\nTest 8 : Verify support Text message : " +supportText);


    }
}