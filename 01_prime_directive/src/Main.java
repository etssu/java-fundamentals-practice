import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        while (true) {
            System.out.print("Enter mode (full / odd / even / custom) or 'exit': ");
            String mode = input.nextLine().toUpperCase(); // get mode

            switch (mode) {
                case "FULL":
                    PrimeModes.handleFullMode(input);
                    break;
                case "EVEN":
                    System.out.println("There is no prime number in even numbers. All can be divided by 2.");
                    break;
                case "ODD":
                    PrimeModes.handleOddMode(input);
                    break;
                case "CUSTOM":
                    PrimeModes.customRangeScan(input);
                    break;
                case "EXIT":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
    }
}