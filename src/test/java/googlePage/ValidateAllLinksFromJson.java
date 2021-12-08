package googlePage;
import com.google.gson.JsonArray;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
public class ValidateAllLinksFromJson {
    WebDriver driver;
    @Test
    void ValidateLinks() throws IOException, ParseException {
        JSONParser jsonParser=new JSONParser();
        FileReader fileReader=new FileReader("D:\\Training\\TestResultFolder\\Links.json");
        Object obj=jsonParser.parse(fileReader);
        JSONObject jsonObject= (JSONObject) obj;
        JSONArray jsonArray= (JSONArray) jsonObject.get("Links");
        for (int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject1= (JSONObject) jsonArray.get(i);
            String url= (String) jsonObject1.get("link"+i+"");
            driver.get(url);
            System.out.println(url);
        }
    }
    @BeforeTest
    void openURL(){
        WebDriverManager.chromiumdriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterTest
    void closeBrowser(){
        driver.quit();
    }
}
