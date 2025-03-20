/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxcollectorassignment;
import java.util.*;
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

    public static int[] ceilingNumber() {
    System.out.print("Please enter a ceiling number: ");
    Scanner input = new Scanner(System.in);
       while (!input.hasNextInt()) {
        System.out.println("Number must be a positive integer:");
        input.nextLine();
        }   
        int n = input.nextInt();
        while (n <= 0) {
        System.out.println("Number must be a positive integer:");
        while (!input.hasNextInt()) {
            System.out.println("Number must be a positive integer:");
            input.next();
        }
        n = input.nextInt();
        }

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
        array[i] = i + 1;
        }
        input.close();
        return array;
    }

    public static void displayScreen(int userScore, ArrayList<Integer> userNumbers, int collectorScore, int[] collectorNumbers, int[] numberList) {
        System.out.println("Current Board:");
        System.out.println(Arrays.toString(numberList)); //userNumbers will be made in main
        System.out.println("User's Score: " + userNumbers + " = " + userScore); //the ArrayList thing is just a dynamic version of arrays, its better for changing array sizes
        System.out.println("Collector's Score: " + Arrays.toString(collectorNumbers) + " = " + collectorScore);
    }
}



