import java.io.*;

/**
 * Created by kulkarni_my on 10/21/2016.
 */
public class SerializeDemo {
    public static void serialize() throws IOException {
        Account ac = new Account("Mayur", 1, 123.3, new Date(1, 3, 1995));
        FileOutputStream fos = new FileOutputStream(new File("D:/freshersbatch-oct16/JavaFiles/src/test.txt"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ac);
        fos.close();
        oos.close();

    }

    public static void deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(new File("D:/freshersbatch-oct16/JavaFiles/src/test.txt"));
        ObjectInputStream ois = new ObjectInputStream(fis);
        Account ac = (Account) ois.readObject();
        System.out.println(ac);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        deserialize();
    }
}
