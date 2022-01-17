package puma.script;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import puma.util.Utility;
/*
Test Case ID: C001
Test Case Description: Get All Details of the Products whose Price is Minimum.
*/
public class LowestPriceScript {
    Utility reuse= new Utility();
    @BeforeTest
    void setup(){
    reuse.url("https://in.puma.com");
    }
    @Test
    void minimumPriceProduct(){
        reuse.itemList("//input[@type=\"search\"]","Sneakers");
    }
    @AfterTest
    void teardown(){
        reuse.quitSession();
    }
}
