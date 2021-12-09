package demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DemoQaPageObjects {
    @FindBy(id="firstName")
    WebElement firstName;
    @FindBy(id="lastName")
    WebElement lastName;
    @FindBy(how= How.ID,using = "userEmail")
    WebElement email;
    @FindBy(xpath="//label[contains(text(),'Male')]")
    WebElement gender;
    DemoQaPageObjects(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    void firstName(String name){
      firstName.sendKeys(name);
    }
    void lastname(String name){
        firstName.sendKeys(name);
    }
    void email(String mail){
        email.sendKeys(mail);
    }
    void gender(){
        gender.click();
    }

}
