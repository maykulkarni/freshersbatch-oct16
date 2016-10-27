import java.util.ArrayList;
import java.util.List;

/**
 * Created by kulkarni_my on 10/27/2016.
 */
public class KeyValueMap<Key extends Number, Value> {
    Key key;
    Value value;
    List<KeyValueMap<? extends Number, Value>> map = new ArrayList<>();

    public KeyValueMap(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public KeyValueMap() {
    }

    @Override
    public String toString() {
        return "KeyValueMap{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public void addValue(Key key, Value value) {
        map.add(new KeyValueMap<Number, Value>(key, value));
    }

    public void printList() {
        for (KeyValueMap keyValueMap : map) {
            System.out.println(keyValueMap);
        }
    }
}

class KeyValueMapDemo {
    public static void main(String[] args) {
        KeyValueMap<Integer, String> map = new KeyValueMap<>();
        map.addValue(1, "xyz");
        map.addValue(2, "mayur");
        map.printList();
    }
}