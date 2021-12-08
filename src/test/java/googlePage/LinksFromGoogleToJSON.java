package googlePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class LinksFromGoogleToJSON{
    WebDriver driver;
    @Test
      void weblinks() throws IOException {
        JSONArray jsonArray=new JSONArray();
        List<WebElement> list=driver.findElements(By.tagName("a"));
        System.out.println(list.size());
        for (int i=0;i< list.size();i++){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("link"+i+"",list.get(i).getAttribute("href"));
            jsonArray.add(jsonObject);
        }
        JSONObject jsonObject1=new JSONObject();
        jsonObject1.put("Links",jsonArray);
        FileWriter fileWriter=new FileWriter("D:\\Training\\TestResultFolder\\links.json");
        fileWriter.write(jsonObject1.toString());
        fileWriter.flush();
        fileWriter.close();
    }
    @BeforeTest
    void openurl(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.in");
    }
    @AfterTest
    void closeBrowser(){
        driver.quit();
    }
}
