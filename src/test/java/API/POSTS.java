package API;

import API.POJO.Posts;
import Utilities.Driver;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.basePath;
import static org.hamcrest.Matchers.equalTo;

public class POSTS {
    @Before
    public void setUp(){
        baseURI="http://www.techtorialacademy.dev.cc";
        basePath="/wp-json/wp/v2/";
    }

    @Test
    public void test() {

        RequestSpecification requestSpecification = given().relaxedHTTPSValidation().auth().preemptive().basic("admin", "admin");
        Response response = requestSpecification.post("http://www.techtorialacademy.dev.cc/wp-json/wp/v2/posts");
    }

    @Test
    public void test2() {
        RequestSpecification requestSpecification = given().relaxedHTTPSValidation()
                .auth().preemptive().basic("admin", "admin").contentType(ContentType.JSON);
        Response response = requestSpecification.body("{\n" +// relaxedHTTPSVAlidation
                "\"title\": \"Rest_Assured LIBRARY\",\n" +
                "\"content\":\"Elia\",\n" +
                "\"status\": \"publish\"\n" +
                "}")
                .post("posts");
        response.then()
                .statusCode(201).body("status", equalTo("publish")).body("title.raw", equalTo("Rest_Assured LIBRARY"));

    }
@Test
    public void test3() {
        Posts obj=new Posts("This is title with POJO", "This is Eliza", "draft");

        RequestSpecification requestSpecification = given().relaxedHTTPSValidation()
                .auth().preemptive().basic("admin", "admin").contentType(ContentType.JSON);
        Response response = requestSpecification.body(obj)
                .post("posts");
        response.then().statusCode(201).body("status", equalTo(obj.getStatus()));
        response.then().body("title.raw", equalTo(obj.getTitle()));
        response.then().body("content.rendered", equalTo(obj.getContent()));

    }

}
