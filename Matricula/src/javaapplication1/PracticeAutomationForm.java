/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.List;
import jdk.internal.util.xml.impl.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author cp
 */
public class PracticeAutomationForm {
     public static void main(String[] args) {
        
       String exePath = "chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver=new ChromeDriver();
//                
		driver.get("http://toolsqa.wpengine.com/automation-practice-form/");
//                System.out.println(driver.getPageSource());

   	//	driver.get("http://demoqa.com/frames-and-windows/");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Roberto");
                driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Calderon");
                List<WebElement> radioB=driver.findElements(By.name("sex"));
                //radioB.get(0).click();
                for (int i=0;i<radioB.size();i++){
                    if (radioB.get(i).getAttribute("value").equals("Male")){
                        radioB.get(i).click();
                    }
                    //System.out.println(radioB.get(i).getAttribute("value"));
                
                }
                radioB=driver.findElements(By.name("exp"));
                //radioB.get(0).click();
                for (int i=0;i<radioB.size();i++){
                    if (radioB.get(i).getAttribute("value").equals("3")){
                        radioB.get(i).click();
                    }
                    //System.out.println(radioB.get(i).getAttribute("value"));
                
                }
                driver.findElement(By.id("datepicker")).sendKeys("12/07/17");
               radioB=driver.findElements(By.name("profession"));
                
                for (int i=0;i<radioB.size();i++){
                    if (radioB.get(i).getAttribute("value").equals("Automation Tester")){
                        radioB.get(i).click();
                    }
                    //System.out.println(radioB.get(i).getAttribute("value"));
                
                } 
                radioB=driver.findElements(By.name("tool"));  
                
                for (int i=0;i<radioB.size();i++){
                    if (radioB.get(i).getAttribute("value").equals("Selenium Webdriver")){
                        radioB.get(i).click();
                    }
                    //System.out.println(radioB.get(i).getAttribute("value"));
                
                }
            Select oSelect = new Select(driver.findElement(By.id("continents")));
            List <WebElement> elementCount = oSelect.getOptions();
            
            oSelect.selectByVisibleText("Africa");
            for(int i =0; i<elementCount.size() ; i++){
		String sValue = elementCount.get(i).getText();
		System.out.println(sValue);
		}
            System.out.println(oSelect.isMultiple());
            
            oSelect = new Select(driver.findElement(By.id("selenium_commands")));
            elementCount = oSelect.getOptions();
            
            for(int i =0; i<elementCount.size() ; i++){
		String sValue = elementCount.get(i).getText();
		System.out.println(sValue);
		}
            System.out.println(oSelect.isMultiple());
            if (oSelect.isMultiple()){
            oSelect.selectByVisibleText("Browser Commands");
            oSelect.selectByVisibleText("Wait Commands");
       //     oSelect.selectByVisibleText("Africa");
            
            }
            WebElement button=driver.findElement(By.xpath("//button[@class='btn btn-info'][@id='submit']"));
            button.click();
// TODO code application logic here
    }
    
}
