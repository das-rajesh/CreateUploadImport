/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajesh.webapp;

import com.rajesh.webapp.entity.Customer;
import java.io.FileWriter;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class Program {
     public static void main(String[] args) {
         try {
             FileWriter writer=new FileWriter("d:customer_data.csv");
             for(int i=0;i<50000;i++){
                 Customer customer=new Customer();
                 customer.setId(i);
                 customer.setFirstName(i+"fake firstName");
                 customer.setLastName(i+"fake lastName");
                 customer.setEmail("fake"+i+"@gmail.com");
                 
                 Random random=new Random();
                 customer.setContactNo("9"+random.nextDouble());
                 customer.setStatus(true);
                 writer.write(customer.toCSV());
             }
             writer.close();
             
         } catch (Exception e) {
         }
    }
    
}
