import java.io.FileOutputStream;
import java.io.IOException;

public class ImageMirroringXY extends BMPMirroring {

    public ImageMirroringXY(String path) throws IOException {
        super(path);
    }

    public void MirrorImage(String path) throws IOException {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int start = startingAddr + i * width * (bits / 8) + j * (bits / 8);
                int end = startingAddr + (height - i) * width * (bits / 8) - j * (bits / 8) - (bits / 8);
                for (int k = 0; k < (bits / 8); k++) {
                    mirrorContent[end + k] = fileContent[start + k];
                }
            }
        }
        WriteToFile(path);
    }
}
