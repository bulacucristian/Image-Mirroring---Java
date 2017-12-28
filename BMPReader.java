import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BMPReader {

    private FileInputStream inputFile = null;
    protected byte fileContent[];
    protected String path = null;
    protected File file = null;
    long startTime = 0;
    long endTime = 0;

    public BMPReader(String name) {
        path = name;
        file = new File(path);
    }

    public void ReadBytes() throws IOException {
        try {
            startTime = System.currentTimeMillis();
            inputFile = new FileInputStream(file);
            fileContent = new byte[(int) file.length()];
            inputFile.read(fileContent);
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (inputFile != null) {
                inputFile.close();
                endTime = System.currentTimeMillis();
            }
        }
        System.out.println("Reading initial image took " + (endTime - startTime) + " milliseconds");
    }
}
