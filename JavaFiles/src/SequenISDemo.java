import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

/**
 * Created by kulkarni_my on 10/21/2016.
 */
public class SequenISDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream test1 = new FileInputStream(new File("D:/freshersbatch-oct16/JavaFiles/src/test1.txt"));
        FileInputStream test = new FileInputStream(new File("D:/freshersbatch-oct16/JavaFiles/src/test.txt"));
        SequenceInputStream sis = new SequenceInputStream(test, test1);
        int i;
        while ((i = sis.read()) != -1) {
            System.out.print((char) i);
        }
    }
}
