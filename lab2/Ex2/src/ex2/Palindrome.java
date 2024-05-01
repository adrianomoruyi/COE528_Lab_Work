/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2;

/**
 *
 * @author babye
 */
public class Palindrome {

//Requires: <String a>
//Modifies: <Nothing>
//Effects: <Returns true if String a is a palindrome, returns false is String a is not a palindrome>
    public static boolean isPalindrome(String a) {
        if (a != null && a.length() > 0) {
            String c = a.toLowerCase();
            String b = new StringBuilder(a).reverse().toString().toLowerCase();
            if (c.equals(b)) {
                return true;
            } 
            else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        if (args.length == 1) {
            if (args[0].equals("1")) {
                System.out.println(isPalindrome(null));
            } else if (args[0].equals("2")) {
                System.out.println(isPalindrome("Radar"));
            } else if (args[0].equals("3")) {
                System.out.println(isPalindrome("deed"));
            } else if (args[0].equals("4")) {
                System.out.println(isPalindrome("abcd"));
            }
        }
    }

}
