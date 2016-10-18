public class PersistenceFactory {
	public static Persistence getPersistenceInstance() {
		return new FilePersistence();
	}
}