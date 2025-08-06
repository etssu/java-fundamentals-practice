import java.util.HashMap;
import java.util.Map;
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

    public static void countNucleotides(Scanner input){
        System.out.print("Enter the sequence: ");
        String sequence = input.nextLine().toUpperCase();
        int length = sequence.length();

        Map<Character, Integer> count = new HashMap<>();

        for (char c :  sequence.toCharArray()){
            if (c == 'A' || c == 'C' || c == 'T' || c == 'G') {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
        }
        System.out.println("Number of Nucleotides: ");
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            System.out.printf("%c: %d - %d%%\n", entry.getKey(), entry.getValue(), entry.getValue() * 100 / length);
        }
    }

    public static void findGene(Scanner input){
        System.out.print("Enter the sequence: ");
        String sequence = input.nextLine().toUpperCase();

        System.out.println("Enter needed gene: ");
        String gene = input.nextLine().toUpperCase();

        if (sequence.contains(gene)){
            System.out.println("Sequence contains gene: " + gene);
        } else {
            System.out.println("Sequence does not contain gene: " + gene);
        }
    }

    public static void complementarySequence(Scanner input){
        System.out.print("Enter the sequence: ");
        String sequence = input.nextLine().toUpperCase();
        int length = sequence.length();

        StringBuilder sb = new StringBuilder(sequence.length());
        for (int i = 0; i < length; i++) {
            char c = sequence.charAt(i);
            switch (c){
                case 'A' :  sb.append("T"); break;
                case 'C' : sb.append("G"); break;
                case 'T' :  sb.append("A"); break;
                case 'G' :  sb.append("C"); break;
                default:
                    System.out.println("Skipped invalid character: " + c);
            }
        }
        System.out.println(sb.reverse().toString());
    }
}
