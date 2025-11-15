package api;

import com.google.gson.JsonObject;
import io.cucumber.java.hu.Ha;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class apiAutomation {
    @Test
    public void apiGETTest(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=1");
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeader("content-type"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        baseURI = "https://reqres.in/api";
        given().get("users?page=1").then().body("data.first_name",hasItems("George","Janet"));
        given().get("users?page=1").then().body("data.first_name",hasItems("George","Janeet"));
    }

    @Test
    public void apiGETTest1(){
        baseURI= "https://reqres.in/api";
    given().headers("x-api-key","reqres-free-v1").get("/users?page=1").then().statusCode(200).body("data[1].id",equalTo(8)).log().all();
    }

    @Test
    public void apiGETTest2(){
        RestAssured.baseURI= "https://api.reverb.com";
        Map<String, String> map = new HashMap<String, String>();
        map.put("Accept","application/hal+json");
        map.put("Content-Type","application/json");
        map.put("Accept-Version","3.0");

        Response res = RestAssured.given()
                .headers(map)
//                .header("Accept","application/hal+json")
//                .header("Content-Type","application/json")
//                .header("Accept-Version","3.0")
                .get("/api/articles/categories")
                .then()
                .extract().response();
        System.out.println(res.statusCode());
        System.out.println(res.prettyPrint());
    }

    @Test
    public void apiPOSTTest(){

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","Sathish");
        map.put("job","Teacher");

        JSONObject jsonObject = new JSONObject(map);
        jsonObject.put("name","Sathish");
        jsonObject.put("job","Teacher");

        baseURI = "https://reqres.in/api";

        given().headers("Content-Type","application/json").headers("x-api-key","reqres-free-v1").body(jsonObject.toJSONString()).when().post("/users").then().statusCode(201 ).log().all();


    }


}
