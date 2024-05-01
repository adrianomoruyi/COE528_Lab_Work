/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex1;

/**
 *
 * @author babye
 */
public class DigitCounter extends AbstractCounter{
    
    public String count()
    {
        return Integer.toString(getComponent());
    }
    
    public void increment()
    {
        if (getComponent() == 9)
        {
            setComponent(0);
        }
        else
        {
            setComponent(getComponent() + 1);
        }
    }
    
    public void decrement()
    {
        if (getComponent() == 0)
        {
            setComponent(9);
        }
        else
        {
            setComponent(getComponent() - 1);
        }
    }
    
   public void reset()
    {
        setComponent(0);
    }
   
    public String toString(){ 
  return Integer.toString(getComponent());  
 }  
    
}
