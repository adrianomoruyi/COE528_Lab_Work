/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex1;

import java.util.ArrayList;

public class StackOfDistinctStrings {
// Overview: StacksOfDistinctStrings are mutable, bounded
// collection of distinct strings that operate in
// LIFO (Last-In-First-Out) order.
//
// The abstraction function is:
// a) Write the abstraction function here
//
// AF (c) { c.items.get(i) | 0<= i < c.items.size() }
//
//
// The rep invariant is:
// b) Write the rep invariant here
// c.items != null &&
// 
// All elements of c.items are Integers
// There can be no duplicates.
//the rep

    private ArrayList<String> items;
// constructor

    public StackOfDistinctStrings() {
// EFFECTS: Creates a new StackOfDistinctStrings object
        items = new ArrayList<String>();
    }

    public void push(String element) throws Exception {
// MODIFIES: this
// EFFECTS: Appends the element at the top of the stack
// if the element is not in the stack, otherwise
// does nothing.
        if (element == null) {
            throw new Exception();
        }
        if (false == items.contains(element)) {
            items.add(element);
        }
    }

    public String pop() throws Exception {
// MODIFIES: this
// EFFECTS: Removes an element from the top of the stack
        if (items.size() == 0) {
            throw new Exception();
        }
        return items.remove(items.size() - 1);
    }

    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
// c) Write the code for the repOK() here
        if (items == null)
        {
            return false;
        }
        
        for (String item : items)
        {
            if (items == null)
            {
                return false;
            }
        }
        return true;
    }

    public String toString() {
// EFFECTS: Returns a string that contains the strings in the
// stack and the top element. Implements the
// abstraction function.
// d) Write the code for the toString() here
        return items.get(items.size()-1);
    }
}
