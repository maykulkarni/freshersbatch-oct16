import java.io.IOException;
import java.io.RandomAccessFile;

public class PersonRecord extends Person {

    public static final int SIZE =
            Integer.BYTES + (3 * (Character.BYTES * 15));

    public PersonRecord() {
        this(0, "", "", "");
    }

    public PersonRecord(int id, String name,
                        String phone, String email) {
        super(id, name, phone, email);
    }

    public void readFromFile(RandomAccessFile file) throws IOException {
        setId(file.readInt());
        setName(readString(file));
        setPhone(readString(file));
        setEmail(readString(file));
    }

    public void writeToFile(RandomAccessFile file) throws IOException {
        file.writeInt(getId());
        writeString(file, getName());
        writeString(file, getPhone());
        writeString(file, getEmail());
    }

    private String readString(RandomAccessFile file) throws IOException {
        char[] s = new char[15];
        for (int i = 0; i < s.length; i++)
            s[i] = file.readChar();
        return new String(s).replace('\0', ' ');
    }

    private void writeString(RandomAccessFile file, String s) throws IOException {
        StringBuffer buffer = null;
        if (s != null)
            buffer = new StringBuffer(s);
        else
            buffer = new StringBuffer(15);
        buffer.setLength(15);
        file.writeChars(buffer.toString());
    }

}