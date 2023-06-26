package utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

public class BrowserUtils {

    public static String getText(WebElement element){
        return element.getText().trim();
    }

    public static void selectBy(WebElement location, String value, String methodName){
        Select select=new Select(location);

        switch(methodName){
            case"text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case"index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Your value method name is not correct.");
                Assert.assertTrue(false);
        }
    }

    public static String getTitleWithJS(WebDriver driver){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString().trim();

    }

    public static void clickWithJS(WebDriver driver,WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }
    public static void scrollWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void switchByID(WebDriver driver){
        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesId = driver.getWindowHandles();

        for (String ids: allPagesId){
            if(!ids.equals(mainPageId)){
                driver.switchTo().window(ids);
            }
        }
    }

    public static void switchByTitle(WebDriver driver, String title){
        Set<String> allPagesID=driver.getWindowHandles();
        for(String id:allPagesID){
            driver.switchTo().window(id);
            if(driver.getTitle().contains(title)){
                break;
            }
        }
    }

    public static void getScreenShot(WebDriver driver, String packageName){
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location=System.getProperty("st/test/java/"+packageName+"/");
        try {
            FileUtils.copyFile(file, new File(location+System.currentTimeMillis()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getScreenShotForCucumber(WebDriver driver, Scenario scenario){
        Date currentDate=new Date();
        String screenShotFileName=currentDate.toString().replace(" ", "-").replace(":", "-");
        if(scenario.isFailed()){
            File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShotFile, new File("src/test/java/screenshot/"+ screenShotFileName+".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }


}



