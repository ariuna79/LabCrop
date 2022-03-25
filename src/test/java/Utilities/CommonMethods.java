package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends PageInitializer{

	/**
	 * 
	 * method that clears and sends keys
	 * 
	 * @param element
	 * @param text
	 * 
	 * 
	 *                Created by Shafkat Ali Dec 7th, 2021
	 **/
	public static void sendText(WebElement element, String text) {

		element.clear();
		element.sendKeys(text);

	}

	/**
	 * 
	 * Method checks if radio/checkbox is enabled and clicks it
	 * 
	 * @param radioOrCheckbox
	 * @param value
	 * 
	 * 
	 *                        Created by Shafkat Ali Dec 7th, 2021
	 **/
	public static void clickRadioOrCheckbox(List<WebElement> radioOrCheckbox, String value) {

		String actualValue;

		for (WebElement el : radioOrCheckbox) {

			actualValue = el.getAttribute("value").trim();

			if (el.isEnabled() && actualValue.equals(value)) {
				el.click();
				break;
			}

		}

	}

	/**
	 * 
	 * Method that selects value by index
	 * 
	 * @param element
	 * @param index   == 3
	 * 
	 * 
	 *                Created by Shafkat Ali Dec 7th, 2021
	 **/
	public static void selectValue(WebElement element, int index) {

		try {
			Select select = new Select(element);
			int size = select.getOptions().size(); // 2

			if (size > index) {
				select.selectByIndex(index);
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Method that accepts alert
	 * 
	 * 
	 * 
	 * Created by Shafkat Ali Dec 7th, 2021
	 **/

	public static void acceptAlert() {
		try {
			Alert alert = Driver.getDriver().switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Method that dismiss alert
	 * 
	 * 
	 * 
	 * Created by Shafkat Ali Dec 7th, 2021
	 **/
	public static void dismissAlert() {
		try {
			Alert alert = Driver.getDriver().switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Method that gets Alert Text
	 * 
	 * 
	 * 
	 * Created by Shafkat Ali Dec 7th, 2021
	 **/
	public static String getAlertText() {

		String alertText = null;

		try {
			Alert alert = Driver.getDriver().switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		return alertText;

	}

	/**
	 * 
	 * Method that sends alert text
	 * 
	 * @param text
	 * 
	 *             Created by Shafkat Ali Dec 7th, 2021
	 **/
	public static void sendAlertText(String text) {
		try {
			Alert alert = Driver.getDriver().switchTo().alert();
			alert.sendKeys(text);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	// iframes
	/**
	 * 
	 * 3 Methods that switchs to iFrame
	 * 
	 * 
	 * 
	 *             Created by Shafkat Ali Dec 7th, 2021
	 **/

	public static void switchToFrameByName(String nameOrId) {

		try {
			Driver.getDriver().switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}
	
	
	public static void switchToFrameByElement(WebElement element) {

		try {
			Driver.getDriver().switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}
	
	
	public static void switchToFrameByIndex(int index) {

		try {
			Driver.getDriver().switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}
	
	
	/**
     * Method switches focus to child window (windowhandles)
     */
    public static void switchToChildWindow() {
    	
        String mainWindow = Driver.getDriver().getWindowHandle();
        Set<String> windows = Driver.getDriver().getWindowHandles();
        for (String window : windows) {
            if (!window.equals(mainWindow)) {
                Driver.getDriver().switchTo().window(window);
                break;
            }
        }  
    }
	
    
    
    //waits
    public static WebDriverWait getWaitObject() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        return wait;
    }

    public static WebElement waitForClickability(WebElement element) {
        return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForVisibility(WebElement element) {
        return getWaitObject().until(ExpectedConditions.visibilityOf(element));
    }

    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }
	
	////////////////////////////////////////////////////////////
    
    public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		return js;
	}

    public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}
    
    public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}
    
    /**
	 * Method that will scroll the page down based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * Method that will scroll the page up based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
	}
    
    
	
	//
	
	
	/**
	 * This Method will take a screenshot
	 * 
	 * @param filename
	 */
	public static byte[] takeScreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

		File file = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = "src/test/resources/screenShots" + filename + getTimeStemp() + ".png";

		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}

		return picBytes;
	}
	
	public static String getTimeStemp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		return sdf.format(date.getTime());
	}
	
	
	
	public static void wait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * this method will select a date from the calendar
	 * 
	 * @param element
	 * @param text
	 */

	public static void selectCalendarDate(List<WebElement> element, String text) {
		for (WebElement pickDate : element) {
			if (pickDate.isEnabled()) {
				if (pickDate.getText().equals(text)) {
					pickDate.click();
					break;
				}
			}
		}
	}
	public static void selectCalendarDate1(List<WebElement> element, String text) {
		for (WebElement pickDate : element) {
			if (pickDate.isEnabled()) {
				if (pickDate.getText().equals(text)) {
					pickDate.click();
					break;
				}
			}
		}
	}
    
}
