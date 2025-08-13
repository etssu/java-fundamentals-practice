import java.util.Scanner;

public class ImageUtils {
    public static int[][] getImage(Scanner input) {
        // get image size
        System.out.print("Enter image width: ");
        int cols = input.nextInt();
        System.out.print("Enter image height: ");
        int rows = input.nextInt();

        int[][] image = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Enter pixel [%d, %d]: ", i+1, j+1);
                image[i][j] = input.nextInt();
            }
        }
        return image;
    }

    public static void invertColors(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                image[i][j] = 255 - image[i][j]; // find inverted color
                System.out.printf("%3d ", image[i][j]);
            }
            System.out.println();
        }
    }

    public static void adjustBrightness(int[][] image, int difference) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                image[i][j] += difference;
                if (image[i][j] < 0) image[i][j] = 0;
                if (image[i][j] > 255) image[i][j] = 255;
                System.out.printf("%3d ", image[i][j]);
            }
            System.out.println();
        }
    }
}
