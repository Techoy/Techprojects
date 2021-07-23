package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyWebElements {
    WebDriver driver = Driver.getDriver();

    public MyWebElements() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@class='ab-item'])[1]")
    public WebElement homepage;

    @FindBy(xpath = "(//div[@class='wp-menu-name'])[2]")
    public WebElement posts;

    @FindBy(linkText = "Add New")
    public WebElement addNew;

    @FindBy(xpath = "//textarea[@id='post-title-0']")
    public WebElement titleBox;

    @FindBy(xpath = "//div[@data-type='core/paragraph']")
    public WebElement contentBox;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='user_pass']")
    public WebElement password;

    @FindBy(xpath ="(//button[@type='button'])[8]")
    public WebElement publishButton;

    @FindBy(xpath = "(//button[@type='button'])[21]")
    public WebElement publish;

    @FindBy(xpath="//td[@data-colname='Title']")
    public List<WebElement> publishedUIPosts;
}

