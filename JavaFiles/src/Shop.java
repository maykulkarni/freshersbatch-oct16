import java.util.Scanner;
public class Shop {
	private static int iceCreamCount = 0;
	private static int candyCount = 0;
	private static int cookieCount = 0;

	private static void modifyCount(DesertItem item, int quantity) {
		if (item instanceof IceCream) {
			iceCreamCount += quantity;
		} else if (item instanceof Candy) {
			candyCount += quantity;
		} else if (item instanceof Cookie) {
			cookieCount += quantity;
		}
	}

	public static void modifyCount(Person person, DesertItem item, int quantity) {
		if (person instanceof Owner) {
			modifyCount(item, quantity);
			System.out.println("Succesfully modified count");
		} else {
			System.out.println("Only owner can modify!");
		}
	}

	public static void placeOrder(DesertItem item, int quantity) {
		System.out.println("Your order costs : " + item.price() * quantity);
		
	}

	public static void main(String[] args) {
		Person owner = new Owner();
		Person customer = new Customer();
		System.out.println("Enter role");
		Scanner in = new Scanner(System.in);
		if (in.nextLine().equalsIgnoreCase("owner")) {
			DesertItem item = null;
			System.out.println("Enter item");
			String itemEntered = in.nextLine();
			if (itemEntered.equalsIgnoreCase("cookie")) {
				item = new Cookie();
			} else if (itemEntered.equalsIgnoreCase("candy")) {
				item = new Candy();
			} else if (itemEntered.equalsIgnoreCase("ice cream")) {
				item = new IceCream();
			}
			System.out.println("Enter quantity");
			modifyCount(owner, item, in.nextInt());
		} else {
			System.out.println("Enter order");
			DesertItem item = null;
			String itemEntered = in.nextLine();
			if (itemEntered.equalsIgnoreCase("cookie")) {
				item = new Cookie();
			} else if (itemEntered.equalsIgnoreCase("candy")) {
				item = new Candy();
			} else if (itemEntered.equalsIgnoreCase("ice cream")) {
				item = new IceCream();
			}
			System.out.println("Enter quantity");
			placeOrder(item, in.nextInt());
		}
	}
}