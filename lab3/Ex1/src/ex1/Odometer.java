/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex1;

import java.util.Arrays;

/**
 *
 * @author babye
 */
public class Odometer {
    
    private AbstractCounter [] odoArray;

    private int num;
    
    public Odometer(int num) {
        
        if (num < 1)
        {
            throw new IllegalArgumentException();
        }
        
        this.num = num;
        
        odoArray = new AbstractCounter [num];
        
        odoArray[0] = new DigitCounter();
        
        for (int i = 1; i < num; i++)
        {
            odoArray[i] = new LinkedDigitCounter(odoArray[i-1]);
        }
        
    }
    
    public String count()
    {
       String result = "";
       
       for (int i = 0; i < num; i++)
       {
           result += odoArray[i];
       }
       
       return result;
    }
    
    public void increment()
    {
       odoArray[num-1].increment();
    }
    
    public void decrement()
    {
         odoArray[num - 1].decrement();
    }
    
   public void reset()
    {
        for (int i = 0; i < num; i++)
        {
            odoArray[i].setComponent(0);
        }
    }
    
}
