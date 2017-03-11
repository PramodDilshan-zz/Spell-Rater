/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.spellrater.attribute.AttributeInTheURL;
import lk.ijse.spellrater.spellcheck.SpellCheck;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Dilshan
 */
public class Test {

    static WebDriver driver;
    static ArrayList<String> allAttributeDetails = new ArrayList<>();
    
    public static void main(String[] args) {
        AttributeInTheURL getTheLink = new AttributeInTheURL();
        SpellCheck spellCheck = new SpellCheck();
        
        int x = 0;
        String driverPath = "D:\\Indrustrial Traning - 2016\\Projects\\SpellRater\\Stage 1\\Jar Files\\chromedriver_win32\\chromedriver.exe";
        String URL = "https://trans4mind.com/personal_development/mathematics/series/airthmeticGeometricSeries.htm";
        String cssSelector = "a";
        String attribute = "href";

        ArrayList<String> attributeDetails = getAttributeDetails(driverPath, URL, cssSelector, attribute);
        
        for (String attributeDetail : attributeDetails) {
            System.out.println(attributeDetail);
        }
        

    }

    public static ArrayList<String> getAttributeDetails(String driverPath, String URL, String cssSelector, String Attribute) {
        List<WebElement> el = new ArrayList<>();
        try {
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();

            driver.get(URL);

            List<WebElement> eltemp = driver.findElements(By.cssSelector(cssSelector));

            for (int i = 0; i < eltemp.size(); i++) {
                if (!eltemp.get(i).equals(null)) {
                    el.add(eltemp.get(i));
                }
            }
            
            for (int i = 0; i < el.size(); i++) {
                
                allAttributeDetails.add(i, el.get(i).getAttribute(Attribute));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return allAttributeDetails;
    }

}
