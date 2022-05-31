package in.reqres.reqresusersInfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetUsersTest extends TestBase {

    @Test
    public void getAllUsersInfo() {
        Response response = given()
                .queryParam("page",2)
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getSingleUserInfo(){
        Response response = given()
                .pathParam("id",2)
                .when()
                .get("/users/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getUserNotFound(){
        Response response = given()
                .pathParam("id",23)
                .when()
                .get("/users/{id}");
        System.out.println("user does not exist");
        response.then().statusCode(404);
        response.prettyPrint();

    }

}
