package API;
import API.POJO.Posts;
import API.POJO.Reqres;
import Utilities.Driver;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;



public class ResAssured_Practice {

    @Test
    public void test1(){
        given().get("https://reqres.in/api/users/2").then().statusCode(200);
    }

    @Test
    public void test13() {
        Response response = given().relaxedHTTPSValidation().auth().preemptive().basic("asiyat", "asiyat")
                .pathParam("id", 29)
                .get("http://www.example.dev.cc/wp-json/wp/v2/posts/{id}");

        int id = response.jsonPath().getInt("id");
        System.out.println("id is equals to " + id);
        String expected = response.jsonPath().getString("title.rendered");
        System.out.println("Title is equals to " + expected);
        Driver.getDriver().get("http://www.techtorialacademy.dev.cc/");
        Driver.getDriver().manage().window().maximize();

        String actual = Driver.getDriver().findElement(By.linkText("New Post from REST Assured")).getText();

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void test3() {
        Response response = given().relaxedHTTPSValidation().auth().preemptive().basic("admin", "admin")
                .pathParam("id", "20")
                .get("http://www.techtorialacademy.dev.cc/wp-json/wp/v2/posts/{id}");

        String  expected = response.jsonPath().getString("content.rendered").replace("<p>","").replace("</p>","").trim();
        Driver.getDriver().get("http://www.techtorialacademy.dev.cc/");
        Driver.getDriver().manage().window().maximize();

        String actual = Driver.getDriver().findElement(By.xpath("(//div[@class='entry-content'])[1]")).getText();

        Assert.assertEquals(expected, actual);


    }
    @Test
            public void test4() {
        Response response = given().relaxedHTTPSValidation().auth().preemptive().basic("admin", "admin")
                .get("http://www.techtorialacademy.dev.cc/wp-json/wp/v2/posts");
        List<String> expectedPost = response.jsonPath().getList("title.rendered", String.class);

        Driver.getDriver().get("http://www.techtorialacademy.dev.cc/");
        List<WebElement> actualPosts=Driver.getDriver().findElements(By.xpath("//h2[@class='entry-title']"));

        List<String> actualPosts1=new ArrayList<String>();

        for(WebElement element: actualPosts){
            actualPosts1.add(element.getText());

        }

        Assert.assertEquals(expectedPost,actualPosts1);


    }
    @Test
    public void Test5(){
        given().body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}").post("https://reqres.in/api/users").then().statusCode(201);

    }

    @Test
    public void test6(){
        Reqres obj=new Reqres("morpheus", "leader");
        given()
                .body(obj)
                .post("https://reqres.in/api/users")
                .then().statusCode(201);

    }

    @Test
    public void test7(){
        Posts obj=new Posts("Eliza", "Special", "publish");
        given().relaxedHTTPSValidation().auth().preemptive().basic("admin", "admin").contentType(ContentType.JSON)
                .body(obj).post("http://www.techtorialacademy.dev.cc/wp-json/wp/v2/posts").then().statusCode(201).statusCode(HttpStatus.SC_CREATED);// check the name of the status code

    }
    @Test
    public void test8(){
        Response response=given().relaxedHTTPSValidation().auth().preemptive().basic("admin", "admin")
                .get("http://www.techtorialacademy.dev.cc/wp-json/wp/v2/posts");

        JsonPath jsonPath=response.jsonPath();

        Map<String, String> links=jsonPath.getMap("_links.self[0]",String.class, String.class);

        System.out.println(links.keySet());
        System.out.println(links.values());


    }

}
