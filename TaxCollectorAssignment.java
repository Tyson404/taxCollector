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
        System.out.println("Welcome to The Tax Collector Game!");
        int[] numberList = ceilingNumber(); //generates the numbers being used, & various objects used in the functions
        int userScore = 0;
        int collectorScore = 0;
        ArrayList<Integer> userNumbers = new ArrayList<Integer>();
        ArrayList<Integer> collectorNumbers = new ArrayList<Integer>();
        while (true) {
            displayScreen(userScore, userNumbers, collectorScore, collectorNumbers, numberList); //the main printer, prints what numbers are left & the user & collectors scores
            int userChoice = userChoice(numberList);
            userScore += userChoice;
            userNumbers.add(userChoice);
            numberList = removeChoice(userChoice, numberList);
            collectorScore = addToCollector(userChoice, collectorScore, numberList);
            collectorNumbers = collectorNumbers(userChoice, collectorNumbers, numberList);
            numberList = removeDivisors(userChoice, numberList);
            boolean noDivisors = noDivisors(numberList);
            if (noDivisors) {
                System.out.println("No More Divisors Left!");
                for (int i = 0; i < numberList.length; i++) {
                    collectorScore += numberList[i];
                    collectorNumbers.add(numberList[i]);
                }
                numberList = new int[0];
            }
            end(userScore, collectorScore, numberList);
            if (numberList.length == 0) {
                scanner.close();
                break;
            }
        }
    }
    
    public static int[] removeChoice(int userChoice, int[]numberList) {
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

    public static int userChoice(int[] numberList) {
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
    return choice;
    }

    public static int addToCollector(int userChoice, int collectorScore, int[] numberList) { //if noDivisors == true, userChoice will be set to 1 in main
        for (int i = 0; i < numberList.length; i++) { 
            if (userChoice % numberList[i] == 0 && userChoice > numberList[i]) {
                collectorScore += numberList[i];
            }
        }
        return collectorScore;
    }

    public static int[] removeDivisors(int userChoice, int[] numberList) {
        int listSize = 0;
        int[] numberList2;
        for (int i = 0; i < numberList.length; i++) {
            if (userChoice % numberList[i] != 0) {
                listSize += 1;
            }
        }
        numberList2 = new int[listSize];
        int k = 0;
        for (int i = 0; i < numberList.length; i++) {
            if (userChoice % numberList[i] != 0) {
                try {
                numberList2[k] = numberList[i];
                k += 1;
                } catch (Exception m) {}
            }
        }
        return numberList2;
    }

    public static boolean noDivisors(int[] numberList) {
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
        return noDivisors;
    }

    public static int[] ceilingNumber() {
    System.out.print("Please enter a ceiling number: ");
    while (!scanner.hasNextInt()) {
        System.out.println("Number must be a positive integer:");
        scanner.nextLine();
        }   
        int n = scanner.nextInt();
        while (n <= 0) {
        System.out.println("Number must be a positive integer:");
        while (!scanner.hasNextInt()) {
            System.out.println("Number must be a positive integer:");
            scanner.next();
        }
        n = scanner.nextInt();
        }

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
        array[i] = i + 1;
        }
        return array;
    }

    public static void displayScreen(int userScore, ArrayList<Integer> userNumbers, int collectorScore, ArrayList<Integer> collectorNumbers, int[] numberList) {
        System.out.println("Current Board:");
        System.out.println(Arrays.toString(numberList)); 
        System.out.println("User's Score: " + userNumbers + " = " + userScore);
        System.out.println("Collector's Score: " + collectorNumbers + " = " + collectorScore);
    }
    
    public static ArrayList<Integer> collectorNumbers(int userChoice, ArrayList<Integer> collectorNumbers, int[] numberList) {
        for (int i = 0; i < numberList.length; i++) {
            if (userChoice % numberList[i] == 0 && userChoice > numberList[i]) {
                collectorNumbers.add(numberList[i]);
            }
        }
        return collectorNumbers;
    }
    
    public static void end(int userScore, int collectorScore, int[] ceilingNumber) {
        if (ceilingNumber.length == 0) {
            System.out.println("Game Over");
            if (userScore > collectorScore) {
            System.out.println("You Win! Your score: " + userScore + "  Collector's score: " + collectorScore);
            } else if (userScore < collectorScore) {
            System.out.println("You Lost! Tax collector wins. Your score: " + userScore + " | Collector's score: " + collectorScore);
            } else {
            System.out.println("It's a Tie! Both scores: " + userScore);
            }
        }
    public static void noDivisorsTest() {
        System.out.println("Testing noDivisors...");

        int[] testInput = {1,2,3,4,5,6,7,8,9,10};
        boolean expected = false; 
        boolean actual = noDivisors(testInput);

        if (actual == expected) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 failed. Expected " + expected + ", got " + actual);
        }
        int[] testInput2 = {5,7,11,13,17};
        boolean expected2 = true; 
        boolean actual2 = noDivisors(testInput2);

        if (actual2 == expected2) {
            System.out.println("Test 2 passed");
        } else {
            System.out.println("Test 2 failed. Expected " + expected2 + ", got " + actual2);
    
        }   int[] testInput3 = {4,4,4,4,4,4};
        boolean expected3 = false; 
        boolean actual3 = noDivisors(testInput3);

        if (actual3 == expected3) {
        System.out.println("Test 3 passed");
        } else {
        System.out.println("Test 3 failed. Expected " + expected3 + ", got " + actual3);
        }
        int[] testInput4 = {5};
        boolean expected4 = true; 
        boolean actual4 = noDivisors(testInput4);

        if (actual4 == expected4) {
            System.out.println("Test 4 passed");
        } else {
            System.out.println("Test 4 failed. Expected " + expected4 + ", got " + actual4);
    }
    }
}



