/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

/**
 *
 * @author babye
 */
public class Member extends Passenger {
    private int yearsOfMembership;

    public Member(int yearsOfMembership, String name, double age) {
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }
    
    public double applyDiscount(double p)
    {
        if (yearsOfMembership > 5)
        {
            return 0.5*p;
        }
        else if (yearsOfMembership > 1 && yearsOfMembership <= 5)
        {
            return 0.9*p;
        }
        return p;
    }
    
}
