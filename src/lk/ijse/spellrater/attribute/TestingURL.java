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

/**
 *
 * @author Dilshan
 * 
 */

/**
 *
 * @author Dilshan
 * 
 */


// Using Seleinium API

public class TestingURL {

    private static WebDriver driver;
    private static WebElement webElement;
    private static String attribute;
    private static ArrayList<String> allLinks= new ArrayList<>();
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\Indrustrial Traning - 2016\\Projects\\SpellRater\\Stage 1\\Jar Files\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            
//            driver.getWindowHandle();
            driver.get("http://www.w3schools.com/Css/css_pseudo_classes.asp");

            //Web Page Source
//            System.out.println(driver.getPageSource());
//            System.out.println("********************************************");
//            WebElement findElement = driver.findElement(By.cssSelector("p"));
//            System.out.println(findElement);
//            List<WebElement> el = driver.findElements(By.cssSelector("a"));
//            List<WebElement> elHi = driver.findElements(By.tagName("body"));
            String text = driver.findElement(By.tagName("body")).getText();
            String[] split = text.split("\n");
            
            for (int i = 0; i < 10; i++) {
                
            }
            
//            Class<? extends List> aClass = el.getClass();
//            Method method = aClass.getMethod("getAttribute", aClass.getMethods()[4].getParameterTypes()[]);
//            webElement = driver.findElement(By.cssSelector("a"));
//            attribute = webElement.getAttribute("href");
//            for (int i = 0; i < el.size(); i++) {
//                allLinks.add(i,el.get(i).getAttribute("href"));
//                System.out.println(el.get(i).getAttribute("href"));
//            }
//            System.out.println("********************************************");
//            System.out.println("---------------------------------------");
//            getLinks();
//            System.out.println("----------------------------------------");
//            for (int i = 0; i < elHi.size(); i++) {
//                System.out.println(elHi.get(i).getText());
//            }
//            String returnAllText = returnAllText(By.cssSelector("*"));
//            System.out.println(returnAllText);
            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String returnAllText(By element) {
        List<WebElement> all = driver.findElements(element);
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (WebElement elemenet : all) {
            sb.append(i++).append(": ").append(elemenet.getText());
        }
        return sb.toString();
    }
    
    public static void getLinks()throws Exception{
    try {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int linkcount = links.size(); 
         System.out.println(links.size()); 
          for (WebElement myElement : links){
         String link = myElement.getText(); 
         System.out.println(link);
         System.out.println(myElement);   
        if (link !=""){
             myElement.click();
             Thread.sleep(2000);
             System.out.println("third");
            }
            //Thread.sleep(5000);
          } 
        }catch (Exception e){
            System.out.println("error "+e);
        }
    }

}
