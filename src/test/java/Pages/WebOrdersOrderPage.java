package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrdersOrderPage {

        WebDriver driver;
        public WebOrdersOrderPage(){
            PageFactory.initElements(Driver.getDriver(),this);
        }
        @FindBy(xpath = "//*[@id=\"ctl00_menu\"]/li[3]/a")
        public WebElement order;
    }

