package StepDefs;

import Pages.MyApp;
import Utilities.Configuration;
import Utilities.DBType;
import Utilities.DBUtils;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.image.DataBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAppication {
    MyApp myApp=new MyApp();
    WebDriver driver= Driver.getDriver();
    List<Map<String, Object>> UIListOfMaps;

    @Given("^User navigates to My Application homepage$")
    public void user_navigates_to_My_Application_homepage() throws Throwable {
        driver.get(Configuration.getProperty("MyApplicationUrl"));
    }

    @Given("^User gets the data from UI table$")
    public void user_gets_the_data_from_UI_table() throws Throwable {
        List<Map<String, Object>> UIListOfMaps=new ArrayList<Map<String, Object>>();
        Map<String, Object>UIMap=new HashMap<String, Object>();
        for(int i=0; i<myApp.columnNames.size();i++){
            UIMap.put(myApp.columnNames.get(i).getText(),myApp.FirstRowData.get(i).getText());
        }
        UIListOfMaps.add(UIMap);
        UIMap.clear();
        for(int i=0; i<myApp.columnNames.size();i++){
            UIMap.put(myApp.columnNames.get(i).getText(),myApp.SecondRowData.get(i).getText());
        }
        UIListOfMaps.add(UIMap);
        UIMap.clear();

        for(int i=0; i<myApp.columnNames.size();i++){
            UIMap.put(myApp.columnNames.get(i).getText(),myApp.ThirdRowData.get(i).getText());
        }
        UIListOfMaps.add(UIMap);
        UIMap.clear();

        for(int i=0; i<myApp.columnNames.size();i++){
            UIMap.put(myApp.columnNames.get(i).getText(),myApp.FourthRowData.get(i).getText());
        }
        UIListOfMaps.add(UIMap);
        System.out.println(UIListOfMaps.size());



    }

    @Then("^Verify data is matched with DB$")
    public void verify_data_is_matched_with_DB() throws Throwable {

        DBUtils.establishConnnection(DBType.Oracle);
        for (int i = 0; i < UIListOfMaps.size(); i++) {
            String query = "select first_name, employee_id, job_id \n" +
                    "from employees e join jobs j\n" +
                    "using (job_id)\n" +
                    "where employee_id="+UIListOfMaps.get(i).get("Employee ID");
            DBUtils.runSQLquely(query);
            List<Map<String, Object>> DBListOfMaps=DBUtils.runSQLquely(query);

            for(int i2=0; i2<DBListOfMaps.get(i).size();i2++){
                Assert.assertEquals(DBListOfMaps.get(0).get(DBUtils.getcolumnNames().get(i)),UIListOfMaps.get(i).get(myApp.columnNames.get(i2).getText()));
            }
        }
    }

}
