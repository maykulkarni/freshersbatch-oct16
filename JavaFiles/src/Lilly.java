import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kulkarni_my on 11/3/2016.
 */
public class Lilly {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(in.nextLong());
        }
        new LillySolver().solve(list);
    }
}

class LillySolver {
    public void solve(List<Long> list) {
        List<Long> clone = new ArrayList<Long>(list);
        Collections.sort(list);
        int asc = 0;
        int desc = 0;

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(clone.get(i))) asc++;
        }
        list.sort(Collections.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(clone.get(i))) desc++;
        }

        System.out.println((Math.min(asc, desc) - 1) == -1 ? 0 : Math.min(asc, desc) - 1);
    }
}