/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

/**
 * Overview: PlatinumState is the immutable class that represents the state of a customer's level being platinum.
 * 
 * Abstraction Function: PlatinumState is represented by the name and the purchase discount;
 * 
 * Rep Invariant: The name must be "platinum".
 * @author babye
 */
public class PlatinumState implements State {
    
    private String name = "platinum";

    public String getName() {
        return name;
    }
    
    @Override
    public double purchase() {
        return 0.00;
    }
    
    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
        if (name.equals("platinum") == false)
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
