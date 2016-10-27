import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by kulkarni_my on 10/27/2016.
 */
public class RemoveOddLength {
    public static void main(String[] args) {
        Predicate<Integer> ifOddLength = (Integer x) -> String.valueOf(x).length() % 2 != 0;
        List<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(3123);
        list.add(12333);
        list.add(1423);
        list.add(1243);
        list.add(12223);
        list.add(12333);
        list.removeIf(ifOddLength);
        System.out.println(list);
    }
}
