/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex1;

import java.util.ArrayList;

public class Queue<Integer> {
// Overview: Queues are mutable, bounded
// collection of distinct elements that operate in
// LIFO (Last-In-First-Out) order.
//
// The abstraction function is:
// AF (c) { c.items.get(i) | 0<= i < c.items.size() }
//
// The rep invariant is:
// c.items != null &&
// 
// All elements of c.items are Integers
// There can be no duplicates.

    private ArrayList<Integer> items;

    public Queue() {
        //EFFECTS: The constructor for the creation of a Queue object
        items = new ArrayList<Integer>();
    }

    public void enqueue(Integer element) {
// MODIFIES: this
// EFFECTS: Appends the element at the top of the queue
        if (element == null) {
            throw new IllegalArgumentException("You provided no element!");
        }

        items.add(element);
    }

    public Integer dequeue() {
// MODIFIES: this
// EFFECTS: Removes an element from the top of the queue
        if (items.size() == 0) {
            throw new IllegalArgumentException("The queue is empty!");
        }
        return items.remove(0);
    }

    public boolean isEmpty() {
        // EFFECTS: Returns true if the queue is empty, returns false otherwise
        return items.isEmpty();

    }

    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
        if (items == null) {
            return false;
        }

        for (Integer item : items) {
            if (items == null) {
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
        return items.toString();
    }
}
