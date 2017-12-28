import java.io.FileOutputStream;
import java.io.IOException;

abstract class BMPMirroring extends BMPReader {

    protected int startingAddr;
    protected int width;
    protected int height;
    protected int bits;
    protected byte mirrorContent[];

    public BMPMirroring(String path) throws IOException {
        super(path);
        ReadBytes();

        startingAddr = (int) Helper.bytesToLong(fileContent, 10, 4);
        width = (int) Helper.bytesToLong(fileContent, 18, 4);
        height = (int) Helper.bytesToLong(fileContent, 22, 4);
        bits = (int) Helper.bytesToLong(fileContent, 28, 2);

        mirrorContent = new byte[(int) file.length()];

        // Add header to mirrorContent
        for (int i = 0; i < startingAddr; i++) {
            mirrorContent[i] = fileContent[i];
        }
    }

    public abstract void MirrorImage(String path) throws IOException;

    public void WriteToFile(String path) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            fos.write(mirrorContent);
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}


