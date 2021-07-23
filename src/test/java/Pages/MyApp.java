package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyApp {

    WebDriver driver;

    public MyApp(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//tr[1]//td")
    public List<WebElement> FirstRowData;

    @FindBy(xpath="//tr[2]//td")
    public List<WebElement> SecondRowData;

    @FindBy(xpath="//tr[3]//td")
    public List<WebElement> ThirdRowData;

    @FindBy(xpath="//tr[4]//td")
    public List<WebElement> FourthRowData;

    @FindBy(xpath="//th")
    public List<WebElement> columnNames;



}
