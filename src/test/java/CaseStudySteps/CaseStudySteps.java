package CaseStudySteps;

import Drivers.Driver;
import PageObjectModel.CaseStudyPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.time.Duration;

public class CaseStudySteps {
    CaseStudyPage caseStudyPage=new CaseStudyPage();
    private WebDriver driver;
    @Given("Navigate to Website")
    public void navigateToWebsite() {
        driver= Driver.getDriver();

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



    }

    @And("click Alerts and Frame windows")
    public void clickAlertsAndFrameWindows() {
        caseStudyPage.scrollDown();

        caseStudyPage.clickAlertWindow();
    }

    @And("click alerts")
    public void clickAlerts() {
        caseStudyPage.clickAlert();

    }


    @And("click first alert and verify")
    public void clickFirstAlertAndVerify() {
        caseStudyPage.clickFirst();
        Assert.assertEquals("You clicked a button",driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    }

    @And("verify second alert  will appear in five seconds")
    public void verifySecondAlertWillAppearInFiveSeconds() throws InterruptedException {
        caseStudyPage.clickSecond();
        Thread.sleep(5000);
        Assert.assertEquals("This alert appeared after 5 seconds",driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @And("click the third and confirm box will appear")
    public void clickTheThirdAndConfirmBoxWillAppear() {
        caseStudyPage.clickThird();
        driver.switchTo().alert().accept();
        WebElement box=driver.findElement(By.cssSelector("#confirmResult"));
        Assert.assertTrue(box.isDisplayed());
    }


    @And("click the forth and verify the prompt box will appear")
    public void clickTheForthAndVerifyThePromptBoxWillAppear() {
        caseStudyPage.clickForth();
        driver.switchTo().alert().sendKeys("I feel dead on my feet");
        driver.switchTo().alert().accept();
        WebElement promptBox=driver.findElement(By.cssSelector("#promptResult"));
        Assert.assertTrue(promptBox.isDisplayed());
        System.out.println(promptBox.getText());
    }

    @And("click interactions")
    public void clickInteractions() {
        caseStudyPage.scrollDown();
        caseStudyPage.clickInteractions();


    }
    @And("click droppable menu")
    public void clickDroppableMenu() {
        caseStudyPage.scrollDown();
        caseStudyPage.clickDroppable();
    }



    @And("verify the item is draged and droped")
    public void verifyTheItemIsDragedAndDroped() {
        WebElement drag= driver.findElement(By.cssSelector("#draggable"));
        WebElement drop= driver.findElement(By.xpath("//div[@id='simpleDropContainer']//p[contains(text(),'Drop here')]"));
        caseStudyPage.dragAndDrop(drag,drop);
    }

    @After
    public void quit(){
        Driver.closeDriver();
    }


    @And("click widgets")
    public void clickWidgets() {
        caseStudyPage.scrollDown();
        caseStudyPage.clickWidgets();


    }

    @And("click tool tips and verify the messages")
    public void clickToolTipsAndVerifyTheMessages() throws InterruptedException {
        caseStudyPage.scrollDown();
        caseStudyPage.clickToolTips();
        Actions actions=new Actions(driver);
        WebElement button=driver.findElement(By.xpath("//button[@id='toolTipButton']"));
        WebElement textField= driver.findElement(By.xpath("//input[@id='toolTipTextField']"));
        Thread.sleep(2000);
        actions.moveToElement(button).perform();
        Thread.sleep(2000);
        actions.moveToElement(textField).perform();
        Thread.sleep(2000);

    }

    //=========================Login Functionality=============================\\

    @Given("navigate to the website")
    public void navigateToTheWebsite() {
        driver= Driver.getDriver();

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }


    @And("enter your username<{string}>")
    public void enterYourUsername(String username) {
        caseStudyPage.setUsername(username);
    }

    @And("enter the wrong password<{string}>")
    public void enterTheWrongPassword(String password) {
        caseStudyPage.setPassword(password);

    }
    @And("click login button")
    public void clickLoginButton() {
       caseStudyPage.clickLogin();
    }

    @Then("verify the error message")
    public void verifyTheErrorMessage() {
        WebElement errorMessage= driver.findElement(By.xpath("//h3[@data-test='error']"));

       String actual=errorMessage.getText();

       String expected="Epic sadface: Username and password do not match any user in this service";
       String expected1="Epic sadface: Username is required";
       String expected2="Epic sadface: Password is required";

       if (actual.equals("Epic sadface: Username is required"))
           caseStudyPage.Assertion(actual,expected1);
       if (actual.equals("Epic sadface: Username and password do not match any user in this service"))
           caseStudyPage.Assertion(actual,expected);
       if (actual.equals("Epic sadface: Password is required"))
           caseStudyPage.Assertion(actual,expected2);



    }


}
