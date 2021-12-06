package io;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class DriverScript {
    @Test
    void ds()throws IOException, BiffException {
        FileInputStream fileInputStream=new FileInputStream("D:\\Training\\InputData\\demoqaTestData.xls");
        Workbook workbook=Workbook.getWorkbook(fileInputStream);
        Sheet sheet=workbook.getSheet(0);
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        for (int i=1;i<sheet.getRows();i++){
                try{
                    switch (sheet.getCell(1,i).getContents()) {
                        case "textbox":
                            driver.findElement(By.xpath(sheet.getCell(2,i).getContents())).sendKeys(sheet.getCell(3,i).getContents());
                            break;
                        case "button":
                        case "link":
                        case "radiobutton":
                        case "box":
                        case "checkbox":
                            driver.findElement(By.xpath(sheet.getCell(2,i).getContents())).click();
                            break;
                        case "dropdown":
                            new Select(driver.findElement(By.xpath(sheet.getCell(2,i).getContents()))).selectByVisibleText(sheet.getCell(3,i).getContents());
                            break;
                        case "pagedown":
                            Actions actions=new Actions(driver);
                            actions.sendKeys(Keys.PAGE_DOWN).perform();
                    }
                }
                catch(Exception exception){
                    exception.printStackTrace();
                    File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(screenshot,new File("D:\\Training\\FailedTestScriptScreenshot\\"+sheet.getCell(0,i).getContents()+".png"));

                }
        }
    }
}
