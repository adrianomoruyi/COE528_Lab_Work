/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

/**
 * Overview: GoldState is the immutable class that represents the state of a customer's level being gold.
 * 
 * Abstraction Function: GoldState is represented by the name and the purchase discount;
 * 
 * Rep Invariant: The name must be "gold".
 * @author babye
 */
public class GoldState implements State {
    
    private String name = "gold";

    public String getName() {
        return name;
    }
    
    @Override
    public double purchase() {
        return 10.00;
    }
    
    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
        if (name.equals("gold") == false)
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
