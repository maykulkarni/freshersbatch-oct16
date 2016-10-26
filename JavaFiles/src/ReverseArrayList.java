import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by kulkarni_my on 10/26/2016.
 */
public class ReverseArrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(1232);
        list.add(23);
        list.add(87);
        ListIterator<Integer> li = list.listIterator(list.size());
        while (li.hasPrevious()) {
            System.out.println(li.previous());
        }
    }
}
