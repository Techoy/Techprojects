package StepDefs;

import Pages.WebOrderAllOrder;
import Pages.WebOrdersAppPage;
import Pages.WebOrdersLoginPage;
import Pages.WebOrdersOrderPage;
import Utilities.Configuration;
import Utilities.Driver;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class WebOrder {
    WebOrdersLoginPage log=new WebOrdersLoginPage();
    WebOrdersAppPage orderPage= new WebOrdersAppPage();
    WebOrdersOrderPage orderOrder=new WebOrdersOrderPage();
    WebOrderAllOrder viewAllOrders=new WebOrderAllOrder();
    WebDriver driver= Driver.getDriver();
    @Given("^User logs in with credential username \"([^\"]*)\" password \"([^\"]*)\"$")
    public void user_logs_in_with_credential_username_password(String username, String password) throws Throwable {
        driver.get(Configuration.getProperty("WebOrdersUrl"));
        log.username.sendKeys(username);
        log.password.sendKeys(password);
        log.loginButton.click();

    }

    @Then("^User click on Order$")
    public void user_click_on_Order() throws Throwable {


        orderOrder.order.click();
        Thread.sleep(3000);



    }

    @Then("^User create order$")
    public void user_create_order(DataTable dataTable) {
        List<Map<String,Object>> listOfMaps=dataTable.asMaps(String.class,Object.class);
        for(int i=0; i<listOfMaps.size();i++) {
            orderPage.quantity.sendKeys(listOfMaps.get(i).get("Quantity").toString());
            orderPage.customerName.sendKeys(listOfMaps.get(i).get("Customer").toString());
            orderPage.street.sendKeys(listOfMaps.get(i).get("Street").toString());
            orderPage.city.sendKeys(listOfMaps.get(i).get("City").toString());
            orderPage.zip.sendKeys(listOfMaps.get(i).get("Zip").toString());
            orderPage.viza.click();
            orderPage.cardNR.sendKeys(listOfMaps.get(i).get("Card NR").toString());
            orderPage.expirationDate.sendKeys(listOfMaps.get(i).get("Expire Date").toString());
            orderPage.process.submit();
            }


    }
    @Then("^User click on View Orders$")
    public void user_click_on_View_Orders() throws Throwable {
        viewAllOrders.viewAllOrders.click();



    }




    @Then("User verifies that orders are created")
    public void user_verifies_that_orders_are_created(DataTable dataTable) {
        List<Map<String,String>> custName=dataTable.asMaps(String.class,String.class);
        int numOfList=custName.size();
        int numOfMaps=custName.get(0).size();

        int CustomerNumber=0;

        for(int i=0; i<custName.get(0).size();i++){
            String customerName=custName.get(i).get("Customer name");
            for(int y=0; y<viewAllOrders.listOfCustName.size(); y++){
                if(viewAllOrders.listOfCustName.get(y).getText().equals(customerName)){
                    CustomerNumber++;
                }
            }

        }
        Assert.assertEquals(3,CustomerNumber);


    }




}
