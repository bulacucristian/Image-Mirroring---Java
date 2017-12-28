import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // test file: C:\Users\Cristi\Desktop\12.bmp

        try {
            BMPMirroring ob = null;
            long startTime = 0;
            long endTime = 0;
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Enter the source file");
            String sourcePath = keyboard.next();

            System.out.println("Enter the destination file");
            String destPath = keyboard.next();

            System.out.println("Enter the type of mirroring you want");
            System.out.println("1 --> X Axis Mirroring");
            System.out.println("2 --> Y Axis Mirroring");
            System.out.println("3 --> XY Axis Mirroring");
            Scanner type = new Scanner(System.in);
            int selection = type.nextInt();

            switch (selection) {
                case 1:
                    ob = new ImageMirroringX(sourcePath);
                    startTime = System.currentTimeMillis();
                    ob.MirrorImage(destPath);
                    endTime = System.currentTimeMillis();
                    break;
                case 2:
                    ob = new ImageMirroringY(sourcePath);
                    startTime = System.currentTimeMillis();
                    ob.MirrorImage(destPath);
                    endTime = System.currentTimeMillis();
                    break;
                case 3:
                    ob = new ImageMirroringXY(sourcePath);
                    startTime = System.currentTimeMillis();
                    ob.MirrorImage(destPath);
                    endTime = System.currentTimeMillis();
                    break;
                default: System.out.println("Invalid decision!");
                         break;
            }

             System.out.println("Image mirroring took " + (endTime - startTime) + " milliseconds");
        } catch (IOException ioe) {
            System.out.println("Exception : " + ioe.getMessage());
        }
    }
}
