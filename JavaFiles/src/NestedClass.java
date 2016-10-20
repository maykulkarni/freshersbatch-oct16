import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by kulkarni_my on 10/20/2016.
 */
class Record {
    int id;
    String name;
    String timeStamp;

    Record(int id, String name, String timeStamp) {
        this.id = id;
        this.name = name;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Record ID: " + this.id + " Name: " + this.name + " Inserted on : " + this.timeStamp;
    }
}

public class NestedClass {
    Cache cache;

    NestedClass() {
        this.cache = new Cache();
    }

    public static void main(String[] args) {
        NestedClass nc = new NestedClass();
        Record person = new Record(1, "Mayur", new SimpleDateFormat("MM/dd/yyyy h:mm:s a")
                .format(new Date()));
        nc.insertRecord(person);
        System.out.println(nc.getRecord(1));
    }

    public void insertRecord(Record record) {
        cache.map.put(record.id, record);
    }

    public Record getRecord(int id) {
        return cache.map.get(id);
    }

    private class Cache {
        private int MAX_SIZE = 5;
        private Map<Integer, Record> map;

        Cache() {
            map = new LinkedHashMap<Integer, Record>(MAX_SIZE, 0.75F, false) {
                @Override
                public boolean removeEldestEntry(Map.Entry entry) {
                    if (this.size() > MAX_SIZE) return true;
                    return false;
                }
            };
        }

    }
}
