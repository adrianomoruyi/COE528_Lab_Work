/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Overview: Customer is the mutable class that represents a customer for the banking application. A customer has a username, password, balance, and level.
 * 
 * Abstraction Function: Customer is represented by the username, password, balance, and customer level.
 * 
 * Rep Invariant: The customer level must not be null. The balance must be greater than 0.
 * @author babye
 */
public class Customer extends User {

    private double balance;

    protected LevelContext context;
    protected State silver;
    protected State gold;
    protected State platinum;
    protected File cusFile;

    public Customer(String username, String password) {
        this.balance = 100.00;
        context = new LevelContext();
        silver = new SilverState();
        gold = new GoldState();
        platinum = new PlatinumState();

        this.username = username;
        this.password = password;
        this.role = "customer";
        levelCheck();

        cusFile = new File(username + ".txt");

        try {

            if (cusFile.createNewFile()) {
                System.out.println("File created: " + cusFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred. The file was not created");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter(username + ".txt");
            writer.write(username + "\n");
            writer.write(password + "\n");
            writer.write(role);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred. Nothing was written to the file.");
            e.printStackTrace();
        }

    }
    
    public String fileRead(int line) throws FileNotFoundException
    {
        Scanner myReader = new Scanner(cusFile);
        
        for (int i = 0; i < line - 1; i++)
        {
            myReader.nextLine();
        }
        
      return myReader.nextLine();
    }

    public void deleteFile() {
        if (cusFile.delete()) {
            System.out.println("Deleted the file: " + cusFile.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public void levelCheck() {
        if (balance < 10000) {
            context.setState(silver);
        } else if (balance >= 20000) {
            context.setState(platinum);
        } else {
            context.setState(gold);
        }
    }
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LevelContext getContext() {
        return context;
    }
    
    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
        if (context == null || balance < 0)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
// EFFECTS: Returns a string that contains the username, password, balance, and level. Implements the
// abstraction function.
        return "Username: " + username + ". Password: " + password + ". Balance: " + balance + ". Level: " + context.getState().getName() + ".";
    }
    
}
