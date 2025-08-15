import java.util.Scanner;

public class InputHandler {
    Scanner sc = new Scanner(System.in);

    public void ImageController() {
        while (true) {
            System.out.print("Available modes:\n 1. Invert colors\n 2. Adjust Brightness\n 3. Rotate\n " +
                    "4. Flip (vertical / horizontal)\n 5. Blur\n 6. Display.\n 7. Exit\n");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            int[][] image;

            switch (choice) {
                case 1:
                    image = ImageUtils.getImage(sc);
                    ImageUtils.invertColors(image);
                    break;
                case 2:
                    image = ImageUtils.getImage(sc);
                    System.out.print("Enter brightness adjustment (-255 to 255): ");
                    int difference = sc.nextInt();

                    ImageUtils.adjustBrightness(image, difference);
                    break;
                case 3:
                    image = ImageUtils.getImage(sc);

                    ImageUtils.rotateImage(image, sc);
                    break;
                case 4:
                    image = ImageUtils.getImage(sc);

                    ImageUtils.flipImage(image, sc);
                    break;
                case 5:
                    image = ImageUtils.getImage(sc);

                    ImageUtils.blurImage(image);
                    break;
                case 6:
                    image = ImageUtils.getImage(sc);

                    ImageUtils.displayImage(image);
                    break;
                case 7:
                    System.out.println("Thank you for using Image Manipulator.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
