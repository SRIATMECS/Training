package googlePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class AJAXhandling {
    WebDriver driver;
    @Test
    void ValidateLinks() {
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Dhoni");
        WebElement ajax=driver.findElement(By.xpath("//div[@class='UUbT9']"));
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(ajax));
        String str= ajax.getText();
        String[] strings=str.split("\n");
        for (String string : strings) {
            if (string.equalsIgnoreCase("dhoni wife")) {
                driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).clear();
                driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(string);
            }
        }
    }
    @BeforeTest
    void openURL(){
        WebDriverManager.chromiumdriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
    }
    @AfterTest
    void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
