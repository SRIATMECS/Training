package googlePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class ValidateGooglePage {
    WebDriver driver;
    @Test
    void screenShot() throws IOException {
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("D:\\Result Folder\\Screenshot.png"));
    }
    @BeforeTest
    void openURL(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.google.com");
    }
    @AfterTest
    void closePage(){
        driver.close();
    }
}
