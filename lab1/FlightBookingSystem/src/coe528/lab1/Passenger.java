/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

/**
 *
 * @author babye
 */
public abstract class Passenger {
    private String name;
    private double age;

    public Passenger(String name, double age) {
        this.name = name;
        this.age = age;
    }
    
    public abstract double applyDiscount(double p);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
    
    
    
}
