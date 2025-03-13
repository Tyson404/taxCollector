/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxcollectorassignment;
import java.util.Scanner;
/**
 *
 * @author 25quangt
 */
public class TaxCollectorAssignment {
    private static Scanner scanner = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {1,2,3,4,5};
        int guess = userChoice(array);
        System.out.println(guess);
    }
    public static int userChoice(int[] ceilingNumber) {
        int highestNumber = (ceilingNumber.length - 1);
        System.out.println("guess");
        while (!scanner.hasNextInt()) {
            System.out.println("againk");
            scanner.nextLine();
        }
        int choice = scanner.nextInt();
        while (choice < 1 || choice > ceilingNumber[highestNumber]) {
            System.out.println("again");
            scanner.nextLine();
            choice = scanner.nextInt();
        }
        return choice; //placeholder
    }
    
}
