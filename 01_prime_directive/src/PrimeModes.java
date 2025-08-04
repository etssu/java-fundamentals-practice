import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class PrimeModes {

    public static void handleFullMode(Scanner input) { // numbers from 1 to endNumber (full range)
        System.out.print("Enter end number: ");
        int endNumber = input.nextInt();
        input.nextLine();
        if (endNumber < 1){
            System.out.println("End number must be greater than 1!");
        }
        System.out.println("=====[SCAN LOG]=====");
        System.out.println("Analyzing numbers 1 - " + endNumber);
        int primeCount = 0;
        int compositeCount = 0;
        for (int i = 1; i <= endNumber; i++){
            if (i == 1){
                System.out.println("Number 1 is neither prime nor composite.");
            } else if (isPrime(i)) {
                System.out.println("Prime number: " + i);
                primeCount++;
            } else {
                compositeCount++;
            }
        }
        System.out.printf("Total primes: %d, composites: %d\n", primeCount, compositeCount);
    }

    public static void handleOddMode(Scanner input) { // numbers from 1 to endNumber (only odd numbers)
        System.out.print("Enter end number: ");
        int endNumber = input.nextInt();
        input.nextLine();
        if (endNumber < 1){
            System.out.println("End number must be greater than 1!");
        }

        System.out.println("=====[SCAN LOG]=====");
        System.out.println("Analyzing odd numbers 1 - " + endNumber);
        int primeCount = 0;
        int compositeCount = 0;
        for (int i = 1; i <= endNumber; i += 2){
            if (i == 1){
                System.out.println("Number 1 is neither prime nor composite.");
            } else if (isPrime(i)){
                System.out.println("Prime number: " + i);
                primeCount++;
            } else {
                compositeCount++;
            }
        }
        System.out.printf("Total primes: %d, composites: %d\n", primeCount, compositeCount);
    }

    public static void customRangeScan(Scanner input) {
        System.out.print("Enter start number: ");
        int startNumber = input.nextInt();
        input.nextLine();
        System.out.print("Enter end number: ");
        int endNumber = input.nextInt();
        input.nextLine();

        if (startNumber > endNumber) {
            System.out.println("Start number is greater than end number. Enter valid numbers next time.");
        }
        if (endNumber < 1){
            System.out.println("End number must be greater than 1!");
        }

        System.out.println("=====[SCAN LOG]=====");
        System.out.printf("Analyzing numbers %d - %d\n", startNumber, endNumber);
        int primeCount = 0;
        int compositeCount = 0;
        for (int i = startNumber; i <= endNumber; i++){
            if (i == 1){
                System.out.println("Number 1 is neither prime nor composite.");
            } else if (isPrime(i)){
                System.out.println("Prime number: " + i);
                primeCount++;
            } else {
                compositeCount++;
            }
        }
        System.out.printf("Total primes: %d, composites: %d\n", primeCount, compositeCount);
    }

    public static boolean isPrime(int number){ // true if number is prime, false otherwise
        if (number < 2) return false;
        int i = 2;
        while (i * i <= number){
            if (number % i == 0) {
                System.out.printf("Composite: %d (%d x %d)\n", number, i, number / i);
                return false; // number is composite
            }
            i++;
        }
        return true; // number is prime
    }
}
