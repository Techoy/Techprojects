package StepDefs;

import API.POJO.Posts;
import Pages.MyWebElements;
import Utilities.DBType;
import Utilities.DBUtils;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class MyWebPage {
    @Before
            public void setUp(){
        baseURI= "http://www.techtorialacademy.dev.cc";
                basePath="/wp-json/wp/v2/";
    }

    MyWebElements object=new MyWebElements();
    @Given("^User navigate to \"([^\"]*)\"$")
public void user_navigate_to(String arg1) throws Throwable {
        Driver.getDriver().get("http://www.techtorialacademy.dev.cc/wp-login.php");
        Driver.getDriver().manage().
                timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        object.username.sendKeys("admin");
        object.password.sendKeys("admin"+ Keys.ENTER);
}

    @Given("^User authorized to make DB calls$")
    public void user_authorized_to_make_DB_calls() throws Throwable {



    }

    @When("^User adds new post$")
    public void user_adds_new_post() throws Throwable {
        object.posts.click();
        object.addNew.click();
        object.titleBox.sendKeys("This is post from Java");
        Thread.sleep(3000);

        object.contentBox.click();
        Thread.sleep(3000);
        object.contentBox.sendKeys("Automated");
        Thread.sleep(2000);
        object.publishButton.click();
        Thread.sleep(2000);
        object.publish.click();

    }

    @Then("^User queries the post from DB$")
    public void user_queries_the_post_from_DB() throws Throwable {
        //DBUtils.establishConnnection(DBType.MySQL);

        //List<Map<String, Object>> publishedPosts=DBUtils.runSQLquely("select * from wp_posts where title_post is 'This is post from Java'");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/techtoriDB44ioz?serverTimezone="+ TimeZone.getDefault().getID(), "techtoriDB44ioz", "Z1V0m8ma8S");


        Statement statement =connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("Select title_posts from wp_posts");
        List<String> titlePosts=new ArrayList<String>();
        for(int i=0; i<resultSet.getRow(); i++){

            titlePosts.add(resultSet.getString(i));
        }

        List<String> publishedPosts=new ArrayList<String>();
        List<WebElement> UIPosts=object.publishedUIPosts;

        for(WebElement element:UIPosts){
           publishedPosts.add(element.getText());
       }
        int count=0;
        for(String str1:titlePosts){
            for(String str2: publishedPosts){
               Assert.assertEquals(str1,str2);

            }

        }
        }

    @When("^User sends post request from API$")
    public void user_sends_post_request() throws Throwable {
        Posts posts=new Posts("This is task after fifnfshing API", "I am doing my tasks", "publish");
        RequestSpecification requestSpecification=given().relaxedHTTPSValidation().auth().preemptive().basic("admin","admin").contentType(ContentType.JSON);
        //Response response=requestSpecification.body("/posts");
    }

//    @Then("^status code is (\\d+)$")
//    public void status_code_is(int arg1) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^User creates post in DB$")
//    public void user_creates_post_in_DB() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^Verify published post in DB  with results queries of DB$")
//    public void verify_published_post_in_DB_with_results_queries_of_DB() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Given("^User logs in DB$")
//    public void user_logs_in_DB() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^Verify published post in DB  with UI posts$")
//    public void verify_published_post_in_DB_with_UI_posts() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Given("^User navigates to UI$")
//    public void user_navigates_to_UI() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^Add new posts in UI$")
//    public void add_new_posts_in_UI() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^Verify UI posts with UI$")
//    public void verify_UI_posts_with_UI() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//

}
