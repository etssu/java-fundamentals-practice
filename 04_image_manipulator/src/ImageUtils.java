import java.util.Scanner;

public class ImageUtils {
    public static int[][] getImage(Scanner input) {
        // get image size
        int cols = readInt(input, "Enter image width: ");
        int rows = readInt(input, "Enter image height: ");

        // read image
        int[][] image = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                image[i][j] = readPixel(input, i, j);
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
                image[i][j] += difference; // add difference to every pixel
                if (image[i][j] < 0) image[i][j] = 0;
                if (image[i][j] > 255) image[i][j] = 255;
                System.out.printf("%3d ", image[i][j]);
            }
            System.out.println();
        }
    }

    public static void rotateImage(int[][] image, Scanner input) {
        int[][] result = image;

        int degrees = readInt(input, "Enter the rotation angle in degrees (90 / 180 / 270): ");
        int times = degrees / 90;

        for (int k  = 0; k < times; k++) {
            int rows = result.length;
            int cols = result[0].length;
            int[][] rotatedImage = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    //move image
                    rotatedImage[j][rows - 1 - i] = result[i][j];
                }
            }
            result = rotatedImage;
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.printf("%3d ", result[i][j]);
            }
            System.out.println();
        }

    }

    private static int readInt(Scanner input, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return input.nextInt();
            } catch (Exception e) {
                System.out.println("Enter a number next time.");
                input.nextLine(); // clear invalid input
            }
        }
    }

    private static int readPixel(Scanner input, int row, int col) {
        int value = 0;
        while (true) {
            value = readInt(input, String.format("Enter pixel [%d, %d]: ", row+1, col+1));
            if (value < 0){
                System.out.println("Number should be greater than zero.");
            } else if (value > 255){
                System.out.println("Number should be less than or equal to 255.");
            } else {
                break;
            }
        }
        return value;
    }
}
