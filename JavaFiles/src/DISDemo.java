import java.io.*;

/**
 * Created by kulkarni_my on 10/21/2016.
 */
public class DISDemo {
    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("D:/freshersbatch-oct16/JavaFiles/src/test1.txt"));
        DataInputStream dis = new DataInputStream(new FileInputStream("D:/freshersbatch-oct16/JavaFiles/src/test1.txt"));
        Account account = new Account("Mayur", 1, 3123.2, new Date(1, 1, 1));
        StringBuilder toWrite = new StringBuilder();
        dos.writeUTF(account.getAccountName());
        dos.writeInt(account.getAccountID());
        dos.writeDouble(account.getBalance());
        System.out.println("Written to test1.txt");
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readDouble());
    }
}
