import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

class FileDatabase {
    RandomAccessFile file;

    public FileDatabase(String fileString)
            throws IOException {
        file = new RandomAccessFile(fileString, "rw");
    }

    public void close() throws IOException {
        if (file != null)
            file.close();
    }

    public PersonRecord getRecord(int id) throws IOException {
        PersonRecord record = new PersonRecord();
        if (id < 1)
            throw new IllegalArgumentException("invalid ID!!");
        file.seek((id - 1) * PersonRecord.SIZE);
        record.readFromFile(file);
        return record;
    }

    public void insertRecord(PersonRecord record) throws IllegalArgumentException, IOException {
        // if (getRecord(record.getId()).getId() != 0)
        //     System.out.println("Cannot add new.Record already exists.");
        //  else {
        file.seek((record.getId() - 1) * PersonRecord.SIZE);
        record.writeToFile(file);
        //   }
    }

    public void updateRecord(PersonRecord record) throws IllegalArgumentException, IOException {
        if (getRecord(record.getId()).getId() == 0)
            System.out.println("Cannot update.Record does not exist.");
        else {
            file.seek((record.getId() - 1) * PersonRecord.SIZE);
            record.writeToFile(file);
        }
    }

    public void deleteRecord(int id) throws IllegalArgumentException, IOException {
        if (id == 0)
            System.out.println("Cannot delete.Record does not exist.");
        else {
            file.seek((id - 1) * PersonRecord.SIZE);
            PersonRecord record = new PersonRecord();
            record.writeToFile(file);
        }
    }

    public void showAllRecords() {
        PersonRecord record = new PersonRecord();
        try {
            file.seek(0);
            while (true) {
                do {
                    record.readFromFile(file);
                } while (record.getId() == 0);
                System.out.println(record.toString());
            }
        } catch (EOFException ex1) {
            return;
        } catch (IOException ex2) {
            System.err.println("Error reading file");
        }
    }
}

public class Test {

    public static void main(String[] args)
            throws IOException {

        FileDatabase fe = new FileDatabase("D:/freshersbatch-oct16/JavaFiles/src/test.txt");

        fe.insertRecord(new PersonRecord(1, "Mayur", "Kulkarni",
                "mk@google.com"));
        fe.insertRecord(new PersonRecord(2, "Ulala", "wegweg",
                "rw@hotmail.com"));
        fe.updateRecord(new PersonRecord(1, "MF", "MK", "asd"));
        fe.showAllRecords();
        //fe.deleteRecord(1);
        fe.showAllRecords();
        fe.close();
    }

}