package io;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class DriverScriptWithTestResults {
    WebDriver driver;
    @Test
    void ds() throws IOException, BiffException, WriteException {
        FileInputStream fileInputStream = new FileInputStream("D:\\Training\\InputData\\demoqaTestData.xls");
        Workbook workbook = Workbook.getWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(0);
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Training\\TestResultFolder\\demoqaResults.xls");
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(fileOutputStream);
        WritableSheet writableSheet = writableWorkbook.createSheet("Sheet1", 1);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
            for (int i = 1; i < sheet.getRows(); i++) {
                try {
                    switch (sheet.getCell(1, i).getContents()) {
                        case "textbox":
                            driver.findElement(By.xpath(sheet.getCell(2, i).getContents())).sendKeys(sheet.getCell(3, i).getContents());
                            break;
                        case "button":
                        case "link":
                        case "radiobutton":
                        case "box":
                        case "checkbox":
                            driver.findElement(By.xpath(sheet.getCell(2, i).getContents())).click();
                            break;
                        case "dropdown":
                            new Select(driver.findElement(By.xpath(sheet.getCell(2, i).getContents()))).selectByVisibleText(sheet.getCell(3, i).getContents());
                            break;
                        case "pagedown":
                            Actions actions = new Actions(driver);
                            actions.sendKeys(Keys.PAGE_DOWN).perform();
                            break;
                    }
                    Label passresults = new Label(4, i, "Pass");
                    writableSheet.addCell(passresults);
                } catch (Exception exception) {
                    exception.printStackTrace();
                    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(screenshot, new File("D:\\Training\\FailedTestScriptScreenshot\\" + sheet.getCell(0, i).getContents() + ".png"));
                    Label failresults = new Label(4, i, "Fail");
                    writableSheet.addCell(failresults);
                }
            }
        for (int j = 0; j < sheet.getColumns(); j++) {
            for (int i = 0; i < sheet.getRows(); i++) {
                Label objectrepository = new Label(j,i,sheet.getCell(j,i).getContents());
                Label resultLabel = new Label(4,0,"Result");
                writableSheet.addCell(objectrepository);
                writableSheet.addCell(resultLabel);
            }
        }
        writableWorkbook.write();
        writableWorkbook.close();
    }
    @AfterTest
    void closeBrowser(){
        driver.quit();
    }
}
