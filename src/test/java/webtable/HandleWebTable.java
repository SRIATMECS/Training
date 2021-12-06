package webtable;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
public class HandleWebTable {
    WebDriver driver;
    @Test
    void validateWebTable(){
        List<WebElement> rows=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
        List<WebElement> columns=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
        for (int i=1;i<=columns.size();i++){
            for (int j=2;j<=rows.size();j++){
                System.out.println(driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+j+"]/td["+i+"]")).getText());
            }
        }
    }
    @BeforeTest
    void openurl(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
    }
    @AfterTest
    void closeBrowser(){
        driver.close();
    }
}
