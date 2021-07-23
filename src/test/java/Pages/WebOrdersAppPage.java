package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrdersAppPage {
          WebDriver driver;

        public WebOrdersAppPage() {
            driver = Driver.getDriver();
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")
        public WebElement quantity;

        @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtName']")//input[@id='ctl00_MainContent_fmwOrder_txtName']
        public WebElement customerName;

        @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")
        public WebElement street;

        @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")
        public WebElement city;

        @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")
        public WebElement zip;

        @FindBy(id= "ctl00_MainContent_fmwOrder_cardList_0")//id = "ctl00_MainContent_fmwOrder_cardList_0"
        public WebElement viza;

        @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")//ctl00_MainContent_fmwOrder_TextBox6
        public WebElement cardNR;

        @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")
        public WebElement expirationDate;

        @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")
        public WebElement process;


    }
