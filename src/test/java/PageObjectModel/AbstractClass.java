package PageObjectModel;

import Drivers.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public abstract class AbstractClass {
    private WebDriver driver = Driver.getDriver();



    public void clickFunction(WebElement clickElement){

        clickElement.click();
    }

    public void sendKeysFunction(WebElement sendKeysElement, String value){

        sendKeysElement.sendKeys(value);
    }

    public void selectElementFromDropdown(WebElement dropdown,String element){

        Select slc = new Select(dropdown);

        slc.selectByVisibleText(element);

    }


    public void Assertion(WebElement actual,String expected){
        Assert.assertEquals(actual.getText(),expected);
        System.out.println("My Message :  " + actual.getText());

    }
    public void Assertion(String actual,String expected){
        Assert.assertEquals(actual,expected);
        System.out.println("My Message :  " + actual);

    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,270)", "");
    }
    public void dragAndDrop(WebElement drag,WebElement drop){
        Actions actions=new Actions(driver);

        actions.dragAndDrop(drag,drop).build().perform();
    }



}
