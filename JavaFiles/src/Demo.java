import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class Demo {
	public static void main(String[] args) {
		List<Person> pers = new ArrayList<>();
		pers.add(new Person(1, "Mayur"));
		pers.add(new Person(7, "Ashish"));
		pers.add(new Person(3, "Shubham"));
		pers.add(new Person(10, "Nishant"));
		pers.add(new Person(5, "Mohit"));
		System.out.println(pers);
		Collections.sort(pers, new NameComparator());
		System.out.println(pers);
	}
}