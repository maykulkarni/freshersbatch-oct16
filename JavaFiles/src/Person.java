public class Person {
	public int id;
	public String name;
	Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return this.id + " " + this.name;
	}
}