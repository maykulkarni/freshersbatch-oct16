import java.util.Set;
import java.util.TreeSet;

/**
 * Created by kulkarni_my on 10/26/2016.
 */
public class PersonHashMap {
    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>(new PersonComparator());
        set.add(new Person("Mayur", 70, 170));
        set.add(new Person("Shubh", 68, 170));
        set.add(new Person("Ashish", 68, 123));
        for (Person p : set) {
            System.out.println(p);
        }
    }
}
