/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author cp
 *///0427
public class PruebaEnRandom {
     public static void main(String[] args) {
      WebDriver driver = new ChromeDriver(); 
      driver.get("https://www.random.org/");
      
      driver.findElement(By.xpath("//input[@title='search']")).click();
      driver.findElement(By.xpath("//input[@value='Generate']"));
      
//      driver.findElement(By.id("true-random-integer-generator-button")).click();
      WebElement ele=driver.findElement(By.id("true-random-integer-generator-result"));
      System.out.println(ele.getText());
      while (true){
      System.out.println(ele.getText());
      }
    
    }
}
