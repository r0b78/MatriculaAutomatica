/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula;

/**
 *
 * @author cp
 */
public class sdf {
   public static void main(String[] args) throws InterruptedException {
   long a=System.currentTimeMillis();
   
   Thread.sleep(10000);
   long b=System.currentTimeMillis();
       System.out.println("Tiempo:"+(b-a));    
   }
}
