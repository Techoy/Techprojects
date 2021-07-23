package API;

import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

public class REST_ASSUERED {

    @Before
    public void setUp(){
        baseURI="http://www.techtorialacademy.dev.cc";
        basePath="/wp-json/wp/v2/";
    }


    @Test
    public void test1(){
        when().
                get("https://reqres.in/api/users/2").
                then().log().all().
                statusCode(200);
    }

    @Test
    public void test2(){
        when().
                get("https://reqres.in/api/users/100").
                then().log().all().
                statusCode(404);
    }

    @Test
    public void test3() {
        given().relaxedHTTPSValidation().

                get("https://www.breakingbadapi.com/api/characters").
                then().log().all().
                statusCode(200)
                .body("[0].char_id", equalTo(1));

    }

    @Test
    public void test4() {
        given().relaxedHTTPSValidation().

                get("https://www.breakingbadapi.com/api/characters/10").
                then().log().all().
                statusCode(200)
                .body("status", equalTo("Deceased"))
        .body("birthday", equalTo("Unknown"));

            }

            // Post  with body

    @Test
    public void test5(){
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("admin", "admin")
                .contentType(ContentType.JSON)
                .body("{\n" +// relaxedHTTPSVAlidation
                "\"title\": \"New Post from REST Assured\",\n" +
                "\"content\":\"Elia\",\n" +
                "\"status\": \"publish\"\n" +
                "}")
                .post("http://www.techtorialacademy.dev.cc/wp-json/wp/v2/posts")
                .then()
                .statusCode(201).body("status", equalTo("publish")).body("title.raw", equalTo("New Post from REST Assured"));


    }
    @Test
    public void test6() {
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("admin", "admin")
                .contentType(ContentType.JSON)
                .body("{\n" +// relaxedHTTPSVAlidation
                        "\"title\": \"Update Post from REST Assured\",\n" +
                        "\"content\":\"Elia\",\n" +
                        "\"status\": \"publish\"\n" +
                        "}").pathParam("id",1)
                .put("http://www.techtorialacademy.dev.cc/wp-json/wp/v2/posts/{id}")
                .then()
                .statusCode(201).body("status", equalTo("publish")).body("title.raw", equalTo("New Post from REST Assured"));

    }
    @Test
    public void test7(){
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("admin", "admin")
                .contentType(ContentType.JSON)
                .body("{\n" +// relaxedHTTPSVAlidation
                        "\"title\": \"Rest_Assured LIBRARY\",\n" +
                        "\"content\":\"Elia\",\n" +
                        "\"status\": \"publish\"\n" +
                        "}")
                .post("posts")
                .then()
                .statusCode(201).body("status", equalTo("publish")).body("title.raw", equalTo("Rest_Assured LIBRARY"));


    }
    @Test
    public void test8() {
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("admin", "admin")
                .contentType(ContentType.JSON)
                .body("{\n" +// relaxedHTTPSVAlidation
                        "\"title\": \"Update Practice REST Assured\",\n" +
                        "\"content\":\"Elia\",\n" +
                        "\"status\": \"publish\"\n" +
                        "}").pathParam("id",1)
                .put("posts/{id}")
                .then()
                .statusCode(200).body("status", equalTo("publish")).body("title.raw", equalTo("Update Practice REST Assured"));

    }
    @Test
    public void test9(){
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("admin","admin")
                .pathParam("id",1)
                .queryParam("force", true)
                .delete("http://www.techtorialacademy.dev.cc/wp-json/wp/v2/posts/{id}")
                .then()
                .statusCode(200)
                .body("deleted", is(true));

    }
    @Test
    public void test10(){
        given().relaxedHTTPSValidation()
                .auth().preemptive().basic("admin","admin")
                .pathParam("id",18)
                .queryParam("force", true)
                .delete("posts/{id}")
                .then()
                .statusCode(200)
                .body("deleted", is(true));

    }

    }
