package pageObjectModel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidateGoogle {
    WebDriver driver;
    @BeforeTest
    void openURL(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    void verifyGoogle(){
        GooglePage googlePage=new GooglePage(driver);
        driver.get("http://www.google.com");
        googlePage.clickHindi();
        googlePage.clickEnglish();
    }
    @AfterTest
    void closeBrowser(){
        driver.close();
    }
}
