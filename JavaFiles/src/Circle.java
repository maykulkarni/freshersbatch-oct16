public class Circle implements Sortable {
	int radius;
	Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public int compareTo(Sortable other) {
		return this.radius - ((Circle) other).radius;
	}

	@Override
	public String toString() {
		return " Circle with radius " + radius;
	}
}