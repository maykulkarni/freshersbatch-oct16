import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by kulkarni_my on 10/21/2016.
 */
public class ReadAndWriteToFile {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/freshersbatch-oct16/JavaFiles/src/test.txt");
        FileInputStream fos = new FileInputStream(file);
        int i;
        StringBuilder sb = new StringBuilder();
        while ((i = fos.read()) != -1) {
            sb.append((char) i);
        }
        File file1 = new File("D:/freshersbatch-oct16/JavaFiles/src/test1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        fileOutputStream.write(sb.toString().getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
        fos.close();
    }
}
