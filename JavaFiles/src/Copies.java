public class Copies {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date d1 = new Date(12, 14, 1995);
		Date d2 = d1.clone(); // deep
		Date d3 = d1; // shallow 
		d1.printDate();
		d2.printDate();
		d1.setDate(1);
		d1.printDate();
		d2.printDate();
	}
}