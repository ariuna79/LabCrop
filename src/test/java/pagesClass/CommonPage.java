package pagesClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Driver;

public class CommonPage {

    public CommonPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath="//*[@id=\"login-container\"]/ul/li[2]/a")

    public WebElement CareersTab;
}
