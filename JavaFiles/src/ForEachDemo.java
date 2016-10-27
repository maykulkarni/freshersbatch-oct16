import java.util.ArrayList;
import java.util.List;

/**
 * Created by kulkarni_my on 10/27/2016.
 */
public class ForEachDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Mayur");
        list.add("bakayaro");
        list.add("uchiha");
        StringBuilder sb = new StringBuilder();
        list.forEach((str) -> sb.append(str.charAt(0)));
        System.out.println(sb);
    }
}
