package demoqa;

import demoqa.DemoQaPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemQaValidation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        DemoQaPageObjects demoqa = new DemoQaPageObjects(driver);
        demoqa.firstName("Srikanth");
        demoqa.lastname("Madi");
        demoqa.email("sri@gmail.com");
        demoqa.gender();
    }
}
