/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spellrater.attribute;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author Dilshan
 */
public class AttributeInTheURL {

    /*
        Jar File Details
        Reffrence   :   http://www.seleniumhq.org/docs/03_webdriver.jsp
        Location    :   D:\Indrustrial Traning - 2016\Projects\Project SpellRater\SpellRater\Stage 1\Jar Files\selenium-server-standalone-3.0.1.jar
    
        Get The Links
        Driver Path     -       "D:\\Indrustrial Traning - 2016\\Projects\\SpellRater\\Stage 1\\Jar Files\\chromedriver_win32\\chromedriver.exe"
        URL               -       http://ijse.com
        cssCelector     -       a
        Attribute         -       href
        
     */
    private static WebDriver driver;
    private static WebElement webElement;
    private static String attribute;
    private static String content;
    private static ArrayList<String> allAttributeDetails = new ArrayList<>();

    public AttributeInTheURL() {
    }

    public static ArrayList<String> getAttributeDetails(String driverPath, String URL, String cssSelector, String Attribute) {
        try {
            
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            driver.get(URL);

            
            List<WebElement> el = driver.findElements(By.cssSelector(cssSelector));

            for (int i = 0; i < el.size(); i++) {
                allAttributeDetails.add(i, el.get(i).getAttribute(Attribute));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return allAttributeDetails;
    }

    public static List<WebElement> getTheSource(String driverPath, String URL, String cssSelector, String Attribute) {
        List<WebElement> findElements = null;
        try {
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();

            driver.get(URL);

            findElements = driver.findElements(By.tagName("*"));

//            for (WebElement findElement : findElements) {
//                content += (findElement.getText() + " ");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return findElements;
    }

    public static String getContent(String driverPath, String URL, String cssSelector, String Attribute) {

        try {
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();

            driver.get(URL);

            content = driver.getPageSource();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }

    
    public static String getDisplayText(String driverPath, String URL) {

        try {
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            
            driver.get(URL);

            content = driver.findElement(By.tagName("body")).getText();
//            content = content.replace("\n", " ");
//            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }
    
    
        public static String getDisplayTextPanthom(String URL) {

        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setJavascriptEnabled(true);
            cap.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "‪C:/Users/Dilshan/AppData/Local/Temp/phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe");
//            cap.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/panthom/phantomjs.exe");
//            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new PhantomJSDriver();            
            driver.get(URL);

            content = driver.findElement(By.tagName("body")).getText();
//            content = content.replace("\n", " ");
//            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }
    

}
