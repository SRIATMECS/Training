package puma.util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Utility {
    WebDriver driver;
    List<String> lowCostproduct;
    int min;
    public void url(String url){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
    public void searchDropdownHandling(){
            WebDriverWait wait=new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"p-search-dropdown-columns\"]")));
    }
    public void itemList(String locator,String product) {
        driver.findElement(By.xpath(locator)).sendKeys(product);
        try {
            searchDropdownHandling();
            driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
            HashMap<String, Integer> map = new HashMap<>();
            List<WebElement> list = driver.findElements(By.xpath("//div[@class='row product-grid no-gutters']/div"));
            for (int locatorPosition = 1; locatorPosition <= list.size(); locatorPosition++) {
                String item = driver.findElement(By.xpath("//div[@class=\"row product-grid no-gutters\"]/div[" + locatorPosition + "]/div/div/div[1]/div[4]/div[1]/a")).getText();
                if (item.toLowerCase().contains(product.toLowerCase())) {
                String price = driver.findElement(By.xpath("//div[@class=\"row product-grid no-gutters\"]/div[" + locatorPosition + "]/div[1]/div/div/div[4]/div[2]/div[1]")).getText();
                price = price.replaceAll("[₹,]", "");
                int convertedPrice = Integer.parseInt(price);
                map.put(item, convertedPrice);
                }
            }
            List<Integer> prices = new ArrayList<>(map.values());
            prices.sort(Comparator.naturalOrder());
            try {
                min = prices.get(0);
                lowCostproduct = map.entrySet().stream().filter(e -> e.getValue() == min).map(Map.Entry::getKey).collect(Collectors.toList());
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                System.out.println("List & Map is Empty");
            }
            System.out.println(map);
            try {
                System.out.println("Total Num Of " + product + " With Minimum Cost Are: " + lowCostproduct.size());
                System.out.println("Minimum Cost " + product + " are " + lowCostproduct + ": " +min);
            } catch (NullPointerException nullPointerException) {
                System.out.println("No Products Found");
            }
        }catch (TimeoutException timeoutException){

            System.out.println("Search For A Valid Product");
            driver.findElement(By.xpath(locator)).clear();
        }
    }
    public void quitSession(){
        driver.quit();
    }
}
