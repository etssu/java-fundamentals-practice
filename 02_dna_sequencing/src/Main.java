import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Enter the number of the mode you need:\n1. Clean the sequence.\n2. Count nucleotides.\n3. Find genes." +
                    "\n4. Get complementary sequence.\n5. Compare sequences.\n6. Exit.");
            int mode = scanner.nextInt();
            switch (mode){
                case 1: // cleaning sequence
                    DNAMethods.cleanSequence(scanner);
                    break;
                case 2: // count
                    break;
                case 3: //find genes
                    break;
                case 4: // complementary
                    break;
                case 5: // compare
                    break;
                case 6: // exit
                    System.out.println("Thank you for using DNA Sequencing Tool!");
                    System.exit(0);
                default:
                    System.out.println("Invalid input. Try again.");
            }

        }
    }
}