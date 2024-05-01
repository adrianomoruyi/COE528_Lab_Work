/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

/**
 * Overview: SilverState is the immutable class that represents the state of a customer's level being silver.
 * 
 * Abstraction Function: SilverState is represented by the name and the purchase discount;
 * 
 * Rep Invariant: The name must be "silver".
 * @author babye
 */
public class SilverState implements State {
    private String name = "silver";

    public String getName() {
        return name;
    }
    
    @Override
    public double purchase() {
        return 20.00;
    }
    
    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
        if (name.equals("silver") == false)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
// EFFECTS: Returns a string that contains the state name and purchase discount. Implements the
// abstraction function.
        return "Level name: " + name + ". Purchase discount: $" + purchase() + ".";
    }
    
}
