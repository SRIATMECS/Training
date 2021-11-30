package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class GooglePage {
    WebDriver driver;
    @FindBy(how=How.XPATH,using ="/html/body/div[1]/div[4]/div/div/a[1]")
    WebElement hindiLink;
    @FindBy(xpath="/html/body/div[1]/div[4]/div/div/a[1]")
            WebElement englishLink;
    WebElement button;
    GooglePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    void clickHindi(){
        hindiLink.click();
    }
    void clickEnglish(){
        englishLink.click();
    }

}
