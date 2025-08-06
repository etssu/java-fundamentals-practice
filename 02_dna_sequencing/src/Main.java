import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Existing modes:\n1. Clean the sequence.\n2. Count nucleotides.\n3. Find genes." +
                    "\n4. Get complementary sequence.\n5. Compare sequences.\n6. Exit.\nEnter the number of the mode you need: ");
            int mode = scanner.nextInt();
            scanner.nextLine(); // delete the '\n'

            switch (mode){
                case 1: // cleaning sequence
                    DNAMethods.cleanSequence(scanner);
                    break;
                case 2: // count
                    DNAMethods.countNucleotides(scanner);
                    break;
                case 3: //find genes
                    break;
                case 4: // complementary
                    DNAMethods.complementarySequence(scanner);
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