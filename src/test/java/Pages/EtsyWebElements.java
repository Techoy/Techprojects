package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EtsyWebElements {
    WebDriver driver;
    public EtsyWebElements() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
        @FindBy(id = "catnav-primary-link-10855")
        public WebElement jewelerySection;

        @FindBy(id = "catnav-primary-link-10923")
        public WebElement clothingSection;

        @FindBy(id = "catnav-primary-link-891")
        public WebElement homeSection;

        @FindBy(id = "catnav-primary-link-10983")
        public WebElement weddingSection;

        @FindBy(id = "catnav-primary-link-11049")
        public WebElement toysSection;

        @FindBy(xpath="//input[@id='global-enhancements-search-query']")
    public WebElement searchBox;


    public static class task {

        public static void fibanocciPrint(int n){
            int a=0;
            int b=0;
            int c=1;

            for(int i=0; i>n; i++){
                a=b;
                b=c;
                c=a+b;


            }
            System.out.println(a);
        }
    }
}



