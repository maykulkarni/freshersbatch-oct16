import java.util.Comparator;
public class NameComparator implements Comparator<Person> {
	@Override
	public int compare(Person one, Person two) {
		String nameOne = one.getName();
		String nameTwo = two.getName();
		int ctr = 0;
		while (ctr < nameOne.length() && ctr < nameTwo.length()) {
			if (nameOne.charAt(ctr) > nameTwo.charAt(ctr)) {
				return 1;
			} else if (nameOne.charAt(ctr) < nameTwo.charAt(ctr)) {
				return -1;
			} else {
				ctr++;
			}
		}
		return 0;
	}
}