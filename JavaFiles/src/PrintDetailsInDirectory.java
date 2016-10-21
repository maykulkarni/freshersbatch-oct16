import java.io.File;
import java.util.Date;

/**
 * Created by kulkarni_my on 10/21/2016.
 */
public class PrintDetailsInDirectory {
    public static void main(String[] args) {
        File folder = new File("D:/freshersbatch-oct16/JavaFiles/src");
        File[] files = folder.listFiles();
        for (File currentFile : files) {
            System.out.println("File name : " + currentFile.getName());
            System.out.println("File size : " + currentFile.length());
            System.out.println("File date : " + new Date(currentFile.lastModified()));
            System.out.println("File permissions : " + (currentFile.canRead() ? "Readable " : "Not Readable ") +
                    (currentFile.canWrite() ? "Writeable " : "Not Writeable ") + (currentFile.canExecute() ? "Executable " : "Not Executeable "));
            System.out.println(currentFile.isDirectory() ? "Is a Directory" : "Is a file");
            System.out.println("*******************");
        }
    }

}
