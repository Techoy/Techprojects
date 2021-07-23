package API;

import API.POJO.Posts;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeserializationAdvanced {
    @Before
    public void setUp(){
        baseURI="http://www.techtorialacademy.dev.cc";
        basePath="/wp-json/wp/v2/";
    }

    @Test
    public void test01() throws IOException {
        RequestSpecification requestSpecification= given().relaxedHTTPSValidation().auth().preemptive().basic("admin", "admin").contentType(ContentType.JSON);
        Response response=requestSpecification.when().get("posts/20");

//        ObjectMapper objectMapper=new ObjectMapper();
//        List<Map<String, Object>> listOfMaps=objectMapper.readValue(response.asByteArray(), new TypeReference
//           <List<Map<String,Object>>>(){});
//
//        System.out.println(listOfMaps.get(0).get("title"));

        ObjectMapper objectMapper=new ObjectMapper();
        Map<String, Object> Maps=objectMapper.readValue(response.asByteArray(), new TypeReference
                <Map<String,Object>>(){});

        System.out.println(Maps.get("title"));




    }
    @Test
    public void test02() throws IOException {
        RequestSpecification requestSpecification= given().relaxedHTTPSValidation().auth().preemptive().basic("admin", "admin").contentType(ContentType.JSON);
        Response response=requestSpecification.when().get("posts/7");

//        ObjectMapper objectMapper=new ObjectMapper();
//        List<Map<String, Object>> listOfMaps=objectMapper.readValue(response.asByteArray(), new TypeReference
//           <List<Map<String,Object>>>(){});
//
//        System.out.println(listOfMaps.get(0).get("title"));

        ObjectMapper objectMapper=new ObjectMapper();
        Map<String, Object> Maps=objectMapper.readValue(response.asByteArray(), new TypeReference
                <Map<String,Object>>(){});

        System.out.println(Maps.get("title"));
        System.out.println(Maps.get("content"));
        Assert.assertEquals(Maps.get("id").toString(),"7");




    }
    @Test
    public void test4() throws IOException{
        Posts posts=new Posts("This is me from Rest Assured", "This is Eliza", "publish");
        RequestSpecification requestSpecification=given().relaxedHTTPSValidation().auth().preemptive().basic("admin", "admin").contentType(ContentType.JSON);
        Response response=requestSpecification.body(posts).post("posts");
        ObjectMapper objectMapper=new ObjectMapper();
        Map<String, Object> map=objectMapper.readValue(response.asByteArray(), new TypeReference<Map<String, Object>>(){});

        response.then().statusCode(201);
        Assert.assertEquals(((Map<String, String>)map.get("title")).get("rendered").replace("</p>","").replace("<p/>", ""), posts.getTitle());
        Assert.assertEquals(((Map<String, String>)map.get("content")).get("rendered"), posts.getContent());
        //Assert.assertEquals(map.get("id"));


    }
    @Test
    public void test5() throws IOException{
        Posts posts=new Posts("I believe in magic", "I love Elkhan", "draft");
        posts.setStatus("publish");
        RequestSpecification requestSpecification=given().relaxedHTTPSValidation().auth().preemptive().basic("admin", "admin").contentType(ContentType.JSON);
        Response response=requestSpecification.body(posts).post("posts");
        Response response1=requestSpecification.post("posts/48");
        ObjectMapper objectMapper=new ObjectMapper();
        Map<String, Object> map=objectMapper.readValue(response.asByteArray(), new TypeReference<Map<String, Object>>(){});

        response.then().statusCode(201);
        response.then().body("status", equalTo(posts.getStatus()));
//        Assert.assertEquals(((Map<String, String>)map.get("title")).get("rendered").replace("</p>","").replace("<p/>", ""), posts.getTitle());
//        Assert.assertEquals(((Map<String, String>)map.get("content")).get("rendered"), posts.getContent());
        //Assert.assertEquals(map.get("id"));


    }
}
