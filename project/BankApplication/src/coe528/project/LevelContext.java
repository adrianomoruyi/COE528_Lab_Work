/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

/**
 * Overview: LevelContext is the mutable class that represents the context implementation of the customer's level.
 * 
 * Abstraction Function: LevelContext is represented by the current state of the level;
 * 
 * Rep Invariant: The customerState must not be null.
 * @author babye
 */
public class LevelContext implements State {

    private State customerState;

    public void setState(State state) {
        this.customerState = state;
    }

    public State getState() {
        return this.customerState;
    }
    
    @Override
    public double purchase() {
        return this.customerState.purchase();
    }

    @Override
    public String getName() {
        return "LevelContext";
    }

    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
        if (customerState == null)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
// EFFECTS: Returns a string that contains the state information. Implements the
// abstraction function.
        return "Level name: " + customerState.getName() + ". Purchase discount: $" + customerState.purchase() + ".";
    }
    
}
