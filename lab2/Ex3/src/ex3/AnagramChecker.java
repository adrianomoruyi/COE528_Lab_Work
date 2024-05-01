/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex3;

import java.util.Arrays;

/**
 *
 * @author babye
 */
public class AnagramChecker {

//Requires: <Strings str1 and str2>
//Modifies: <str1 and str2 to remove any whitespace>
//Effects: <Returns true if both strings are anagrams, returns false they are not>
    public static boolean areAnagrams(String str1, String str2) {
        boolean result = false;
        str1 = str1.replaceAll("\\s+", "");
        str2 = str2.replaceAll("\\s+", "");
        if (str1.length() == str2.length() && str1 != null && str2 != null) {
            char[] array1 = str1.toLowerCase().toCharArray();
            char[] array2 = str2.toLowerCase().toCharArray();
            Arrays.sort(array1);
            Arrays.sort(array2);
            //System.out.println(str1);
            //System.out.println(str2);
            result = Arrays.equals(array1, array2);
        }
        return result;
    }

    public static void main(String[] args) {
        
        if (args.length == 1) {
            if (args[0].equals("1")) {
                System.out.println(areAnagrams("Fired", "Fried"));
            } else if (args[0].equals("2")) {
                System.out.println(areAnagrams(null, null));
            } else if (args[0].equals("3")) {
                System.out.println(areAnagrams("Dormitory", "Dirty room"));
            }
        }
    }
}
