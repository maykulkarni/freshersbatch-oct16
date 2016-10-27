import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by kulkarni_my on 10/26/2016.
 */
public class FailSafeFailFast {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new SecureRandom().nextInt());
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
    }
}
