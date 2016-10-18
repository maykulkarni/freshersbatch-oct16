public class DatabasePersistence extends Persistence {
	@Override
	public void persist() {
		System.out.println("Persisting on Database");
	}
}