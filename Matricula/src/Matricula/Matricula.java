package Matricula;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cp
 */
public class Matricula {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver(); 
        driver.get("http://tec-appsext.itcr.ac.cr/Matricula/frmAutenticacion.aspx");
        
        driver.findElement(By.id("txtUsuario")).sendKeys("correoUsuario");
                                                                                         driver.findElement(By.id("txtPassword")).sendKeys("password");
        
                                                     
        driver.findElement(By.id("btnEntrar")).click();
        
        //driver.findElement(By.className("btn_Consultar"));
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("btn_Consultar"))).click();
        
        System.err.println("Materia");
        String materia="CS2101";
        WebElement ele= wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                By.id("CS2101")));
        String cupo="cupo";
        List<WebElement>elemts=driver.findElements(By.className("imgAccordion"));
        for (int i=0;i<elemts.size();i++){
            elemts.get(i).click();
        }
        //List<WebElement>elemts=driver.findElements(
         //       By.id("cupoFI1202"));
         
        //WebElement ele1=driver.findElement(By.xpath("//*[@id=\"bodyTableHorarios_CS2101\"]/tr[1]"));
        
        String grupo="1";
        
        WebElement ele2=driver.findElement(By.id("cupoCS21011"));
        
        System.out.println(ele2.getText());
        
        //System.out.println();
        WebElement primerMateria=driver.findElement(By.id("bodyTableHorarios_CS2101"));
        List<WebElement> cursos=primerMateria.findElements(By.tagName("tr"));
        System.out.println(cursos.size());
        for (int i =0;i<cursos.size()-3;i++){
            
            System.out.println(cursos.get(i).findElement(
                    By.id("cupo"+materia+(i+1))).getText());
        }
        long start_time = System.currentTimeMillis();
        cursos.get(0).findElement(
                    By.id("cupo"+materia+"1")).getText();
        long end_time = System.currentTimeMillis();
        long difference = end_time-start_time;
        System.out.println("PrimeraPruebaCursos:"+difference);
        
        start_time=System.currentTimeMillis();
        driver.findElement(By.id("cupo"+materia+"1")).getText();
        end_time=System.currentTimeMillis();
        difference=end_time-start_time;
        System.out.println("SegurndaPruebaconDriver:"+difference);
        
        
        
        
        //La forma del boton es id="FI1102_12" materia+"_"+grupo
        
        
        WebDriverWait waitt = new WebDriverWait(driver,100);
        long a=System.currentTimeMillis();
    waitt.until(new ExpectedCondition<Boolean>() {
   
        public Boolean apply(WebDriver driver) {
        
        WebElement cupos = driver.findElement(By.id("cupo"+materia+"5"));
        System.out.println("Sdfadf:"+cupos.getText());
        if(!cupos.getText().equals("0")){ 
            System.out.println("Funciono");
               //La forma del boton es id="FI1102_12" materia+"_"+grupo
            
            return true;
        }
        else
            return false;
        }
    });
    long b=System.currentTimeMillis();
        System.out.println("Tiempo:"+(b-a));
        
        
        
        //SeleccionaGrupo("FI1202","1")
        //Forma de matricular por javascripy SeleccionaGrupo("Curso","Grupo")
           if (driver instanceof JavascriptExecutor) {
       ((JavascriptExecutor) driver).executeScript("SeleccionaGrupo('FI1202','1')");
        } else {
            throw new IllegalStateException("This driver does not support JavaScript!");
        }
       
           
       // ele.click();
        
        
        
        
    }
   
    public static void matricular(WebDriver driver,String materia,String grupo){
          
        if (driver instanceof JavascriptExecutor) {
       ((JavascriptExecutor) driver).executeScript("SeleccionaGrupo('"+materia+"','"+grupo+"')");
        } else {
            throw new IllegalStateException("This driver does not support JavaScript!");
        }
    }
    
    public static void robarCampo(WebDriver driver,int tiempoEnSegundos,String materia,String grupo){
        
        WebDriverWait waitt = new WebDriverWait(driver,tiempoEnSegundos);
        waitt.until(new ExpectedCondition<Boolean>() {
        
        public Boolean apply(WebDriver driver) {
        
        WebElement cupos = driver.findElement(By.id("cupo"+materia+grupo));
        System.out.println("Sdfadf:"+cupos.getText());
        if(!cupos.getText().equals("0")){ 
            System.out.println("Funciono");
            
            //La forma del boton es id="FI1102_12" materia+"_"+grupo
            driver.findElement(By.id(materia+"_"+grupo)).click();           
            return true;
            
        }
        else
            return false;
        }
    });
    
    }
    
}
