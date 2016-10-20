import java.util.ArrayList;
import java.util.List;

/**
 * Created by kulkarni_my on 10/20/2016.
 */
public class Partitions {
    static List<List<List<Integer>>> list = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> base_ = new ArrayList<>();
        List<Integer> base = new ArrayList<>();
        base.add(3);
        base.add(1);
        base_.add(base);
        list.add(base_);
        int currCtr = 3;
        while (currCtr < 10) {
            List<List<Integer>> currList = list.get(list.size() - 1);
            List<List<Integer>> listToAdd = new ArrayList<>();
            List<Integer> toAddList;
            for (int k = 0; k < currList.size(); k++) {
                List<Integer> curr = currList.get(k);
                // First entry
                if (k == 0) {
                    toAddList = new ArrayList<>();
                    for (int ints : curr) {
                        toAddList.add(ints);
                    }
                    toAddList.set(0, toAddList.get(0) + 1);
                    listToAdd.add(toAddList);
                }
                for (int i = 1; i < curr.size(); i++) {
                    if (curr.get(i) + 1 < curr.get(i - 1)) {
                        toAddList = new ArrayList<>();
                        for (int ints : curr) {
                            toAddList.add(ints);
                        }
                        toAddList.set(i, toAddList.get(i) + 1);
                        listToAdd.add(toAddList);
                    }
                }

            }
            list.add(listToAdd);
            currCtr++;
            for (List<Integer> list : listToAdd) {
                System.out.println(list);
            }
            System.out.println("********************");
        }
    }
}
