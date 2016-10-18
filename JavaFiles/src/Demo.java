public class Demo {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[4];
		shapes[0] = new Line();
		shapes[1] = new Point();
		shapes[2] = new Rectangle();
		shapes[3] = new Circle();
		for (Shape currentShape : shapes) {
			currentShape.draw();
		}
	}
}