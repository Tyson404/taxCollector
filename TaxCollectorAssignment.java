/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxcollectorassignment;
import java.util.Scanner;
/**
 */
public class TaxCollectorAssignment {
    private static Scanner scanner = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static int[] removeChoice(int userChoice, int[]numberList) { //needs testing
        //add score in main instead of here
        int[] numberList2;
        numberList2 = new int[numberList.length - 1];
        for (int i = 0, k = 0; i < numberList.length; i++) {
            if (numberList[i] == userChoice) {
                continue;
            }
            numberList2[k++] = numberList[i];
        }
        return numberList2;
    }

    public static int userChoice(int[] numberList) { //needs testing
    int choice = 0;
    int highestNumber = (numberList.length - 1);
    boolean existsInList = false;
    System.out.println("Pick a number!");
    try {
    choice = scanner.nextInt();
    } catch (Exception m) {}
    for (int i = 0; i < numberList.length; i ++) {
        if (choice == numberList[i]) {
            existsInList = true; 
        }
    }
    while (choice < 1 || choice > numberList[highestNumber] || existsInList == false) {
        System.out.println("Please pick a valid option from the list.");
        System.out.println("choice = " + choice);
        scanner.nextLine();
        try {
        choice = scanner.nextInt();
        } catch (Exception m) {}
        for (int i = 0; i < numberList.length; i ++) {
            if (choice == numberList[i]) {
                existsInList = true; 
            }
        }
    }
    scanner.close();
    return choice;
    }

    public static int addToCollector(int userChoice, int collectorScore, int[] numberList) { //if noDivisors == true, userChoice will be set to 1 in main
        for (int i = 0; i < numberList.length; i++) { //needs testing
            if (numberList[i] % userChoice == 0) {
                collectorScore += numberList[i];
            }
        }
        return collectorScore;
    }

    public static int[] removeDivisors(int userChoice, int[] numberList) {
        int listSize = 0;
        int[] numberList2;
        for (int i = 0; i < numberList.length; i++) {
            if (numberList[i] % userChoice != 0) {
                listSize += 1;
            }
        }
        numberList2 = new int[listSize];
        int k = 0;
        for (int i = 0; i < numberList.length; i++) {
            if (numberList[i] % userChoice != 0) {
                try {
                numberList2[k] = numberList[i];
                k += 1;
                } catch (Exception m) {}
            }
        }
        return numberList2;
    }

    public static boolean noDivisors(int[] numberList) { //needs testing
        boolean noDivisors = true;
        int k = 0;
        for (int i = 0; i < numberList.length; i++) {
            while (k < numberList.length - 1) {
                if (numberList[i] % numberList[k] == 0 && numberList[i] != numberList[k]) {
                    noDivisors = false;
                }
                k++;
            }
            k = 0;
        }
        return noDivisors; //instead, have the removal of all numbers happen in addToCollector, just set the divisor to 1 lol.
        //tl;dr if (noDivisors == true), userChoice == 1
    }

    
}
