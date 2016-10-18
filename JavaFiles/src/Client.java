public class Client {
	public static void main(String[] args) {
		Persistence per = PersistenceFactory.getPersistenceInstance();
		per.persist();
	}
}