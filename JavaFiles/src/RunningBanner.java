public class RunningBanner {
	public static void main(String[] args) throws Exception {
		String s = "Welcome to Java ";
		int from = 0;
		while(true) {
			System.out.print(s.substring(from, s.length()) + s.substring(0, from) + "\r");
			from++;
			if (from == s.length() - 1) {
				from = 0;
			}
			Thread.sleep(100);
		}
	}
}