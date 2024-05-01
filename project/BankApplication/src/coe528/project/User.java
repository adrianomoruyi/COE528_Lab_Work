/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

/**
 * Overview: User is the mutable class that represents the accounts that can be created for the banking application.
 * 
 * Abstraction Function: User is represented by the username, password, balance, and role.
 * 
 * Rep Invariant: The username, password, and role must not be null.
 * @author babye
 */
public abstract class User {
    
    protected String username;
    protected String password;
    protected String role;
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getRole()
    {
        return role;
    }
    
    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
        if (username == null || password == null || role == null)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
// EFFECTS: Returns a string that contains the username, password, balance, and level. Implements the
// abstraction function.
        return "Username: " + username + ". Password: " + password + ". Role: " + role + ".";
    }
}
