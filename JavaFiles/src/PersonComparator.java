import java.util.Comparator;

/**
 * Created by kulkarni_my on 10/26/2016.
 */
public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.weight - o2.weight != 0) {
            return o1.weight - o2.weight;
        } else {
            return o1.height - o2.height;
        }
    }
}
