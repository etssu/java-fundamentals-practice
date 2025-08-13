import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Available modes:\n 1. Invert colors\n 2. Adjust Brightness\n 3. Rotate (90/180/270)\n " +
                "4. Flip (vertical / horizontal)\n 5. Blur\n 6. Display.\n 7. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter image width: ");
        int width = sc.nextInt();
        System.out.print("Enter image height: ");
        int height = sc.nextInt();

        ImageLogic im = new ImageLogic();
        int[][] image = im.getImage(width, height, sc);

        switch (choice) {
            case 1:
                ImageLogic.invertColors(image);
                break;
            case 2:
                break;
            case 7:
                System.out.println("Thank you for using this Image Manipulator.");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }
}