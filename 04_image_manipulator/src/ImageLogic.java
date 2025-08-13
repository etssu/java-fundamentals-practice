import java.util.Scanner;

public class ImageLogic {
    int[][] image;

    public int[][] getImage(int width, int height, Scanner input) {
        image = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                image[i][j] = input.nextInt();
            }
        }
        return image;
    }

    public static void invertColors(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                image[i][j] = 225 - image[i][j]; // find inverted color
                System.out.println(image[i][j]);
            }
            System.out.println();
        }
    }
}
