package PageObjectModel;

import Drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaseStudyPage extends AbstractClass {
    private WebDriver driver;

    public CaseStudyPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);

    }




    @FindBy(xpath = "//div[3]//div[1]//div[2]//*[name()='svg']")
    private WebElement alerts_window;

    public void clickAlertWindow(){
        clickFunction(alerts_window);


    }

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alert;

    public void clickAlert(){
        clickFunction(alert);
    }

    @FindBy(css = "#alertButton")
    private WebElement firstAlert;
    public void clickFirst(){
        clickFunction(firstAlert);
    }

    @FindBy(css = "#timerAlertButton")
    private WebElement secondAlert;

    public void clickSecond(){
        clickFunction(secondAlert);
    }

    @FindBy(css = "#confirmButton")
    private WebElement thirdAlert;

    public void clickThird(){
        clickFunction(thirdAlert);
    }

    @FindBy(css = "#promtButton")
    private WebElement forthAlert;

    public void clickForth(){
        clickFunction((forthAlert));
    }

    @FindBy(xpath = "//*[name()='path' and contains(@d,'M880 112H1')]")
    private WebElement interactions;

    public void clickInteractions(){
        clickFunction(interactions);
    }

    @FindBy(xpath = "//span[text()='Droppable']")
    private WebElement droppable;
    public void clickDroppable(){

        clickFunction(droppable);
    }

    @FindBy(xpath = "//div[4]//div[1]//div[2]//*[name()='svg']")
    private WebElement widgets;

    public void clickWidgets(){
        clickFunction(widgets);
    }

    @FindBy(xpath = "//span[normalize-space()='Tool Tips']")
    private WebElement toolTips;

    public void clickToolTips(){
        clickFunction(toolTips);
    }

    //====================Login functionality=========================\\

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameBox;

    public void setUsername(String username1){
        sendKeysFunction(usernameBox,username1);
    }
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordBox;

    public void setPassword(String password1){
        sendKeysFunction(passwordBox,password1);

    }
    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement login;

    public  void clickLogin(){
        clickFunction(login);
    }






}
