import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kulkarni_my on 10/21/2016.
 */
public class Repetition {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 3, 4, 5, 5, 6, 7, 7,};
        int rep = 2;
        new Solver().solve(new int[]{1, 4, 3, 3, 5, 6, 5, 5, 99, 100}, 2);
    }
}

class Solver {

    public void solve(int[] arr, int rep) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            if ((Integer) entry.getValue() <= rep) {
                for (int i = 0; i < (Integer) entry.getValue(); i++) {
                    list.add((Integer) entry.getKey());
                }

            }
        }
        System.out.println(list);
    }
}