public class Employee extends AbstractSortable{
	int id;
	Employee(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(Sortable other) {
		return this.id - ((Employy) other).id;
	}

	@Override
	public String toString() {
		return " Employee with id " + id;
	}
}
}