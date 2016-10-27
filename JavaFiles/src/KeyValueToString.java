import java.util.HashMap;
import java.util.Map;

/**
 * Created by kulkarni_my on 10/27/2016.
 */
public class KeyValueToString {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Mayur Kulkarni");
        map.put(2, "I am a disco dancer");
        map.put(3, "Jhingalala huhu");
        StringBuilder sb = new StringBuilder();
        StringBuilder xy = new StringBuilder();
        map
                .entrySet()
                .forEach((str) -> sb.append(str.getKey())
                        .append(" ")
                        .append(str.getValue())
                        .append(" ")
                );


        System.out.println(sb.toString());
    }
}
