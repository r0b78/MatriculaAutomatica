/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *
 * @author cp
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       String exePath = "chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver=new ChromeDriver();
//                
//		driver.get("http://toolsqa.wpengine.com/automation-practice-form/");
//                System.out.println(driver.getPageSource());

   		driver.get("http://demoqa.com/frames-and-windows/");
		WebElement elem=driver.findElement(By.xpath(".//*[@id='tabs-1']/div/p/a"));
                System.out.println(elem.isEnabled());
                elem.click();
                System.out.println(elem.getText());
                elem=driver.findElement(By.xpath("//a[@id='ui-id-2']"));
                System.out.println(elem.isEnabled());
                elem.click();
                
                Point punto =elem.getLocation();
              //  driver.navigate().back();
                elem=driver.findElement(By.xpath(".//*[@id='tabs-2']/div/p/a"));
                System.out.println(elem.isEnabled());
                System.out.println(elem.getText());
              //  elem.click();
                System.out.println(driver.navigate().hashCode());
                System.out.println(elem.getTagName());
//               System.out.println(punto.toString());
                System.out.println(elem.getText());


// TODO code application logic here
    }
    
}
