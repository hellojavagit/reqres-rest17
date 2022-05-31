package in.reqres.reqresusersInfo;

import in.reqres.model.ReqresPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PutUserTest extends TestBase {

    @Test
    public void createUser()
    {
       ReqresPojo reqresPojo = new ReqresPojo();
        reqresPojo.setName("Hello");
        reqresPojo.setJob("Skills Tester");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(reqresPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
