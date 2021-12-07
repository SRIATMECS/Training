package webtable;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
public class CopyContentsOfWebTableToExcel {
    WebDriver driver;
    FileOutputStream fileOutputStream=new FileOutputStream("D:\\Training\\TestResultFolder\\Webtable.xls");
    WritableWorkbook writableWorkbook=Workbook.createWorkbook(fileOutputStream);
    WritableSheet writableSheet=writableWorkbook.createSheet("Sheet1",1);
    public CopyContentsOfWebTableToExcel() throws IOException {
    }
    @Test
    void validateWebTable() throws WriteException, IOException {
        List<WebElement> rows=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
        List<WebElement> columns=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
        for (int i=1;i<=columns.size();i++){
            for (int j=1;j<=rows.size();j++){
                try {
                    Label tr=new Label(i,j,driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+j+"]/td["+i+"]")).getText());
                    writableSheet.addCell(tr);
                }
                catch (Exception exception){
                    Label th=new Label(i,j,driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+j+"]/th["+i+"]")).getText());
                    writableSheet.addCell(th);
                }
            }
        }
        writableWorkbook.write();
        writableWorkbook.close();
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
