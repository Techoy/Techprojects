package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebOrderAllOrder {
    WebDriver driver= Driver.getDriver();

    public WebOrderAllOrder(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id=\"ctl00_menu\"]/li[1]/a")
    public WebElement viewAllOrders;


    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[1]")
    public List<WebElement> name;

    @FindBy(xpath="//table[@class='SampleTable']//tr//td[2]")
    public List<WebElement> listOfCustName;
}
