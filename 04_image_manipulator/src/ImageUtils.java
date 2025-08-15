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
            }
        }
        displayImage(image);
    }

    public static void adjustBrightness(int[][] image, int difference) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                image[i][j] += difference; // add difference to every pixel
                if (image[i][j] < 0) image[i][j] = 0;
                if (image[i][j] > 255) image[i][j] = 255;
            }
        }
        displayImage(image);
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

        displayImage(result);
    }

    public static void flipImage(int[][] image, Scanner input) {
        int rows = image.length;
        int cols = image[0].length;

        int[][] flippedImage = new int[rows][cols];
        // create a deep copy of the image
        for (int i = 0; i < rows; i++) {
            System.arraycopy(image[i], 0, flippedImage[i], 0, cols);
        }

        while (true) {
            input.nextLine(); // clear input
            System.out.print("Enter mode(vertical/horizontal): ");
            String choice = input.nextLine();

            // flip image vertically
            if (choice.equalsIgnoreCase("vertical")) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols / 2; j++) {
                        int temp = flippedImage[i][j];
                        flippedImage[i][j] = flippedImage[i][cols - 1 - j];
                        flippedImage[i][cols - 1 - j] = temp;
                    }
                }
                break;
            }
            // flip image horizontally
            else if (choice.equalsIgnoreCase("horizontal")) {
                for (int i = 0; i < rows / 2; i++) {
                    for (int j = 0; j < cols; j++) {
                        int temp = flippedImage[i][j];
                        flippedImage[i][j] = flippedImage[rows - 1 - i][j];
                        flippedImage[rows - 1 - i][j] = temp;
                    }
                }
                break;
            } else {
                System.out.println("Wrong choice. Try again.");
            }
        }
        displayImage(flippedImage);
    }

    public static void blurImage(int[][] image){
        int rows = image.length;
        int cols = image[0].length;
        int[][] blurredImage = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                int count = 0;

                // searching 3x3 blocks
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        int ni = i + di;
                        int nj = j + dj;

                        // checking
                        if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                            sum += image[ni][nj];
                            count++;
                        }
                    }
                }
                blurredImage[i][j] = sum / count; // average
            }
        }
        displayImage(blurredImage);
    }

    public static void displayImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.printf("%3d ", pixel);
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
