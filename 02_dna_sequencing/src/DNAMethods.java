import java.util.Scanner;

public class DNAMethods {

    public static void cleanSequence(Scanner input){
        String sequence = input.nextLine();
        input.nextLine(); // to remove \n

        sequence = sequence.toUpperCase();
        StringBuilder sb = new StringBuilder(sequence.length());

        for (int i = 0; i < sequence.length(); i++) {
            char c =  sequence.charAt(i);
            if (c == 'A' || c == 'C' || c == 'T' || c == 'G'){
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}
