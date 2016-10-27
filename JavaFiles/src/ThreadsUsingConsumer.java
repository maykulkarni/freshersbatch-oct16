import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kulkarni_my on 10/27/2016.
 */
public class ThreadsUsingConsumer {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(14);
        list.add(551);
        list.add(1234);
        list.add(231);
        list.add(2341);
        list.add(1423);
        list.add(2341);
        list.add(12);
        list = Collections.synchronizedList(list);
        List<Integer> anotherList = list;
        new Thread() {
            @Override
            public void run() {
                anotherList.forEach(System.out::println);
            }
        }.start();
    }
}
