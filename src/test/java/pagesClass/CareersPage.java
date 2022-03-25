package pagesClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Driver;

public class CareersPage {
    public CareersPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text'][@id='typehead'][@au-target-id='161']")

    public WebElement SearchField;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[2]/section[2]/div/div/div/div[2]/div[2]/ul/li[1]/div[1]/span/a/div/span")

    public WebElement TextMassage;

    @FindBy(xpath = "(//p[@style='margin-bottom: 6.0pt;text-align: justify;'])[1][text()[2]]")

    public WebElement Description1stSentense;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/div/div/div[1]/section[1]/div/div/div[2]/div[2]/div[1]/ul/li[2]")

    public WebElement responsibilities2rdBullet;

    @FindBy(xpath = "//li[@style='text-align: justify;'][text()='5-7 years hands-on test automation or development experience.']")

    public WebElement requirements;

    @FindBy(xpath="/html/body/div[2]/div[2]/div/div[1]/div[2]/section/div/div/div/div[2]/div/a/ppc-content")

    public WebElement ApplyButton;

    @FindBy(xpath="//*[@id=\"srccar\"]/adprm-sign-in-popover/div/div[3]/div[2]/div/div[2]/div[1]/div[1]/form/ul/li[3]")

    public WebElement PopBox;

    @FindBy(xpath="//*[@id=\"ae-main-content\"]/div/div/div[1]/button")

    public WebElement ReturnToJobSerchButton;

    @FindBy(xpath ="//span[@class='jobTitle job-detail-title'][text()='Test Automation Engineer/Jr. Software Developer']")

    public WebElement JobTitle;
    
}
