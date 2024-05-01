/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

import java.util.ArrayList;

/**
 * Overview: Manager is the mutable class that represents a manager for the banking application. A manager has a username, password, and customer list.
 * 
 * Abstraction Function: Customer is represented by the username, password, and customer list.
 * 
 * Rep Invariant: The username and password must not be null.
 * @author babye
 */
public class Manager extends User {
    
    private ArrayList<Customer> customerList = new ArrayList<Customer>();
    
    public Manager() {
        this.username = "admin";
        this.password = "admin";
        this.role = "manager";
    }

    public void addCustomer(String username, String password) throws Exception {
        
        for (int i = 0; i < customerList.size(); i++)
        {
            if (customerList.get(i).getUsername().equals(username))
            {
                throw new Exception("That username is already taken!");
            }
        }
        
        customerList.add(new Customer(username, password));
    }

    public void deleteCustomer(String name) {
        
        for (int i = 0; i < customerList.size(); i++)
        {
            if (customerList.get(i).getUsername().equals(name))
            {
                 customerList.get(i).deleteFile();
                 customerList.remove(i);
                 break;
            }
        }
    }
    
    public void deleteAll() {
        
        for (int i = 0; i < customerList.size(); i++)
        {
               customerList.get(i).deleteFile();
        }
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
        if (username == null || password == null)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
// EFFECTS: Returns a string that contains the username, password, and customer list. Implements the
// abstraction function.
        return "Username: " + username + ". Password: " + password + ". Customers: " + customerList + ".";
    }
}
